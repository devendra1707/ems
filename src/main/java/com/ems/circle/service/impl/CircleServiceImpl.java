package com.ems.circle.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.circle.exception.CircleNotFoundExcepption;
import com.ems.circle.model.Circle;
import com.ems.circle.repo.CircleRepo;
import com.ems.circle.service.CircleService;

@Service
public class CircleServiceImpl implements CircleService {

	private CircleRepo circleRepo;

	public CircleServiceImpl(CircleRepo circleRepo) {
		this.circleRepo = circleRepo;
	}

	@Override
	public Circle createCircle(Circle circle) {

		return circleRepo.save(circle);
	}

	@Override
	public Circle updateCircle(int circleId, Circle circle) {
		Circle getCircle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));
		if (getCircle != null) {
			getCircle.setName(circle.getName());
			circleRepo.save(getCircle);
		}
		return getCircle;
	}

	@Override
	public Circle getCircle(int circleId) {
		Circle getCircle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));
		return getCircle;
	}

	@Override
	public List<Circle> circleList() {

		List<Circle> circleList = circleRepo.findAll();
		return circleList;
	}

	@Override
	public void deleteCircle(int circleId) {

		circleRepo.deleteById(circleId);
	}

}
