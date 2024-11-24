package com.ems.zone.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.adg.model.Adg;
import com.ems.circle.model.Circle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZoneDto {

	private int zoneId;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

//	private List<Circle> circle = new ArrayList<>();

	private Adg adg;

}
