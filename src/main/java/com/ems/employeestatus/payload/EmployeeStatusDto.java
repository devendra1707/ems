package com.ems.employeestatus.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeStatusDto {

	private int employeeStatusId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
