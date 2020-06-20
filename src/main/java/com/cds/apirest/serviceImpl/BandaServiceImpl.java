package com.cds.apirest.serviceImpl;

import org.modelmapper.ModelMapper;
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

			banda = bandaRepository.save(new ModelMapper().map(bandaDto, Banda.class));

			return new ModelMapper().map(banda, BandaDto.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
