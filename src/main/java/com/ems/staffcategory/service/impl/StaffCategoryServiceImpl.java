package com.ems.staffcategory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.staffcategory.exception.StaffCategoryNotFoundException;
import com.ems.staffcategory.model.StaffCategory;
import com.ems.staffcategory.payload.StaffCategoryDto;
import com.ems.staffcategory.repo.StaffCategoryRepo;
import com.ems.staffcategory.service.StaffCategoryService;

@Service
public class StaffCategoryServiceImpl implements StaffCategoryService {
	private StaffCategoryRepo staffCategoryRepo;
	private ModelMapper modelMapper;

	public StaffCategoryServiceImpl(StaffCategoryRepo staffCategoryRepo, ModelMapper modelMapper) {
		this.staffCategoryRepo = staffCategoryRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public StaffCategoryDto createStaffCategory(StaffCategoryDto staffCategoryDto) {
		StaffCategory staffCategory = modelMapper.map(staffCategoryDto, StaffCategory.class);
		StaffCategory saveStaffCategory = staffCategoryRepo.save(staffCategory);
		return modelMapper.map(saveStaffCategory, StaffCategoryDto.class);
	}

	@Override
	public StaffCategoryDto updateStaffCategory(int staffCategoryId, StaffCategoryDto staffCategoryDto) {
		StaffCategory staffCategory = staffCategoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("StaffCategory Not Found"));

		staffCategory.setTitle(staffCategory.getTitle());
		StaffCategory updateStaffCategory = staffCategoryRepo.save(staffCategory);

		return modelMapper.map(updateStaffCategory, StaffCategoryDto.class);
	}

	@Override
	public StaffCategoryDto getStaffCategory(int staffCategoryId) {

		StaffCategory staffCategory = staffCategoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("StaffCategory Not Found"));
		return modelMapper.map(staffCategory, StaffCategoryDto.class);
	}

	@Override
	public List<StaffCategoryDto> staffCategoryList() {
		List<StaffCategory> staffCategories = staffCategoryRepo.findAll();
		List<StaffCategoryDto> staffCategoryDtos = staffCategories.stream()
				.map((staff) -> modelMapper.map(staff, StaffCategoryDto.class)).collect(Collectors.toList());
		return staffCategoryDtos;
	}

	@Override
	public void deleteStaffCategory(int staffCategoryId) {
		staffCategoryRepo.deleteById(staffCategoryId);
	}
}
