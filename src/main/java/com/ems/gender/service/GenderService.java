package com.ems.gender.service;

import com.ems.gender.model.Gender;

public interface GenderService {

	public Gender createGender(Gender gender);

	public Gender updateGender(int genderId, Gender gender);

	public Gender getGenderById(int genderId);

	public Iterable<Gender> genderList();

	public void deleteGender(int genderId);

}
