package com.cds.apirest.serviceImpl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import com.cds.apirest.dto.AlbumDto;
import com.cds.apirest.entity.Album;
import com.cds.apirest.entity.Banda;
import com.cds.apirest.repository.AlbumRepository;
import com.cds.apirest.service.AlbumService;

public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository albumRepository;

	public AlbumServiceImpl(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	@Override
	public AlbumDto salvar(AlbumDto albumDto) throws Exception {
		try {
			Album album = new Album();
			album = albumRepository.pesquisarPorNome(albumDto.getNome().toLowerCase());
			if(album  == null || album.getIdAlbum() == albumDto.getIdAlbum()) {
				
				album = albumRepository.save(new ModelMapper().map(albumDto, Album.class));
			}else {
				throw new Exception("Album já existe");
			}
			return new ModelMapper().map(album, AlbumDto.class);
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
		
	}
	
	@Override
	public ArrayList<AlbumDto> listar(){
		ArrayList<AlbumDto> albuns = new ArrayList<>();
		Iterable<Album> iterable = albumRepository.findAll();
		
		if(iterable != null) 
			albuns  = new ModelMapper().map(iterable, new TypeToken<ArrayList<AlbumDto>>() {}.getType());
		
		return albuns;
	}
	
	@Override
	public ArrayList<AlbumDto> listarPorBanda(Banda banda){
		return new ModelMapper().map(albumRepository.listarPorBanda(banda), new TypeToken<ArrayList<AlbumDto>>() {}.getType());
	}
	
	@Override
	public void excluir(Integer idAlbum) {
		try {
			albumRepository.deleteById(idAlbum);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
