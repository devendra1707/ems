package com.ems.staffcategory.service;

import java.util.List;

import com.ems.staffcategory.model.StaffCategory;

public interface StaffCategoryService {
	
	public StaffCategory createStaffCategory(StaffCategory staffCategory);

	public StaffCategory updateStaffCategory(int staffCategoryId, StaffCategory staffCategory);

	public StaffCategory getStaffCategory(int staffCategoryId);

	public List<StaffCategory> staffCategoryList();

	public void deleteStaffCategory(int staffCategoryId);
}
