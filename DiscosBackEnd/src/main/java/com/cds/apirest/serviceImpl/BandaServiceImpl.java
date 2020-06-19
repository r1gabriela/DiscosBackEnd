package com.cds.apirest.serviceImpl;

import com.cds.apirest.repository.BandaRepository;
import com.cds.apirest.service.BandaService;

public class BandaServiceImpl implements BandaService{

	private BandaRepository bandaRepository;

	public BandaServiceImpl(BandaRepository bandaRepository) {
		this.bandaRepository = bandaRepository;
	}

}
