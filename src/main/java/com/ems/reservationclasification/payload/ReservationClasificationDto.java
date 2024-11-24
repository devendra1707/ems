package com.ems.reservationclasification.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationClasificationDto {

	private int reservationClasificationId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
