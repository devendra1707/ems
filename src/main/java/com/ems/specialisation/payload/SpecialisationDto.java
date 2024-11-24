package com.ems.specialisation.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SpecialisationDto {

	private int specialisationId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
