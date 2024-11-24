package com.ems.zone.controller;

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

import com.ems.zone.payload.ZoneDto;
import com.ems.zone.service.ZoneService;

@RestController
@RequestMapping("/zone")
public class ZoneController {
	private ZoneService zoneService;

	public ZoneController(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	// Create ADG
	@PostMapping("/create")
	public ResponseEntity<ZoneDto> createZone(@RequestBody ZoneDto zoneDto,@RequestParam int adgId) {
		ZoneDto createZone = zoneService.createZone(zoneDto,adgId);

		return new ResponseEntity<ZoneDto>(createZone, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{zoneId}")
	public ResponseEntity<ZoneDto> updateZone(@PathVariable("zoneId") int zoneId, @RequestBody ZoneDto zoneDto,@RequestParam int adgId) {
		ZoneDto updateZone = zoneService.updateZone(zoneId, zoneDto,adgId);
		return new ResponseEntity<ZoneDto>(updateZone, HttpStatus.OK);
	}

	// Get Zone By Id
	@GetMapping("/get/{zoneId}")
	public ResponseEntity<ZoneDto> getZoneById(@PathVariable("zoneId") int zoneId) {
		ZoneDto getZone = zoneService.getZoneById(zoneId);
		return new ResponseEntity<ZoneDto>(getZone, HttpStatus.OK);
	}

	// Get All Zone

	@GetMapping("/all")
	public ResponseEntity<List<ZoneDto>> getAllZone() {
		List<ZoneDto> zoneList = zoneService.zoneList();
		return new ResponseEntity<List<ZoneDto>>(zoneList, HttpStatus.OK);
	}

	// Delete Zone
	@DeleteMapping("/delete/{zoneId}")
	public void deleteZone(@PathVariable("zoneId") int zoneId) {
		zoneService.deleteZone(zoneId);
	}
}
