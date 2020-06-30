package com.cds.apirest.service;

import java.util.ArrayList;

import com.cds.apirest.dto.AlbumDto;
import com.cds.apirest.entity.Banda;

public interface AlbumService {

	public AlbumDto salvar(AlbumDto albumDto) throws Exception;

	public ArrayList<AlbumDto> listar();

	public ArrayList<AlbumDto> listarPorBanda(Banda banda);

	public void excluir(Integer idAlbum);

}
