package com.ems.cadre.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.cadre.exception.CadreNotFoundException;
import com.ems.cadre.model.Cadre;
import com.ems.cadre.repo.CadreRepo;
import com.ems.cadre.service.CadreService;

@Service
public class CadreServiceImpl implements CadreService {

	private CadreRepo cadreRepo;

	public CadreServiceImpl(CadreRepo cadreRepo) {
		this.cadreRepo = cadreRepo;
	}

	@Override
	public Cadre createCadre(Cadre cadre) {
		Cadre createCadre = cadreRepo.save(cadre);
		return createCadre;
	}

	@Override
	public Cadre updateCadre(int cadreId, Cadre cadre) {
		Cadre getCadre = cadreRepo.findById(cadreId).orElseThrow(() -> new CadreNotFoundException("Cadre Not Found"));
		if (getCadre != null) {
			getCadre.setTitle(cadre.getTitle());
			cadreRepo.save(getCadre);
		}

		return getCadre;
	}

	@Override
	public Cadre getCadre(int cadreId) {

		Cadre getCadre = cadreRepo.findById(cadreId).orElseThrow(() -> new CadreNotFoundException("Cadre Not Found"));
		return getCadre;
	}

	@Override
	public List<Cadre> cadreList() {
		List<Cadre> cadreList = cadreRepo.findAll();
		return cadreList;
	}

	@Override
	public void deleteCadre(int cadreId) {
		cadreRepo.deleteById(cadreId);
	}

}
