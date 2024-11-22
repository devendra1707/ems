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
import org.springframework.web.bind.annotation.RestController;

import com.ems.adg.model.Adg;
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
	public ResponseEntity<Adg> createAdg(@RequestBody Adg adg) {
		Adg createAdg = adgService.createAdg(adg);

		return new ResponseEntity<Adg>(createAdg, HttpStatus.CREATED);
	}

	// update ADG
	@PutMapping("/update/{adgId}")
	public ResponseEntity<Adg> updateAdg(@PathVariable("adgId") int adgId, @RequestBody Adg adg) {
		Adg updateAdg = adgService.updateAdg(adgId, adg);
		return new ResponseEntity<Adg>(updateAdg, HttpStatus.OK);
	}

	// Get Adg By Id
	@GetMapping("/get/{adgId}")
	public ResponseEntity<Adg> getAdgById(@PathVariable("adgId") int adgId) {
		Adg getAdg = adgService.getAdgById(adgId);
		return new ResponseEntity<Adg>(getAdg, HttpStatus.OK);
	}

	// Get All Adg

	@GetMapping("/all")	
	public ResponseEntity<List<Adg>> getAllAdg() {
		List<Adg> adgList = adgService.adgList();
		return new ResponseEntity<List<Adg>>(adgList, HttpStatus.OK);
	}

	// Delete Adg
	@DeleteMapping("/delete/{adgId}")
	public void deleteAdg(@PathVariable("adgId") int adgId) {
		adgService.deleteAdg(adgId);
	}
	
}
