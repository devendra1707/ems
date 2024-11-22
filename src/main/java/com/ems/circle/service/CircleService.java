package com.ems.circle.service;

import java.util.List;

import com.ems.circle.model.Circle;

public interface CircleService {

	public Circle createCircle(Circle circle);
	public Circle updateCircle(int circleId,Circle circle);
	public Circle getCircle(int circleId);
	public List<Circle> circleList();
	public void deleteCircle(int circleId);
}
