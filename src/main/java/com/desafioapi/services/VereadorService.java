package com.desafioapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioapi.exception.EntityNotFoundException;
import com.desafioapi.models.Vereador;
import com.desafioapi.repositories.VereadorRepository;

@Service
public class VereadorService {
	
	private final VereadorRepository vereadorRepository;

	public VereadorService(VereadorRepository vereadorRepository) {
		this.vereadorRepository = vereadorRepository;
	}
	
	public Vereador salvarVereador(Vereador vereador) {
		return vereadorRepository.save(vereador);
	}
	
	public Page<Vereador> listarTodosOsVereadores(Pageable pageable){
		return vereadorRepository.findAll(pageable);
	}
	
	public Vereador buscarVereador(Long id) {
		Optional<Vereador>optional = vereadorRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Vereador não encontrado!"));
	}
	
	public Vereador atualizarVereador(Vereador vereador, Long id) {
		Vereador vereadorOriginal = this.buscarVereador(id);
		vereador.setId(vereadorOriginal.getId());
		return vereadorRepository.save(vereador);
	}
	
	public void excluirVereador(Long id) {
		Vereador vereadorOriginal = this.buscarVereador(id);
		vereadorRepository.delete(vereadorOriginal);
	}
	
	
	

}
