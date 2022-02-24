package com.desafioapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioapi.exception.EntityNotFoundException;
import com.desafioapi.models.Prefeito;
import com.desafioapi.repositories.PrefeitoRepository;

@Service
public class PrefeitoService {
	
	private final PrefeitoRepository prefeitoRepository;

	public PrefeitoService(PrefeitoRepository prefeitoRepository) {
		this.prefeitoRepository = prefeitoRepository;
	}
	

	public Prefeito salvarPrefeito(Prefeito prefeito) {
		return prefeitoRepository.save(prefeito);
	}
	
	public Page<Prefeito> listarTodosOsPrefeitos(Pageable pageable){
		return prefeitoRepository.findAll(pageable);
	}
	
	public Prefeito buscarPrefeito(Long id) {
		Optional<Prefeito>optional = prefeitoRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Prefeito não encontrado!"));
	}
	
	public Prefeito atualizarPrefeito(Prefeito prefeito, Long id) {
		Prefeito prefeitoOriginal = this.buscarPrefeito(id);
		prefeito.setId(prefeitoOriginal.getId());
		return prefeitoRepository.save(prefeito);
	}
	
	public void excluirPrefeito(Long id) {
		Prefeito prefeitoOriginal = this.buscarPrefeito(id);
		prefeitoRepository.delete(prefeitoOriginal);
	}
	

}
