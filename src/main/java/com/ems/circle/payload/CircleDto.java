package com.ems.circle.payload;

import java.util.Date;

import com.ems.zone.model.Zone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CircleDto {

	private int circleId;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	private Zone zone;
//	private List<Division> divisions = new ArrayList<>();

}
