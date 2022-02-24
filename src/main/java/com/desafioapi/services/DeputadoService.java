package com.desafioapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioapi.exception.EntityNotFoundException;
import com.desafioapi.models.Deputado;
import com.desafioapi.repositories.DeputadoRepository;

@Service
public class DeputadoService {
	
	private final DeputadoRepository deputadoRepository;

	public DeputadoService(DeputadoRepository deputadoRepository) {
		this.deputadoRepository = deputadoRepository;
	}
	
	public Deputado salvarDeputado(Deputado deputado) {
		return deputadoRepository.save(deputado);
	}
	
	public Page<Deputado> listarTodosOsDeputados(Pageable pageable){
		return deputadoRepository.findAll(pageable);
	}
	
	public Deputado buscarDeputado(Long id) {
		Optional<Deputado> optional = deputadoRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Deputado não encontrado!"));
	}
	
	public Deputado atualizarDeputado(Deputado deputado, Long id) {
		Deputado deputadoOriginal = this.buscarDeputado(id);
		deputado.setId(deputadoOriginal.getId());
		return deputadoRepository.save(deputado);
	}
	
	public void excluirDeputado(Long id) {
		Deputado deputadoOriginal = this.buscarDeputado(id);
		deputadoRepository.delete(deputadoOriginal);
	}
	
	

}
