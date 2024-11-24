package com.ems.reservationclasification.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.reservationclasification.exception.ReservationClasificationNotFoundException;
import com.ems.reservationclasification.model.ReservationClasification;
import com.ems.reservationclasification.payload.ReservationClasificationDto;
import com.ems.reservationclasification.repo.ReservationClasificationRepo;
import com.ems.reservationclasification.service.ReservationClasificationService;

@Service
public class ReservationClasificationServiceImpl implements ReservationClasificationService {
	private ReservationClasificationRepo reservationClasificationRepo;
	private ModelMapper modelMapper;

	public ReservationClasificationServiceImpl(ReservationClasificationRepo reservationClasificationRepo,
			ModelMapper modelMapper) {
		this.reservationClasificationRepo = reservationClasificationRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ReservationClasificationDto createReservationClasification(
			ReservationClasificationDto reservationClasificationDto) {
		ReservationClasification reservationClasification = modelMapper.map(reservationClasificationDto,
				ReservationClasification.class);
		ReservationClasification saveReservationClasification = reservationClasificationRepo
				.save(reservationClasification);
		return modelMapper.map(saveReservationClasification, ReservationClasificationDto.class);
	}

	@Override
	public ReservationClasificationDto updateReservationClasification(int reservationClasificationId,
			ReservationClasificationDto reservationClasificationDto) {
		ReservationClasification reservationClasification = reservationClasificationRepo
				.findById(reservationClasificationId)
				.orElseThrow(() -> new ReservationClasificationNotFoundException("ReservationClasification Not Found"));

		reservationClasification.setTitle(reservationClasification.getTitle());
		ReservationClasification updateReservationClasification = reservationClasificationRepo
				.save(reservationClasification);

		return modelMapper.map(updateReservationClasification, ReservationClasificationDto.class);
	}

	@Override
	public ReservationClasificationDto getReservationClasification(int reservationClasificationId) {

		ReservationClasification reservationClasification = reservationClasificationRepo
				.findById(reservationClasificationId)
				.orElseThrow(() -> new ReservationClasificationNotFoundException("ReservationClasification Not Found"));
		return modelMapper.map(reservationClasification, ReservationClasificationDto.class);
	}

	@Override
	public List<ReservationClasificationDto> reservationClasificationList() {
		List<ReservationClasification> reservationClasifications = reservationClasificationRepo.findAll();
		List<ReservationClasificationDto> clasificationDtos = reservationClasifications.stream()
				.map((res) -> modelMapper.map(res, ReservationClasificationDto.class)).collect(Collectors.toList());
		return clasificationDtos;
	}

	@Override
	public void deleteReservationClasification(int reservationClasificationId) {
		reservationClasificationRepo.deleteById(reservationClasificationId);
	}
}
