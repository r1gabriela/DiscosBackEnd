package com.cds.apirest.dto;

import com.cds.apirest.entity.Banda;
import com.cds.apirest.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AlbumDto {
	
	private Integer idAlbum;
	
	private String nome;
	
	private String ano;
	
	private Banda banda;
	
	private Usuario usuario;

}
