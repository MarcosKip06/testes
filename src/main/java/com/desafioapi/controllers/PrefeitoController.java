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

import com.desafioapi.dto.prefeito.ConsultaPrefeitoDTO;
import com.desafioapi.dto.prefeito.PrefeitoMapper;
import com.desafioapi.dto.prefeito.RegistroPrefeitoDTO;
import com.desafioapi.models.Prefeito;
import com.desafioapi.services.PrefeitoService;

@RestController
@RequestMapping("v1/prefeitos")
public class PrefeitoController {
	
	private final PrefeitoService prefeitoService;

	public PrefeitoController(PrefeitoService prefeitoService) {
		this.prefeitoService = prefeitoService;
	}
	

	@GetMapping
	public ResponseEntity<Page<ConsultaPrefeitoDTO>> buscarTodosOsPrefeitos(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(prefeitoService.listarTodosOsPrefeitos(pageable).map(PrefeitoMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaPrefeitoDTO> salvarPrefeito(@RequestBody @Valid RegistroPrefeitoDTO dto){
		Prefeito prefeito = prefeitoService.salvarPrefeito(PrefeitoMapper.fromDTO(dto));
		return ResponseEntity.ok(PrefeitoMapper.fromEntity(prefeito));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaPrefeitoDTO> buscarPrefeito(@PathVariable Long id){
		Prefeito prefeito = prefeitoService.buscarPrefeito(id);
		return ResponseEntity.ok(PrefeitoMapper.fromEntity(prefeito));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaPrefeitoDTO> alterarPrefeito(@RequestBody RegistroPrefeitoDTO dto, @PathVariable Long id){
		try {
			Prefeito prefeito = prefeitoService.atualizarPrefeito(PrefeitoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(PrefeitoMapper.fromEntity(prefeito));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaPrefeitoDTO> excluirPrefeito(@PathVariable Long id){
		try {
			prefeitoService.excluirPrefeito(id);
			return ResponseEntity.ok().build();
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
