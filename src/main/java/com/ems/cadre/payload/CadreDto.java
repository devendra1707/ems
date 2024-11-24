package com.ems.cadre.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadreDto {

	private int cadreId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
