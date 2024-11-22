package com.ems.reservationclasification.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.reservationclasification.exception.ReservationClasificationNotFoundException;
import com.ems.reservationclasification.model.ReservationClasification;
import com.ems.reservationclasification.repo.ReservationClasificationRepo;
import com.ems.reservationclasification.service.ReservationClasificationService;

@Service
public class ReservationClasificationServiceImpl implements ReservationClasificationService {
	private ReservationClasificationRepo reservationClasificationRepo;

	public ReservationClasificationServiceImpl(ReservationClasificationRepo reservationClasificationRepo) {
		this.reservationClasificationRepo = reservationClasificationRepo;
	}

	@Override
	public ReservationClasification createReservationClasification(ReservationClasification reservationClasification) {
		ReservationClasification createReservationClasification = reservationClasificationRepo
				.save(reservationClasification);
		return createReservationClasification;
	}

	@Override
	public ReservationClasification updateReservationClasification(int reservationClasificationId,
			ReservationClasification reservationClasification) {
		ReservationClasification getReservationClasification = reservationClasificationRepo
				.findById(reservationClasificationId)
				.orElseThrow(() -> new ReservationClasificationNotFoundException("ReservationClasification Not Found"));
		if (getReservationClasification != null) {
			getReservationClasification.setTitle(reservationClasification.getTitle());
			reservationClasificationRepo.save(getReservationClasification);
		}

		return getReservationClasification;
	}

	@Override
	public ReservationClasification getReservationClasification(int reservationClasificationId) {

		ReservationClasification getReservationClasification = reservationClasificationRepo
				.findById(reservationClasificationId)
				.orElseThrow(() -> new ReservationClasificationNotFoundException("ReservationClasification Not Found"));
		return getReservationClasification;
	}

	@Override
	public List<ReservationClasification> reservationClasificationList() {
		List<ReservationClasification> reservationClasificationList = reservationClasificationRepo.findAll();
		return reservationClasificationList;
	}

	@Override
	public void deleteReservationClasification(int reservationClasificationId) {
		reservationClasificationRepo.deleteById(reservationClasificationId);
	}
}
