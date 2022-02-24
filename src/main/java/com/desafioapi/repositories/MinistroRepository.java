package com.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioapi.models.Ministro;

@Repository
public interface MinistroRepository extends JpaRepository<Ministro, Long> {
	Page<Ministro> findAll(Pageable pageable);

}
