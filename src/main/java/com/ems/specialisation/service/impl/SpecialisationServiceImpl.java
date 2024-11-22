package com.ems.specialisation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.specialisation.exception.SpecialisationNotFoundException;
import com.ems.specialisation.model.Specialisation;
import com.ems.specialisation.repo.SpecialisationRepo;
import com.ems.specialisation.service.SpecialisationService;

@Service
public class SpecialisationServiceImpl implements SpecialisationService {
	private SpecialisationRepo specialisationRepo;

	public SpecialisationServiceImpl(SpecialisationRepo specialisationRepo) {
		this.specialisationRepo = specialisationRepo;
	}

	@Override
	public Specialisation createSpecialisation(Specialisation specialisation) {
		Specialisation createSpecialisation = specialisationRepo.save(specialisation);
		return createSpecialisation;
	}

	@Override
	public Specialisation updateSpecialisation(int specialisationId, Specialisation specialisation) {
		Specialisation getSpecialisation = specialisationRepo.findById(specialisationId)
				.orElseThrow(() -> new SpecialisationNotFoundException("Specialisation Not Found"));
		if (getSpecialisation != null) {
			getSpecialisation.setTitle(specialisation.getTitle());
			specialisationRepo.save(getSpecialisation);
		}

		return getSpecialisation;
	}

	@Override
	public Specialisation getSpecialisation(int specialisationId) {

		Specialisation getSpecialisation = specialisationRepo.findById(specialisationId)
				.orElseThrow(() -> new SpecialisationNotFoundException("Specialisation Not Found"));
		return getSpecialisation;
	}

	@Override
	public List<Specialisation> specialisationList() {
		List<Specialisation> specialisationList = specialisationRepo.findAll();
		return specialisationList;
	}

	@Override
	public void deleteSpecialisation(int specialisationId) {
		specialisationRepo.deleteById(specialisationId);
	}
}
