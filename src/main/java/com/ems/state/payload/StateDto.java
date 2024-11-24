package com.ems.state.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDto {

	private int stateId;

	private String name;
	private String aboutState;
	private String totalProjects;
	private String totalProjectsCompleted;
	private String totalOffices;
	private String stateCode;
	private String Path;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;
}
