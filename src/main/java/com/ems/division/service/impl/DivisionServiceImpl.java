package com.ems.division.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.circle.exception.CircleNotFoundExcepption;
import com.ems.circle.model.Circle;
import com.ems.circle.repo.CircleRepo;
import com.ems.division.exception.DivisionNotFoundException;
import com.ems.division.model.Division;
import com.ems.division.payload.DivisionDto;
import com.ems.division.repo.DivisionRepo;
import com.ems.division.service.DivisionService;

@Service
public class DivisionServiceImpl implements DivisionService {

	private DivisionRepo divisionRepo;
	private ModelMapper modelMapper;
	private CircleRepo circleRepo;

	public DivisionServiceImpl(DivisionRepo divisionRepo, ModelMapper modelMapper, CircleRepo circleRepo) {
		this.divisionRepo = divisionRepo;
		this.modelMapper = modelMapper;
		this.circleRepo = circleRepo;
	}

	@Override
	public DivisionDto createDivision(DivisionDto divisionDto, int circleId) {

		Circle circle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));

		Division division = modelMapper.map(divisionDto, Division.class);
		division.setCircle(circle);
		Division saveDivision = divisionRepo.save(division);

		return modelMapper.map(saveDivision, DivisionDto.class);
	}

	@Override
	public DivisionDto updateDivision(int divisionId, DivisionDto divisionDto, int circleId) {
		Division division = divisionRepo.findById(divisionId)
				.orElseThrow(() -> new DivisionNotFoundException("Division Not found"));

		Circle circle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));

		division.setName(division.getName());
		division.setCircle(circle);
		Division updateDivision = divisionRepo.save(division);

		return modelMapper.map(updateDivision, DivisionDto.class);
	}

	@Override
	public DivisionDto getDivisionById(int divisionId) {
		Division getDivision = divisionRepo.findById(divisionId)
				.orElseThrow(() -> new DivisionNotFoundException("Division Not found"));
		return modelMapper.map(getDivision, DivisionDto.class);
	}

	@Override
	public List<DivisionDto> divisionList() {

		List<Division> divisionList = divisionRepo.findAll();
		List<DivisionDto> divisionDtos = divisionList.stream().map(div -> modelMapper.map(div, DivisionDto.class))
				.collect(Collectors.toList());
		return divisionDtos;
	}

	@Override
	public void deleteDivision(int divisionId) {

		divisionRepo.deleteById(divisionId);

	}

}
