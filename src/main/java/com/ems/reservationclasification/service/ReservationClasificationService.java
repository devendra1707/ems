package com.ems.reservationclasification.service;

import java.util.List;

import com.ems.reservationclasification.model.ReservationClasification;

public interface ReservationClasificationService {
	public ReservationClasification createReservationClasification(ReservationClasification reservationClasification);

	public ReservationClasification updateReservationClasification(int reservationClasificationId,
			ReservationClasification reservationClasification);

	public ReservationClasification getReservationClasification(int reservationClasificationId);

	public List<ReservationClasification> reservationClasificationList();

	public void deleteReservationClasification(int reservationClasificationId);
}
