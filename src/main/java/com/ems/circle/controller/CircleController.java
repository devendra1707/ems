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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.circle.payload.CircleDto;
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
	public ResponseEntity<CircleDto> createCircle(@RequestBody CircleDto circle, @RequestParam int zoneId) {

		CircleDto createCircle = circleService.createCircle(circle, zoneId);
		return new ResponseEntity<CircleDto>(createCircle, HttpStatus.CREATED);
	}

	// update Circle

	@PutMapping("update/{circleId}")
	public ResponseEntity<CircleDto> updateCircle(@PathVariable("circleId") int circleId, @RequestBody CircleDto circle,
			@RequestParam int zoneId) {
		CircleDto updateCircle = circleService.updateCircle(circleId, circle, zoneId);
		return new ResponseEntity<CircleDto>(updateCircle, HttpStatus.OK);
	}

	// get Circle By Id

	@GetMapping("/{circleId}")
	public ResponseEntity<CircleDto> getCircleById(@PathVariable("circleId") int circleId) {
		CircleDto getCircle = circleService.getCircle(circleId);
		return new ResponseEntity<CircleDto>(getCircle, HttpStatus.OK);

	}

	// circle List
	@GetMapping("/all")
	public ResponseEntity<List<CircleDto>> getAllCircle() {
		List<CircleDto> circleList = circleService.circleList();
		return new ResponseEntity<List<CircleDto>>(circleList, HttpStatus.OK);

	}

	// delete Circle

	@DeleteMapping("/{circleId}")
	public void deleteCircle(@PathVariable("circleId") int circleId) {
		circleService.deleteCircle(circleId);

	}

}
