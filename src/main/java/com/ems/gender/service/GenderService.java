package com.ems.gender.service;

import java.util.List;

import com.ems.gender.payload.GenderDto;

public interface GenderService {

	public GenderDto createGender(GenderDto genderDto);

	public GenderDto updateGender(int genderId, GenderDto genderDto);

	public GenderDto getGenderById(int genderId);

	public List<GenderDto> genderList();

	public void deleteGender(int genderId);

}
