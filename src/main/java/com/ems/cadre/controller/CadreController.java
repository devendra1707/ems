package com.ems.cadre.controller;

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

import com.ems.cadre.payload.CadreDto;
import com.ems.cadre.service.CadreService;

@RestController
@RequestMapping("/cadre")
public class CadreController {

	private CadreService cadreService;

	public CadreController(CadreService cadreService) {
		this.cadreService = cadreService;
	}

	// Create Cadre

	@PostMapping("/create")
	public ResponseEntity<CadreDto> createCadre(@RequestBody CadreDto cadre) {
		CadreDto createCadre = cadreService.createCadre(cadre);

		return new ResponseEntity<CadreDto>(createCadre, HttpStatus.CREATED);
	}

	// Update Cadre

	@PutMapping("/update/{cadreId}")
	public ResponseEntity<CadreDto> updateCadre(@PathVariable("cadreId") int cadreId, @RequestBody CadreDto cadre) {
		CadreDto updateCadre = cadreService.updateCadre(cadreId, cadre);
		return new ResponseEntity<CadreDto>(updateCadre, HttpStatus.OK);
	}

	// Get Cadre By Id

	@GetMapping("/{cadreId}")
	public ResponseEntity<CadreDto> getCadreById(@PathVariable("cadreId") int cadreId) {
		CadreDto getCadre = cadreService.getCadre(cadreId);
		return new ResponseEntity<CadreDto>(getCadre, HttpStatus.OK);
	}

	// Get All Cadre

	@GetMapping("/")
	public ResponseEntity<List<CadreDto>> getAllCadre() {
		List<CadreDto> cadreList = cadreService.cadreList();
		return new ResponseEntity<List<CadreDto>>(cadreList, HttpStatus.OK);
	}

	// Delete Cadre

	@DeleteMapping("/{cadreId}")
	public void deleteCadre(@PathVariable("cadreId") int cadreId) {
		cadreService.deleteCadre(cadreId);
	}

}
