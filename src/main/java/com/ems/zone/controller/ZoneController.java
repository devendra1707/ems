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
import org.springframework.web.bind.annotation.RestController;

import com.ems.zone.model.Zone;
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
	public ResponseEntity<Zone> createZone(@RequestBody Zone zone) {
		Zone createZone = zoneService.createZone(zone);

		return new ResponseEntity<Zone>(createZone, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{zoneId}")
	public ResponseEntity<Zone> updateZone(@PathVariable("zoneId") int zoneId, @RequestBody Zone zone) {
		Zone updateZone = zoneService.updateZone(zoneId, zone);
		return new ResponseEntity<Zone>(updateZone, HttpStatus.OK);
	}

	// Get Zone By Id
	@GetMapping("/get/{zoneId}")
	public ResponseEntity<Zone> getZoneById(@PathVariable("zoneId") int zoneId) {
		Zone getZone = zoneService.getZoneById(zoneId);
		return new ResponseEntity<Zone>(getZone, HttpStatus.OK);
	}

	// Get All Zone

	@GetMapping("/all")
	public ResponseEntity<List<Zone>> getAllZone() {
		List<Zone> zoneList = zoneService.zoneList();
		return new ResponseEntity<List<Zone>>(zoneList, HttpStatus.OK);
	}

	// Delete Zone
	@DeleteMapping("/delete/{zoneId}")
	public void deleteZone(@PathVariable("zoneId") int zoneId) {
		zoneService.deleteZone(zoneId);
	}
}
