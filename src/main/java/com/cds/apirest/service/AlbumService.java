package com.cds.apirest.service;

import java.util.ArrayList;

import com.cds.apirest.dto.AlbumDto;

public interface AlbumService {

	public AlbumDto salvar(AlbumDto albumDto) throws Exception;

	public ArrayList<AlbumDto> listar();

}
