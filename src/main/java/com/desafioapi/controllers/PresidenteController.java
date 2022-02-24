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

import com.desafioapi.dto.presidente.ConsultaPresidenteDTO;
import com.desafioapi.dto.presidente.PresidenteMapper;
import com.desafioapi.dto.presidente.RegistroPresidenteDTO;
import com.desafioapi.models.Presidente;
import com.desafioapi.services.PresidenteService;

@RestController
@RequestMapping("v1/presidentes")
public class PresidenteController {
	
	private final PresidenteService presidenteService;

	public PresidenteController(PresidenteService presidenteService) {
		this.presidenteService = presidenteService;
	}
	

	@GetMapping
	public ResponseEntity<Page<ConsultaPresidenteDTO>> buscarTodosOsPresidente(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(presidenteService.listarTodosOsPresidentes(pageable).map(PresidenteMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaPresidenteDTO> salvarPresidente(@RequestBody @Valid RegistroPresidenteDTO dto){
		Presidente presidente = presidenteService.salvarPresidente(PresidenteMapper.fromDTO(dto));
		return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaPresidenteDTO> buscarPresidente(@PathVariable Long id){
		Presidente presidente = presidenteService.buscarPresidente(id);
		return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaPresidenteDTO> alterarPresidente(@RequestBody RegistroPresidenteDTO dto, @PathVariable Long id){
		try {
			Presidente presidente = presidenteService.atualizarPresidente(PresidenteMapper.fromDTO(dto), id);
			return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaPresidenteDTO> excluirPresidente(@PathVariable Long id){
		try {
			presidenteService.excluirPresidente(id);
			return ResponseEntity.ok().build();
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	

}
