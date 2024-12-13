package com.ems.gender.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GenderDto {
	private int genderId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
