package com.ems.staffcategory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.staffcategory.exception.StaffCategoryNotFoundException;
import com.ems.staffcategory.model.StaffCategory;
import com.ems.staffcategory.repo.StaffCategoryRepo;
import com.ems.staffcategory.service.StaffCategoryService;

@Service
public class StaffCategoryServiceImpl implements StaffCategoryService {
	private StaffCategoryRepo staffCategoryRepo;

	public StaffCategoryServiceImpl(StaffCategoryRepo staffCategoryRepo) {
		this.staffCategoryRepo = staffCategoryRepo;
	}

	@Override
	public StaffCategory createStaffCategory(StaffCategory staffCategory) {
		StaffCategory createStaffCategory = staffCategoryRepo.save(staffCategory);
		return createStaffCategory;
	}

	@Override
	public StaffCategory updateStaffCategory(int staffCategoryId, StaffCategory staffCategory) {
		StaffCategory getStaffCategory = staffCategoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("StaffCategory Not Found"));
		if (getStaffCategory != null) {
			getStaffCategory.setTitle(staffCategory.getTitle());
			staffCategoryRepo.save(getStaffCategory);
		}

		return getStaffCategory;
	}

	@Override
	public StaffCategory getStaffCategory(int staffCategoryId) {

		StaffCategory getStaffCategory = staffCategoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("StaffCategory Not Found"));
		return getStaffCategory;
	}

	@Override
	public List<StaffCategory> staffCategoryList() {
		List<StaffCategory> staffCategoryList = staffCategoryRepo.findAll();
		return staffCategoryList;
	}

	@Override
	public void deleteStaffCategory(int staffCategoryId) {
		staffCategoryRepo.deleteById(staffCategoryId);
	}
}
