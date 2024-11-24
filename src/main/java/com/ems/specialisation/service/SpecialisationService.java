package com.ems.specialisation.service;

import java.util.List;

import com.ems.specialisation.model.Specialisation;
import com.ems.specialisation.payload.SpecialisationDto;

public interface SpecialisationService {
	public SpecialisationDto createSpecialisation(SpecialisationDto specialisationDto);

	public SpecialisationDto updateSpecialisation(int specialisationId, SpecialisationDto specialisationDto);

	public SpecialisationDto getSpecialisation(int specialisationId);

	public List<SpecialisationDto> specialisationList();

	public void deleteSpecialisation(int specialisationId);
}
