package com.cds.apirest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.apirest.dto.AlbumDto;
import com.cds.apirest.service.AlbumService;

@RestController
@RequestMapping(path="/album")
public class AlbumController {
	
	@Autowired
	AlbumService albumServiceImpl;
	
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public AlbumDto salvar(@RequestBody AlbumDto albumDto) throws Exception {
		return albumServiceImpl.salvar(albumDto);
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ArrayList<AlbumDto> listar(){
		return albumServiceImpl.listar();
	}
	
	@RequestMapping(value="/excluir", method=RequestMethod.DELETE)
	public void excluir(@RequestParam Integer idAlbum) {
		 albumServiceImpl.excluir(idAlbum);
	}

}
