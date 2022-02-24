package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioapi.models.Senador;

public interface SenadorRepository extends JpaRepository<Senador, Long> {
	Page<Senador> findAll(Pageable pageable);

}
