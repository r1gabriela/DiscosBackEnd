package com.cds.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cds.apirest.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="SELECT u FROM Usuario u WHERE u.username = :username")
	public Usuario pesquisarUsuarioPorUsername(@Param("username")String username);



}
