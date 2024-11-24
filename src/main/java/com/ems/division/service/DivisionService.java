package com.ems.division.service;

import java.util.List;

import com.ems.division.payload.DivisionDto;

public interface DivisionService {
	public DivisionDto createDivision(DivisionDto divisionDto,int circleId);

	public DivisionDto updateDivision(int divisionId, DivisionDto divisionDto,int circleId);

	public DivisionDto getDivisionById(int divisionId);

	public List<DivisionDto> divisionList();

	public void deleteDivision(int divisionId);
}
