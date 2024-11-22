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

import com.ems.cadre.model.Cadre;
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
	public ResponseEntity<Cadre> createCadre(@RequestBody Cadre cadre) {
		Cadre createCadre = cadreService.createCadre(cadre);

		return new ResponseEntity<Cadre>(createCadre, HttpStatus.CREATED);
	}

	// Update Cadre

	@PutMapping("/update/{cadreId}")
	public ResponseEntity<Cadre> updateCadre(@PathVariable("cadreId") int cadreId, @RequestBody Cadre cadre) {
		Cadre updateCadre = cadreService.updateCadre(cadreId, cadre);
		return new ResponseEntity<Cadre>(updateCadre, HttpStatus.OK);
	}

	// Get Cadre By Id

	@GetMapping("/{cadreId}")
	public ResponseEntity<Cadre> getCadreById(@PathVariable("cadreId") int cadreId) {
		Cadre getCadre = cadreService.getCadre(cadreId);
		return new ResponseEntity<Cadre>(getCadre, HttpStatus.OK);
	}

	// Get All Cadre

	@GetMapping("/")
	public ResponseEntity<List<Cadre>> getAllCadre() {
		List<Cadre> cadreList = cadreService.cadreList();
		return new ResponseEntity<List<Cadre>>(cadreList, HttpStatus.OK);
	}

	// Delete Cadre

	@DeleteMapping("/{cadreId}")
	public void deleteCadre(@PathVariable("cadreId") int cadreId) {
		cadreService.deleteCadre(cadreId);
	}

}
