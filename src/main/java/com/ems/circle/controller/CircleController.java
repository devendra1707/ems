package com.ems.circle.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.circle.model.Circle;
import com.ems.circle.service.CircleService;

@RestController
@RequestMapping("/circle")
public class CircleController {

	private CircleService circleService;

	public CircleController(CircleService circleService) {
		this.circleService = circleService;
	}

	// create Circle

	@PostMapping("/create")
	public ResponseEntity<Circle> createCircle(@RequestBody Circle circle) {

		Circle createCircle = circleService.createCircle(circle);
		return new ResponseEntity<Circle>(createCircle, HttpStatus.CREATED);
	}

	// update Circle

	@PutMapping("update/{circleId}")
	public ResponseEntity<Circle> updateCircle(@PathVariable("circleId") int circleId, @RequestBody Circle circle) {
		Circle updateCircle = circleService.updateCircle(circleId, circle);
		return new ResponseEntity<Circle>(updateCircle, HttpStatus.OK);
	}

	// get Circle By Id

	@GetMapping("/{circleId}")
	public ResponseEntity<Circle> getCircleById(@PathVariable("circleId") int circleId) {
		Circle getCircle = circleService.getCircle(circleId);
		return new ResponseEntity<Circle>(getCircle, HttpStatus.OK);

	}

	// circle List
	@GetMapping("/all")
	public ResponseEntity<List<Circle>> getAllCircle() {
		List<Circle> circleList = circleService.circleList();
		return new ResponseEntity<List<Circle>>(circleList, HttpStatus.OK);

	}

	// delete Circle

	@DeleteMapping("/{circleId}")
	public void deleteCircle(@PathVariable("circleId") int circleId) {
		circleService.deleteCircle(circleId);

	}

}