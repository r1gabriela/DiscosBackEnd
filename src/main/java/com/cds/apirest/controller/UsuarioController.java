package com.cds.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cds.apirest.dto.UsuarioDto;
import com.cds.apirest.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioServiceImpl;
	
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public UsuarioDto cadastrar(@RequestBody UsuarioDto usuarioDto) throws Exception {
		return usuarioServiceImpl.cadastrar(usuarioDto);
	}
	

}
