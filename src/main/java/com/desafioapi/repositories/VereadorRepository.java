package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioapi.models.Vereador;

@Repository
public interface VereadorRepository extends JpaRepository<Vereador, Long> {
	
	Page<Vereador> findAll(Pageable pageable);

}
