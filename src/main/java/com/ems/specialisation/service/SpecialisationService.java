package com.ems.specialisation.service;

import java.util.List;

import com.ems.specialisation.model.Specialisation;

public interface SpecialisationService {
	public Specialisation createSpecialisation(Specialisation specialisation);

	public Specialisation updateSpecialisation(int specialisationId, Specialisation specialisation);

	public Specialisation getSpecialisation(int specialisationId);

	public List<Specialisation> specialisationList();

	public void deleteSpecialisation(int specialisationId);
}
