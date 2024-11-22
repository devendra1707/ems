package com.ems.division.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.division.exception.DivisionNotFoundException;
import com.ems.division.model.Division;
import com.ems.division.repo.DivisionRepo;
import com.ems.division.service.DivisionService;

@Service
public class DivisionServiceImpl implements DivisionService {

	private DivisionRepo divisionRepo;

	public DivisionServiceImpl(DivisionRepo divisionRepo) {
		this.divisionRepo = divisionRepo;
	}

	@Override
	public Division createDivision(Division division) {

		Division createDivision = divisionRepo.save(division);

		return createDivision;
	}

	@Override
	public Division updateDivision(int divisionId, Division division) {
		Division getDivision = divisionRepo.findById(divisionId)
				.orElseThrow(() -> new DivisionNotFoundException("Division Not found"));

		if (getDivision != null) {
			getDivision.setName(division.getName());
			divisionRepo.save(getDivision);
		}

		return getDivision;
	}

	@Override
	public Division getDivisionById(int divisionId) {
		Division getDivision = divisionRepo.findById(divisionId)
				.orElseThrow(() -> new DivisionNotFoundException("Division Not found"));
		return getDivision;
	}

	@Override
	public List<Division> divisionList() {

		List<Division> divisionList = divisionRepo.findAll();

		return divisionList;
	}

	@Override
	public void deleteDivision(int divisionId) {

		divisionRepo.deleteById(divisionId);

	}

	
}
