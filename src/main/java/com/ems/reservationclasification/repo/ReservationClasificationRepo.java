package com.ems.reservationclasification.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.reservationclasification.model.ReservationClasification;

public interface ReservationClasificationRepo extends JpaRepository<ReservationClasification, Integer>{

}
