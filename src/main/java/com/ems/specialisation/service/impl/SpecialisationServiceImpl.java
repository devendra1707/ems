package com.ems.specialisation.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.specialisation.exception.SpecialisationNotFoundException;
import com.ems.specialisation.model.Specialisation;
import com.ems.specialisation.payload.SpecialisationDto;
import com.ems.specialisation.repo.SpecialisationRepo;
import com.ems.specialisation.service.SpecialisationService;

@Service
public class SpecialisationServiceImpl implements SpecialisationService {
	private SpecialisationRepo specialisationRepo;
	private ModelMapper modelMapper;

	public SpecialisationServiceImpl(SpecialisationRepo specialisationRepo, ModelMapper modelMapper) {
		this.specialisationRepo = specialisationRepo;
		this.modelMapper = modelMapper;

	}

	@Override
	public SpecialisationDto createSpecialisation(SpecialisationDto specialisationDto) {
		Specialisation specialisation = modelMapper.map(specialisationDto, Specialisation.class);
		Specialisation saveSpecialisation = specialisationRepo.save(specialisation);
		return modelMapper.map(saveSpecialisation, SpecialisationDto.class);
	}

	@Override
	public SpecialisationDto updateSpecialisation(int specialisationId, SpecialisationDto specialisationDto) {
		Specialisation specialisation = specialisationRepo.findById(specialisationId)
				.orElseThrow(() -> new SpecialisationNotFoundException("Specialisation Not Found"));

		specialisation.setTitle(specialisation.getTitle());
		Specialisation updatSpecialisation = specialisationRepo.save(specialisation);

		return modelMapper.map(updatSpecialisation, SpecialisationDto.class);
	}

	@Override
	public SpecialisationDto getSpecialisation(int specialisationId) {

		Specialisation specialisation = specialisationRepo.findById(specialisationId)
				.orElseThrow(() -> new SpecialisationNotFoundException("Specialisation Not Found"));
		return modelMapper.map(specialisation, SpecialisationDto.class);
	}

	@Override
	public List<SpecialisationDto> specialisationList() {
		List<Specialisation> specialisations = specialisationRepo.findAll();
		List<SpecialisationDto> specialisationDtos = specialisations.stream()
				.map((spe) -> modelMapper.map(spe, SpecialisationDto.class)).collect(Collectors.toList());
		return specialisationDtos;
	}

	@Override
	public void deleteSpecialisation(int specialisationId) {
		specialisationRepo.deleteById(specialisationId);
	}
}
