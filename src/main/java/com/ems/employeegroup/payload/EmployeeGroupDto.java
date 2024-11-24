package com.ems.employeegroup.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeGroupDto {

	private int employeeGroupId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
