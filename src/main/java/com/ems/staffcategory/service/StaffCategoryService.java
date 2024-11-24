package com.ems.staffcategory.service;

import java.util.List;

import com.ems.staffcategory.payload.StaffCategoryDto;

public interface StaffCategoryService {

	public StaffCategoryDto createStaffCategory(StaffCategoryDto staffCategoryDto);

	public StaffCategoryDto updateStaffCategory(int staffCategoryId, StaffCategoryDto staffCategoryDto);

	public StaffCategoryDto getStaffCategory(int staffCategoryId);

	public List<StaffCategoryDto> staffCategoryList();

	public void deleteStaffCategory(int staffCategoryId);
}
