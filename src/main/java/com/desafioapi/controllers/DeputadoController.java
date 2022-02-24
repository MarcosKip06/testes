package com.desafioapi.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioapi.dto.deputado.ConsultaDeputadoDTO;
import com.desafioapi.dto.deputado.DeputadoMapper;
import com.desafioapi.dto.deputado.RegistroDeputadoDTO;
import com.desafioapi.models.Deputado;
import com.desafioapi.services.DeputadoService;

@RestController
@RequestMapping("v1/deputados")
public class DeputadoController {
	
	private final DeputadoService deputadoService;

	public DeputadoController(DeputadoService deputadoService) {
		this.deputadoService = deputadoService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaDeputadoDTO>> buscarTodosOsDeputados(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(deputadoService.listarTodosOsDeputados(pageable).map(DeputadoMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaDeputadoDTO> salvarDeputado(@RequestBody @Valid RegistroDeputadoDTO dto){
		Deputado deputado = deputadoService.salvarDeputado(DeputadoMapper.fromDTO(dto));
		return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaDeputadoDTO> buscarDeputado(@PathVariable Long id){
		Deputado deputado = deputadoService.buscarDeputado(id);
		return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaDeputadoDTO> alterarDeputado(@RequestBody RegistroDeputadoDTO dto, @PathVariable Long id){
		try {
			Deputado deputado = deputadoService.atualizarDeputado(DeputadoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaDeputadoDTO> excluirDeputado(@PathVariable Long id){
		try {
			deputadoService.excluirDeputado(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
