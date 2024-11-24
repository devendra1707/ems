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

import com.ems.region.payload.RegionDto;
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
	public ResponseEntity<RegionDto> createRegion(@RequestBody RegionDto region) {
		RegionDto createRegion = regionService.createRegion(region);

		return new ResponseEntity<RegionDto>(createRegion, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{regionId}")
	public ResponseEntity<RegionDto> updateRegion(@PathVariable("regionId") int regionId,
			@RequestBody RegionDto region) {
		RegionDto updateRegion = regionService.updateRegion(regionId, region);
		return new ResponseEntity<RegionDto>(updateRegion, HttpStatus.OK);
	}

	// Get Region By Id
	@GetMapping("/get/{regionId}")
	public ResponseEntity<RegionDto> getRegionById(@PathVariable("regionId") int regionId) {
		RegionDto getRegion = regionService.getRegionById(regionId);
		return new ResponseEntity<RegionDto>(getRegion, HttpStatus.OK);
	}

	// Get All Region

	@GetMapping("/all")
	public ResponseEntity<List<RegionDto>> getAllRegion() {
		List<RegionDto> regionList = regionService.regionList();
		return new ResponseEntity<List<RegionDto>>(regionList, HttpStatus.OK);
	}

	// Delete Region
	@DeleteMapping("/delete/{regionId}")
	public void deleteRegion(@PathVariable("regionId") int regionId) {
		regionService.deleteRegion(regionId);
	}
}
