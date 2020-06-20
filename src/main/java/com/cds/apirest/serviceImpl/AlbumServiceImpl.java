package com.cds.apirest.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cds.apirest.repository.AlbumRepository;
import com.cds.apirest.service.AlbumService;

public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository albumRepository;

	public AlbumServiceImpl(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

}
