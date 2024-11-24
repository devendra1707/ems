package com.ems.adg.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.region.model.Region;
import com.ems.zone.model.Zone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdgDto {

	private int adgId;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	private Region region;
//	private List<Zone> zones = new ArrayList<>();


}
