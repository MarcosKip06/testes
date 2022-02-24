package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioapi.models.Governador;

public interface GovernadorRepository extends JpaRepository<Governador, Long> {
	
	Page<Governador> findAll(Pageable pageable);

}
