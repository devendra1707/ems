package com.ems.cadre.service;

import java.util.List;

import com.ems.cadre.payload.CadreDto;

public interface CadreService {

public CadreDto createCadre(CadreDto cadreDto);
public CadreDto updateCadre(int cadreId,CadreDto cadreDto);
public CadreDto getCadre(int cadreId);
public List<CadreDto> cadreList();
public void deleteCadre(int cadreId);	

}
