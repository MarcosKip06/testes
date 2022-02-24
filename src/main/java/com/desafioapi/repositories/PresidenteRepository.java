package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioapi.models.Presidente;

@Repository
public interface PresidenteRepository extends JpaRepository<Presidente, Long> {
	Page<Presidente> findAll(Pageable pageable);
	
}
