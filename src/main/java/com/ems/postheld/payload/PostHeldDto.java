package com.ems.postheld.payload;

import java.util.Date;

import com.ems.staffcategory.model.StaffCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostHeldDto {

	private int postHeldId;

	private String title;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	private StaffCategory staffCategory;

}
