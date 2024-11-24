package com.ems.station.controller;

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

import com.ems.station.payload.StationDto;
import com.ems.station.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {
	private StationService stationService;

	public StationController(StationService stationService) {
		this.stationService = stationService;
	}

	// Create Station
	@PostMapping("/create")
	public ResponseEntity<StationDto> createStation(@RequestBody StationDto stationDto, @RequestParam int stateId) {
		StationDto createStation = stationService.createStation(stationDto, stateId);

		return new ResponseEntity<StationDto>(createStation, HttpStatus.CREATED);
	}

	// update Station
	@PutMapping("/update/{stationId}")
	public ResponseEntity<StationDto> updateStation(@PathVariable("stationId") int stationId,
			@RequestBody StationDto stationDto, @RequestParam int stateId) {
		StationDto updateStation = stationService.updateStation(stationId, stationDto, stateId);
		return new ResponseEntity<StationDto>(updateStation, HttpStatus.OK);
	}

	// Get Station By Id
	@GetMapping("/get/{stationId}")
	public ResponseEntity<StationDto> getStationById(@PathVariable("stationId") int stationId) {
		StationDto getStation = stationService.getStationById(stationId);
		return new ResponseEntity<StationDto>(getStation, HttpStatus.OK);
	}

	// Get All Station

	@GetMapping("/all")
	public ResponseEntity<List<StationDto>> getAllStation() {
		List<StationDto> stationList = stationService.stationList();
		return new ResponseEntity<List<StationDto>>(stationList, HttpStatus.OK);
	}

	// Delete Station
	@DeleteMapping("/delete/{stationId}")
	public void deleteStation(@PathVariable("stationId") int stationId) {
		stationService.deleteStation(stationId);
	}
}
