package com.ems.circle.service;

import java.util.List;

import com.ems.circle.payload.CircleDto;

public interface CircleService {

	public CircleDto createCircle(CircleDto circleDto, int zoneId);

	public CircleDto updateCircle(int circleId, CircleDto circleDto, int zoneId);

	public CircleDto getCircle(int circleId);

	public List<CircleDto> circleList();

	public void deleteCircle(int circleId);
}
