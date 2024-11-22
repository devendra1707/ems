package com.ems.region.controller;

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

import com.ems.region.model.Region;
import com.ems.region.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {
	private RegionService regionService;

	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}

	// Create ADG
	@PostMapping("/create")
	public ResponseEntity<Region> createRegion(@RequestBody Region region) {
		Region createRegion = regionService.createRegion(region);

		return new ResponseEntity<Region>(createRegion, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{regionId}")
	public ResponseEntity<Region> updateRegion(@PathVariable("regionId") int regionId, @RequestBody Region region) {
		Region updateRegion = regionService.updateRegion(regionId, region);
		return new ResponseEntity<Region>(updateRegion, HttpStatus.OK);
	}

	// Get Region By Id
	@GetMapping("/get/{regionId}")
	public ResponseEntity<Region> getRegionById(@PathVariable("regionId") int regionId) {
		Region getRegion = regionService.getRegionById(regionId);
		return new ResponseEntity<Region>(getRegion, HttpStatus.OK);
	}

	// Get All Region

	@GetMapping("/all")
	public ResponseEntity<List<Region>> getAllRegion() {
		List<Region> regionList = regionService.regionList();
		return new ResponseEntity<List<Region>>(regionList, HttpStatus.OK);
	}

	// Delete Region
	@DeleteMapping("/delete/{regionId}")
	public void deleteRegion(@PathVariable("regionId") int regionId) {
		regionService.deleteRegion(regionId);
	}
}
