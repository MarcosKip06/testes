package com.desafioapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioapi.exception.EntityNotFoundException;
import com.desafioapi.models.Governador;
import com.desafioapi.repositories.GovernadorRepository;

@Service
public class GovernadorService {
	
	private final GovernadorRepository governadorRepository;
	
	public GovernadorService(GovernadorRepository governadorRepository) {
		this.governadorRepository = governadorRepository;
	}

	public Governador salvarGovernador(Governador governador) {
		return governadorRepository.save(governador);
	}
	
	public Page<Governador> listarTodosOsGovernadores(Pageable pageable){
		return governadorRepository.findAll(pageable);
	}
	
	public Governador buscarGovernador(Long id) {
		Optional<Governador> optional = governadorRepository.findById(id);
		 return optional.orElseThrow(() -> new EntityNotFoundException("Governador não encontrado!"));
	}
	
	public Governador atualizarGovernador(Governador governador, Long id) {
		Governador governadorOriginal = this.buscarGovernador(id);
		governador.setId(governadorOriginal.getId());
		return governadorRepository.save(governador);
	}
	
	public void excluirGovernador(Long id) {
		Governador governadorOriginal = this.buscarGovernador(id);
		governadorRepository.delete(governadorOriginal);
	}

}
