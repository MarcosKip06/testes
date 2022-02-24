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

import com.desafioapi.dto.vereador.ConsultaVereadorDTO;
import com.desafioapi.dto.vereador.RegistroVereadorDTO;
import com.desafioapi.dto.vereador.VereadorMapper;
import com.desafioapi.models.Vereador;
import com.desafioapi.services.VereadorService;

@RestController
@RequestMapping("v1/vereadores")
public class VereadorController {
	
	private final VereadorService vereadorService;

	public VereadorController(VereadorService vereadorService) {
		this.vereadorService = vereadorService;
	}
	
	@GetMapping()
	public ResponseEntity<Page<ConsultaVereadorDTO>> buscarTodosOsVereadores(@PageableDefault (size=3) Pageable pageable){
		return ResponseEntity.ok(vereadorService.listarTodosOsVereadores(pageable).map(VereadorMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaVereadorDTO> salvarVereador(@RequestBody @Valid RegistroVereadorDTO dto){
		Vereador vereador = vereadorService.salvarVereador(VereadorMapper.fromDTO(dto));
		return ResponseEntity.ok(VereadorMapper.fromEntity(vereador));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaVereadorDTO> buscarVereador(@PathVariable Long id){
		Vereador vereador = vereadorService.buscarVereador(id);
		return ResponseEntity.ok(VereadorMapper.fromEntity(vereador));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaVereadorDTO> alterarVereador(@RequestBody RegistroVereadorDTO dto, @PathVariable Long id){
		try {
			Vereador vereador = vereadorService.atualizarVereador(VereadorMapper.fromDTO(dto), id);
			return ResponseEntity.ok(VereadorMapper.fromEntity(vereador));
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<ConsultaVereadorDTO> excluirVereador(@PathVariable Long id){
		try {
			vereadorService.excluirVereador(id);
			return ResponseEntity.ok().build();
		}catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
