package com.cds.apirest.service;

import java.util.ArrayList;

import com.cds.apirest.dto.BandaDto;

public interface BandaService {

	public boolean salvar(BandaDto bandaDto) throws Exception;

	public ArrayList<BandaDto> listar();

	public void excluir(Integer idBanda);

}
