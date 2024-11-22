package com.ems.gender.service.impl;

import org.springframework.stereotype.Service;

import com.ems.gender.exception.GenderNotFoundException;
import com.ems.gender.model.Gender;
import com.ems.gender.repo.GenderRepository;
import com.ems.gender.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {

	private GenderRepository genderRepository;

	public GenderServiceImpl(GenderRepository genderRepository) {
		this.genderRepository = genderRepository;
	}

	@Override
	public Gender createGender(Gender gender) {
		Gender createGender = genderRepository.save(gender);
		return createGender;
	}

	@Override
	public Gender updateGender(int genderId, Gender gender) {
		Gender genderDetails = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender Not Found With this" + genderId));
		if (genderDetails != null) {
			genderDetails.setName(gender.getName());
		}

		Gender saveGender = genderRepository.save(genderDetails);
		return saveGender;
	}

	@Override
	public Gender getGenderById(int genderId) {
		Gender getSingleGender = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender Not Found With this" + genderId));
		return getSingleGender;
	}

	@Override
	public Iterable<Gender> genderList() {
		Iterable<Gender> genderList = genderRepository.findAll();
		return genderList;
	}

	@Override
	public void deleteGender(int genderId) {
		genderRepository.deleteById(genderId);

	}

}
