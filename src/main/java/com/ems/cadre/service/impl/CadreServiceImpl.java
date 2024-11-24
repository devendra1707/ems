package com.ems.cadre.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.cadre.exception.CadreNotFoundException;
import com.ems.cadre.model.Cadre;
import com.ems.cadre.payload.CadreDto;
import com.ems.cadre.repo.CadreRepo;
import com.ems.cadre.service.CadreService;

@Service
public class CadreServiceImpl implements CadreService {

	private CadreRepo cadreRepo;
	private ModelMapper modelMapper;

	public CadreServiceImpl(CadreRepo cadreRepo, ModelMapper modelMapper) {
		this.cadreRepo = cadreRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public CadreDto createCadre(CadreDto cadreDto) {
		Cadre cadre = modelMapper.map(cadreDto, Cadre.class);
		Cadre saveCadre = cadreRepo.save(cadre);
		return modelMapper.map(saveCadre, CadreDto.class);
	}

	@Override
	public CadreDto updateCadre(int cadreId, CadreDto cadreDto) {
		Cadre cadre = cadreRepo.findById(cadreId).orElseThrow(() -> new CadreNotFoundException("Cadre Not Found"));
		cadre.setTitle(cadre.getTitle());
		Cadre updateCadre = cadreRepo.save(cadre);

		return modelMapper.map(updateCadre, CadreDto.class);
	}

	@Override
	public CadreDto getCadre(int cadreId) {

		Cadre cadre = cadreRepo.findById(cadreId).orElseThrow(() -> new CadreNotFoundException("Cadre Not Found"));
		return modelMapper.map(cadre, CadreDto.class);
	}

	@Override
	public List<CadreDto> cadreList() {
		List<Cadre> cadreList = cadreRepo.findAll();
		List<CadreDto> cadreDtos = cadreList.stream().map(cad -> modelMapper.map(cad, CadreDto.class))
				.collect(Collectors.toList());
		return cadreDtos;
	}

	@Override
	public void deleteCadre(int cadreId) {
		cadreRepo.deleteById(cadreId);
	}

}
