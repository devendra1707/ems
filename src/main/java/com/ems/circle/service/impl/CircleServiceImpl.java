package com.ems.circle.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.circle.exception.CircleNotFoundExcepption;
import com.ems.circle.model.Circle;
import com.ems.circle.payload.CircleDto;
import com.ems.circle.repo.CircleRepo;
import com.ems.circle.service.CircleService;
import com.ems.zone.exception.ZoneNotFoundException;
import com.ems.zone.model.Zone;
import com.ems.zone.repo.ZoneRepo;

@Service
public class CircleServiceImpl implements CircleService {

	private CircleRepo circleRepo;
	private ModelMapper modelMapper;
	private ZoneRepo zoneRepo;

	public CircleServiceImpl(CircleRepo circleRepo, ModelMapper modelMapper, ZoneRepo zoneRepo) {
		this.circleRepo = circleRepo;
		this.modelMapper = modelMapper;
		this.zoneRepo = zoneRepo;
	}

	@Override
	public CircleDto createCircle(CircleDto circleDto, int zoneId) {

		Zone zone = zoneRepo.findById(zoneId).orElseThrow(() -> new ZoneNotFoundException("Zone Not Found"));

		Circle circle = modelMapper.map(circleDto, Circle.class);
		circle.setZone(zone);
		Circle saveCircle = circleRepo.save(circle);
		return modelMapper.map(saveCircle, CircleDto.class);
	}

	@Override
	public CircleDto updateCircle(int circleId, CircleDto circleDto, int zoneId) {
		Circle circle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));
		Zone zone = zoneRepo.findById(zoneId).orElseThrow(() -> new ZoneNotFoundException("Zone Not Found"));

		circle.setName(circle.getName());
		circle.setZone(zone);
		Circle updateCircle = circleRepo.save(circle);

		return modelMapper.map(updateCircle, CircleDto.class);
	}

	@Override
	public CircleDto getCircle(int circleId) {
		Circle circle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));
		return modelMapper.map(circle, CircleDto.class);
	}

	@Override
	public List<CircleDto> circleList() {

		List<Circle> circleList = circleRepo.findAll();
		List<CircleDto> circleDtos = circleList.stream().map(cir -> modelMapper.map(cir, CircleDto.class))
				.collect(Collectors.toList());
		return circleDtos;
	}

	@Override
	public void deleteCircle(int circleId) {

		circleRepo.deleteById(circleId);
	}

}
