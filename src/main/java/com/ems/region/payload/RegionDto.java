package com.ems.region.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.adg.model.Adg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegionDto {

	private int regionId;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

//	private List<Adg> adg = new ArrayList<>();

}
