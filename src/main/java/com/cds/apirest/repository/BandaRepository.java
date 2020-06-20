package com.cds.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cds.apirest.entity.Banda;

public interface BandaRepository extends JpaRepository<Banda, Integer>{
	
	@Query("SELECT b FROM Banda b WHERE LOWER(b.nome) =:nome")
	public Banda pesquisarPorNome(@Param("nome")String nome);
	
	
}
