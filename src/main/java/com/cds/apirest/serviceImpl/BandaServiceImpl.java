package com.cds.apirest.serviceImpl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import com.cds.apirest.dto.BandaDto;
import com.cds.apirest.entity.Banda;
import com.cds.apirest.repository.BandaRepository;
import com.cds.apirest.service.BandaService;

public class BandaServiceImpl implements BandaService {

	@Autowired
	private BandaRepository bandaRepository;

	public BandaServiceImpl(BandaRepository bandaRepository) {
		this.bandaRepository = bandaRepository;
	}

	@Override
	public BandaDto salvar(BandaDto bandaDto) throws Exception {
		try {
			Banda banda = new Banda();
			banda = bandaRepository.pesquisarPorNome(bandaDto.getNome().toLowerCase());
				if(banda == null || banda.getIdBanda() == bandaDto.getIdBanda()) {
					banda = bandaRepository.save(new ModelMapper().map(bandaDto, Banda.class));
					
				}else {
					throw new Exception("Banda ja existe");
				}
			
			return new ModelMapper().map(banda, BandaDto.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	@Override
	public ArrayList<BandaDto> listar(){
		ArrayList<BandaDto> bandas = new ArrayList<>();
		Iterable<Banda> iterable = bandaRepository.findAll();
		
		if(iterable != null)
			bandas = new ModelMapper().map(iterable, new TypeToken<ArrayList<BandaDto>>() {}.getType());
		
		return bandas;
	}
	
	@Override
	public boolean excluir(BandaDto bandaDto) {
		try {
			bandaRepository.delete(new ModelMapper().map(bandaDto, Banda.class));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
