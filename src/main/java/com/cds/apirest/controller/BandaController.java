package com.cds.apirest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cds.apirest.dto.BandaDto;
import com.cds.apirest.service.BandaService;

@RestController
@RequestMapping(value="/banda")
public class BandaController {
	
	@Autowired
	BandaService bandaServiceImpl;
	
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public BandaDto salvar(@RequestBody BandaDto bandaDto) throws Exception {
		return bandaServiceImpl.salvar(bandaDto);
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ArrayList<BandaDto> listar(){
		return bandaServiceImpl.listar();
		
	}
	
	@RequestMapping(value="/excluir", method=RequestMethod.POST)
	public boolean excluir(@RequestBody BandaDto bandaDto) {
		return bandaServiceImpl.excluir(bandaDto);
	}
	

}
