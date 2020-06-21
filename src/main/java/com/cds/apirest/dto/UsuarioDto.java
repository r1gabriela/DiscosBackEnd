package com.cds.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class UsuarioDto {
	
	private Integer idUsuario;
	
	private String username;
	
	private String password;

}
