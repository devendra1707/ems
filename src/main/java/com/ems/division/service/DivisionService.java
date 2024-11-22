package com.ems.division.service;

import java.util.List;

import com.ems.division.model.Division;

public interface DivisionService {
	public Division createDivision(Division division);

	public Division updateDivision(int divisionId, Division division);

	public Division getDivisionById(int divisionId);

	public List<Division> divisionList();

	public void deleteDivision(int divisionId);
}
