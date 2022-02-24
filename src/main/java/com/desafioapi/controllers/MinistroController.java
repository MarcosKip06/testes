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

import com.desafioapi.dto.ministro.ConsultaMinistroDTO;
import com.desafioapi.dto.ministro.MinistroMapper;
import com.desafioapi.dto.ministro.RegistroMinistroDTO;
import com.desafioapi.models.Ministro;
import com.desafioapi.services.MinistroService;

@RestController
@RequestMapping("v1/ministros")
public class MinistroController {
	
	private final MinistroService ministroService;

	public MinistroController(MinistroService ministroService) {
		this.ministroService = ministroService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaMinistroDTO>> listarTodosOsMinistro(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(ministroService.listarTodosOsMinistros(pageable).map(MinistroMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaMinistroDTO> salvarMinistro(@RequestBody @Valid RegistroMinistroDTO dto){
		Ministro ministro = ministroService.salvarMinistro(MinistroMapper.fromDTO(dto));
		return ResponseEntity.ok(MinistroMapper.fromEntity(ministro));
	}
	

	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaMinistroDTO> buscarMinistro(@PathVariable Long id){
		Ministro ministro = ministroService.buscarMinistro(id);
		return ResponseEntity.ok(MinistroMapper.fromEntity(ministro));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaMinistroDTO> alterarMinistro(@RequestBody RegistroMinistroDTO dto, @PathVariable Long id){
		try {
			Ministro ministro = ministroService.atualizarMinistro(MinistroMapper.fromDTO(dto), id);
			return ResponseEntity.ok(MinistroMapper.fromEntity(ministro));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaMinistroDTO> excluirMinistro(@PathVariable Long id){
		try {
			ministroService.excluirMinistro(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	

}
