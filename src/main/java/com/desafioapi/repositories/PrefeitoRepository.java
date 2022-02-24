package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioapi.models.Prefeito;

@Repository
public interface PrefeitoRepository extends JpaRepository<Prefeito, Long> {
	Page<Prefeito> findAll(Pageable pageable);
	

}
