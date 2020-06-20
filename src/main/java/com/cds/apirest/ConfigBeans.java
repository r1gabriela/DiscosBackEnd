package com.cds.apirest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cds.apirest.repository.AlbumRepository;
import com.cds.apirest.repository.BandaRepository;

import com.cds.apirest.repository.UsuarioRepository;
import com.cds.apirest.service.AlbumService;
import com.cds.apirest.service.BandaService;

import com.cds.apirest.service.UsuarioService;
import com.cds.apirest.serviceImpl.AlbumServiceImpl;
import com.cds.apirest.serviceImpl.BandaServiceImpl;

import com.cds.apirest.serviceImpl.UsuarioServiceImpl;

@Configuration
public class ConfigBeans {
	
	
	@Bean
	public AlbumService initializeAlbumService(AlbumRepository albumRepository) {
		final AlbumService albumService = new AlbumServiceImpl(albumRepository);
		return albumService;
	}
	
	@Bean
	public BandaService initializeBandaService(BandaRepository bandaRepository) {
		final BandaService bandaService = new BandaServiceImpl(bandaRepository);
		return bandaService;
	}
	
	@Bean
	public UsuarioService initializeUsuarioService(UsuarioRepository usuarioRepository) {
		final UsuarioService usuarioService = new UsuarioServiceImpl(usuarioRepository);
		return usuarioService;
	}
}
