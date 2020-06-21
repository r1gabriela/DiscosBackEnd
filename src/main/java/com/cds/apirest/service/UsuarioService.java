package com.cds.apirest.service;

import com.cds.apirest.dto.UsuarioDto;

public interface UsuarioService {

	public UsuarioDto cadastrar(UsuarioDto usuarioDto) throws Exception;

	public void autoLogin(String username, String password);

}
