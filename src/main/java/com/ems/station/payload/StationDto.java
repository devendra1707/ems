package com.ems.station.payload;

import java.util.Date;

import com.ems.state.model.State;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StationDto {

	private int stationId;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;
	private State state;

}
