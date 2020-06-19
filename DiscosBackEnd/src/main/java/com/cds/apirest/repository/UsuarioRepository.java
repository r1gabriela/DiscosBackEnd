package com.cds.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cds.apirest.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
