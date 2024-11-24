package com.ems.adg.controller;

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

import com.ems.adg.payload.AdgDto;
import com.ems.adg.service.AdgService;

@RestController
@RequestMapping("/adg")
public class AdgController {

	private AdgService adgService;

	public AdgController(AdgService adgService) {
		this.adgService = adgService;
	}

	// Create ADG
	@PostMapping("/create")
	public ResponseEntity<AdgDto> createAdg(@RequestBody AdgDto adg, @RequestParam int regionId) {
		AdgDto createAdg = adgService.createAdg(adg, regionId);

		return new ResponseEntity<AdgDto>(createAdg, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{adgId}")
	public ResponseEntity<AdgDto> updateAdg(@PathVariable("adgId") int adgId, @RequestBody AdgDto adg,
			@RequestParam int regionId) {
		AdgDto updateAdg = adgService.updateAdg(adgId, adg, regionId);
		return new ResponseEntity<AdgDto>(updateAdg, HttpStatus.OK);
	}

	// Get Adg By Id
	@GetMapping("/get/{adgId}")
	public ResponseEntity<AdgDto> getAdgById(@PathVariable("adgId") int adgId) {
		AdgDto getAdg = adgService.getAdgById(adgId);
		return new ResponseEntity<AdgDto>(getAdg, HttpStatus.OK);
	}

	// Get All Adg

	@GetMapping("/all")
	public ResponseEntity<List<AdgDto>> getAllAdg() {
		List<AdgDto> adgList = adgService.adgList();
		return new ResponseEntity<List<AdgDto>>(adgList, HttpStatus.OK);
	}

	// Delete Adg
	@DeleteMapping("/delete/{adgId}")
	public void deleteAdg(@PathVariable("adgId") int adgId) {
		adgService.deleteAdg(adgId);
	}

}
