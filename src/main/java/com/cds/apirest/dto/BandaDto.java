package com.cds.apirest.dto;

import java.util.List;

import com.cds.apirest.entity.Album;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class BandaDto {
	
	private Integer idBanda;
	
	private String nome;
	
	private String genero;
	
	private List<Album> albuns;

}
