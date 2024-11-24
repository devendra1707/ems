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

import com.ems.reservationclasification.payload.ReservationClasificationDto;
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
	public ResponseEntity<ReservationClasificationDto> createReservationClasification(
			@RequestBody ReservationClasificationDto reservationClasification) {
		ReservationClasificationDto createReservationClasification = reservationClasificationService
				.createReservationClasification(reservationClasification);

		return new ResponseEntity<ReservationClasificationDto>(createReservationClasification, HttpStatus.CREATED);
	}

	// Update ReservationClasification

	@PutMapping("/update/{reservationClasificationId}")
	public ResponseEntity<ReservationClasificationDto> updateReservationClasification(
			@PathVariable("reservationClasificationId") int reservationClasificationId,
			@RequestBody ReservationClasificationDto reservationClasification) {
		ReservationClasificationDto updateReservationClasification = reservationClasificationService
				.updateReservationClasification(reservationClasificationId, reservationClasification);
		return new ResponseEntity<ReservationClasificationDto>(updateReservationClasification, HttpStatus.OK);
	}

	// Get ReservationClasification By Id

	@GetMapping("/{reservationClasificationId}")
	public ResponseEntity<ReservationClasificationDto> getReservationClasificationById(
			@PathVariable("reservationClasificationId") int reservationClasificationId) {
		ReservationClasificationDto getReservationClasification = reservationClasificationService
				.getReservationClasification(reservationClasificationId);
		return new ResponseEntity<ReservationClasificationDto>(getReservationClasification, HttpStatus.OK);
	}

	// Get All ReservationClasification

	@GetMapping("/")
	public ResponseEntity<List<ReservationClasificationDto>> getAllReservationClasification() {
		List<ReservationClasificationDto> reservationClasificationList = reservationClasificationService
				.reservationClasificationList();
		return new ResponseEntity<List<ReservationClasificationDto>>(reservationClasificationList, HttpStatus.OK);
	}

	// Delete ReservationClasification

	@DeleteMapping("/{reservationClasificationId}")
	public void deleteReservationClasification(
			@PathVariable("reservationClasificationId") int reservationClasificationId) {
		reservationClasificationService.deleteReservationClasification(reservationClasificationId);
	}
}
