package com.ems.reservationclasification.controller;

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

import com.ems.reservationclasification.model.ReservationClasification;
import com.ems.reservationclasification.service.ReservationClasificationService;

@RestController
@RequestMapping("/reservationClasification")
public class ReservationClasificationController {
	private ReservationClasificationService reservationClasificationService;

	public ReservationClasificationController(ReservationClasificationService reservationClasificationService) {
		this.reservationClasificationService = reservationClasificationService;
	}

	// Create ReservationClasification

	@PostMapping("/create")
	public ResponseEntity<ReservationClasification> createReservationClasification(
			@RequestBody ReservationClasification reservationClasification) {
		ReservationClasification createReservationClasification = reservationClasificationService
				.createReservationClasification(reservationClasification);

		return new ResponseEntity<ReservationClasification>(createReservationClasification, HttpStatus.CREATED);
	}

	// Update ReservationClasification

	@PutMapping("/update/{reservationClasificationId}")
	public ResponseEntity<ReservationClasification> updateReservationClasification(
			@PathVariable("reservationClasificationId") int reservationClasificationId,
			@RequestBody ReservationClasification reservationClasification) {
		ReservationClasification updateReservationClasification = reservationClasificationService
				.updateReservationClasification(reservationClasificationId, reservationClasification);
		return new ResponseEntity<ReservationClasification>(updateReservationClasification, HttpStatus.OK);
	}

	// Get ReservationClasification By Id

	@GetMapping("/{reservationClasificationId}")
	public ResponseEntity<ReservationClasification> getReservationClasificationById(
			@PathVariable("reservationClasificationId") int reservationClasificationId) {
		ReservationClasification getReservationClasification = reservationClasificationService
				.getReservationClasification(reservationClasificationId);
		return new ResponseEntity<ReservationClasification>(getReservationClasification, HttpStatus.OK);
	}

	// Get All ReservationClasification

	@GetMapping("/")
	public ResponseEntity<List<ReservationClasification>> getAllReservationClasification() {
		List<ReservationClasification> reservationClasificationList = reservationClasificationService
				.reservationClasificationList();
		return new ResponseEntity<List<ReservationClasification>>(reservationClasificationList, HttpStatus.OK);
	}

	// Delete ReservationClasification

	@DeleteMapping("/{reservationClasificationId}")
	public void deleteReservationClasification(
			@PathVariable("reservationClasificationId") int reservationClasificationId) {
		reservationClasificationService.deleteReservationClasification(reservationClasificationId);
	}
}
