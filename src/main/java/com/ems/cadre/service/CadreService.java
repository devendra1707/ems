package com.ems.cadre.service;

import java.util.List;

import com.ems.cadre.model.Cadre;

public interface CadreService {

public Cadre createCadre(Cadre cadre);
public Cadre updateCadre(int cadreId,Cadre cadre);
public Cadre getCadre(int cadreId);
public List<Cadre> cadreList();
public void deleteCadre(int cadreId);	

}
