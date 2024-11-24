package com.ems.division.payload;

import java.util.Date;

import com.ems.circle.model.Circle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DivisionDto {

	private int divisionId;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	private Circle circle;

}
