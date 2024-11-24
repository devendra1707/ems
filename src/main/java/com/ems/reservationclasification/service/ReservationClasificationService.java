package com.ems.reservationclasification.service;

import java.util.List;

import com.ems.reservationclasification.payload.ReservationClasificationDto;

public interface ReservationClasificationService {
	public ReservationClasificationDto createReservationClasification(
			ReservationClasificationDto reservationClasificationDto);

	public ReservationClasificationDto updateReservationClasification(int reservationClasificationId,
			ReservationClasificationDto reservationClasificationDto);

	public ReservationClasificationDto getReservationClasification(int reservationClasificationId);

	public List<ReservationClasificationDto> reservationClasificationList();

	public void deleteReservationClasification(int reservationClasificationId);
}
