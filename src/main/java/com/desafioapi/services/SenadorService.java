package com.desafioapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioapi.exception.EntityNotFoundException;
import com.desafioapi.models.Senador;
import com.desafioapi.repositories.SenadorRepository;

@Service
public class SenadorService {
	
	private final SenadorRepository senadorRepository;

	public SenadorService(SenadorRepository senadorRepository) {
		this.senadorRepository = senadorRepository;
	}
	

	public Senador salvarSenador(Senador senador) {
		return senadorRepository.save(senador);
	}
	
	public Page<Senador> listarTodosOsSenadores(Pageable pageable){
		return senadorRepository.findAll(pageable);
	}
	
	public Senador buscarSenador(Long id) {
		Optional<Senador>optional = senadorRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Senador não encontrado!"));
	}
	
	public Senador atualizarSenador(Senador senador, Long id) {
		Senador senadorOriginal = this.buscarSenador(id);
		senador.setId(senadorOriginal.getId());
		return senadorRepository.save(senador);
	}
	
	public void excluirSenador(Long id) {
		Senador senadorOriginal = this.buscarSenador(id);
		senadorRepository.delete(senadorOriginal);
	}
	
	

}
