package com.cds.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cds.apirest.entity.Album;
import com.cds.apirest.entity.Banda;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

	@Query("SELECT a FROM Album a WHERE LOWER(a.nome) = :nome")
	Album pesquisarPorNome(@Param("nome")String nome);
	
	@Query("SELECT a FROM Album a WHERE LOWER(a.banda) = :banda")
	Iterable<Album> listarPorBanda(@Param("banda")Banda banda);

}
