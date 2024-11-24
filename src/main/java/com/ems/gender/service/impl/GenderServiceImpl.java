package com.ems.gender.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.gender.exception.GenderNotFoundException;
import com.ems.gender.model.Gender;
import com.ems.gender.payload.GenderDto;
import com.ems.gender.repo.GenderRepository;
import com.ems.gender.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {

	private GenderRepository genderRepository;
	private ModelMapper modelMapper;

	public GenderServiceImpl(GenderRepository genderRepository, ModelMapper modelMapper) {
		this.genderRepository = genderRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public GenderDto createGender(GenderDto genderDto) {
		Gender gender = modelMapper.map(genderDto, Gender.class);
		Gender saveGender = genderRepository.save(gender);
		return modelMapper.map(saveGender, GenderDto.class);
	}

	@Override
	public GenderDto updateGender(int genderId, GenderDto genderDto) {
		Gender gender = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender Not Found With this" + genderId));
		gender.setName(gender.getName());

		Gender saveGender = genderRepository.save(gender);
		return modelMapper.map(saveGender, GenderDto.class);
	}

	@Override
	public GenderDto getGenderById(int genderId) {
		Gender gender = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender Not Found With this" + genderId));
		return modelMapper.map(gender, GenderDto.class);
	}

	@Override
	public List<GenderDto> genderList() {
		List<Gender> genderList = genderRepository.findAll();
		List<GenderDto> genderDto = genderList.stream().map(gen -> modelMapper.map(gen, GenderDto.class))
				.collect(Collectors.toList());
		return genderDto;
	}

	@Override
	public void deleteGender(int genderId) {
		genderRepository.deleteById(genderId);

	}

}
