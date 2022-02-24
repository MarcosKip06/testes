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

import com.desafioapi.dto.senador.ConsultaSenadorDTO;
import com.desafioapi.dto.senador.RegistroSenadorDTO;
import com.desafioapi.dto.senador.SenadorMapper;
import com.desafioapi.models.Senador;
import com.desafioapi.services.SenadorService;

@RestController
@RequestMapping("v1/senadores")
public class SenadorController {
	
	private final SenadorService senadorService;

	public SenadorController(SenadorService senadorService) {
		this.senadorService = senadorService;
	}
	

	@GetMapping
	public ResponseEntity<Page<ConsultaSenadorDTO>> buscarTodosOsSenadores(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(senadorService.listarTodosOsSenadores(pageable).map(SenadorMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaSenadorDTO> salvarSenador(@RequestBody @Valid RegistroSenadorDTO dto){
		Senador senador = senadorService.salvarSenador(SenadorMapper.fromDTO(dto));
		return ResponseEntity.ok(SenadorMapper.fromEntity(senador));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaSenadorDTO> buscarSenador(@PathVariable Long id){
		Senador senador = senadorService.buscarSenador(id);
		return ResponseEntity.ok(SenadorMapper.fromEntity(senador));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaSenadorDTO> alterarSenador(@RequestBody RegistroSenadorDTO dto, @PathVariable Long id){
		try {
			Senador senador = senadorService.atualizarSenador(SenadorMapper.fromDTO(dto), id);
			return ResponseEntity.ok(SenadorMapper.fromEntity(senador));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaSenadorDTO> excluirSenador(@PathVariable Long id){
		try {
			senadorService.excluirSenador(id);
			return ResponseEntity.ok().build();
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	

}
