package com.desafioapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioapi.exception.EntityNotFoundException;
import com.desafioapi.models.Ministro;
import com.desafioapi.repositories.MinistroRepository;

@Service
public class MinistroService {
	
	private final MinistroRepository ministroRepository;

	public MinistroService(MinistroRepository ministroRepository) {
		this.ministroRepository = ministroRepository;
	}
	
	public Ministro salvarMinistro(Ministro ministro) {
		return ministroRepository.save(ministro);
	}
	
	public Page<Ministro> listarTodosOsMinistros(Pageable pageable){
		return ministroRepository.findAll(pageable);
	}
	
	public Ministro buscarMinistro(Long id) {
		Optional<Ministro> optional = ministroRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Ministro não encontrado"));
	}
	
	public Ministro atualizarMinistro(Ministro ministro, Long id) {
		Ministro ministroOriginal = this.buscarMinistro(id);
		ministro.setId(ministroOriginal.getId());
		return ministroRepository.save(ministro);
	}
	
	public void excluirMinistro(Long id) {
		Ministro ministroOriginal = this.buscarMinistro(id);
		ministroRepository.delete(ministroOriginal);
	}
	
	

}
