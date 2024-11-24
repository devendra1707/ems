package com.ems.staffcategory.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ems.designation.model.Designation;
import com.ems.postheld.model.PostHeld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StaffCategoryDto {

	private int staffCategoryId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

//	private List<Designation> designations = new ArrayList<>();
//
//	private List<PostHeld> postHelds = new ArrayList<>();

}
