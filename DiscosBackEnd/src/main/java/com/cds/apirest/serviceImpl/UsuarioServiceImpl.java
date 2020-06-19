package com.cds.apirest.serviceImpl;

import com.cds.apirest.repository.UsuarioRepository;
import com.cds.apirest.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
