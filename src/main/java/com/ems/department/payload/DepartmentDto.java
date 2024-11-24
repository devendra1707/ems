package com.ems.department.payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {

	private int departmentId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
