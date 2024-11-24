package com.ems.designation.payload;

import java.util.Date;

import com.ems.staffcategory.model.StaffCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesignationDto {
	private int designationId;

	private String title;
	private String level;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	private StaffCategory staffCategory;

}
