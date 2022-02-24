package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioapi.models.Deputado;

@Repository
public interface DeputadoRepository extends JpaRepository<Deputado, Long> {
	Page<Deputado> findAll(Pageable pageable);
}
