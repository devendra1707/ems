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
import org.springframework.web.bind.annotation.RestController;

import com.ems.station.model.Station;
import com.ems.station.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {
	private StationService stationService;

	public StationController(StationService stationService) {
		this.stationService = stationService;
	}

	// Create ADG
	@PostMapping("/create")
	public ResponseEntity<Station> createStation(@RequestBody Station station) {
		Station createStation = stationService.createStation(station);

		return new ResponseEntity<Station>(createStation, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{stationId}")
	public ResponseEntity<Station> updateStation(@PathVariable("stationId") int stationId,
			@RequestBody Station station) {
		Station updateStation = stationService.updateStation(stationId, station);
		return new ResponseEntity<Station>(updateStation, HttpStatus.OK);
	}

	// Get Station By Id
	@GetMapping("/get/{stationId}")
	public ResponseEntity<Station> getStationById(@PathVariable("stationId") int stationId) {
		Station getStation = stationService.getStationById(stationId);
		return new ResponseEntity<Station>(getStation, HttpStatus.OK);
	}

	// Get All Station

	@GetMapping("/all")
	public ResponseEntity<List<Station>> getAllStation() {
		List<Station> stationList = stationService.stationList();
		return new ResponseEntity<List<Station>>(stationList, HttpStatus.OK);
	}

	// Delete Station
	@DeleteMapping("/delete/{stationId}")
	public void deleteStation(@PathVariable("stationId") int stationId) {
		stationService.deleteStation(stationId);
	}
}
