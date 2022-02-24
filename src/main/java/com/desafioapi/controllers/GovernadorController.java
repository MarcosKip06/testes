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

import com.desafioapi.dto.governador.ConsultaGovernadorDTO;
import com.desafioapi.dto.governador.GovernadorMapper;
import com.desafioapi.dto.governador.RegistroGovernadorDTO;
import com.desafioapi.models.Governador;
import com.desafioapi.services.GovernadorService;

@RestController
@RequestMapping("v1/governadores")
public class GovernadorController {
	
	private final GovernadorService governadorService;

	public GovernadorController(GovernadorService governadorService) {
		this.governadorService = governadorService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaGovernadorDTO>> buscarTodosOsGovernadores(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(governadorService.listarTodosOsGovernadores(pageable).map(GovernadorMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaGovernadorDTO> salvarGovernador(@RequestBody @Valid RegistroGovernadorDTO dto){
		Governador governador = governadorService.salvarGovernador(GovernadorMapper.fromDTO(dto));
		return ResponseEntity.ok(GovernadorMapper.fromEntity(governador));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaGovernadorDTO> buscarGovernador(@PathVariable Long id){
		Governador governador = governadorService.buscarGovernador(id);
		return ResponseEntity.ok(GovernadorMapper.fromEntity(governador));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaGovernadorDTO> alterarGovernador(@RequestBody RegistroGovernadorDTO dto, @PathVariable Long id){
		try {
			Governador governador = governadorService.atualizarGovernador(GovernadorMapper.fromDTO(dto), id);
			return ResponseEntity.ok(GovernadorMapper.fromEntity(governador));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaGovernadorDTO> excluirGovernador(@PathVariable Long id){
		try {
			governadorService.excluirGovernador(id);
			return ResponseEntity.ok().build();
		}catch (RuntimeException ex) {
		return ResponseEntity.notFound().build();
		}
	}

	
	
	

}
