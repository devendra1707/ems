package com.ems.designation.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.designation.exception.DesignationNotFoundException;
import com.ems.designation.model.Designation;
import com.ems.designation.payload.DesignationDto;
import com.ems.designation.repo.DesignationRepo;
import com.ems.designation.service.DesignationService;
import com.ems.region.exception.RegionNotFoundException;
import com.ems.staffcategory.model.StaffCategory;
import com.ems.staffcategory.repo.StaffCategoryRepo;

@Service
public class DesignationServiceImpl implements DesignationService {

	private DesignationRepo designationRepo;
	private ModelMapper modelMapper;
	private StaffCategoryRepo staffCategoryRepo;

	public DesignationServiceImpl(DesignationRepo designationRepo, ModelMapper modelMapper,
			StaffCategoryRepo staffCategoryRepo) {
		this.designationRepo = designationRepo;
		this.modelMapper = modelMapper;
		this.staffCategoryRepo = staffCategoryRepo;
	}

	@Override
	public DesignationDto createDesignation(DesignationDto designationDto, int staffCategoryId) {

		StaffCategory staffCategory = staffCategoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new RegionNotFoundException("Staff Category Not Found"));

		Designation createDesignation = modelMapper.map(designationDto, Designation.class);
		createDesignation.setStaffCategory(staffCategory);
		Designation saveDesignation = designationRepo.save(createDesignation);
		return modelMapper.map(saveDesignation, DesignationDto.class);
	}

	@Override
	public DesignationDto updateDesignation(int designationId, DesignationDto designationDto, int staffCategoryId) {
		Designation designation = designationRepo.findById(designationId)
				.orElseThrow(() -> new DesignationNotFoundException("Designation Not Found"));
		StaffCategory staffCategory = staffCategoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new RegionNotFoundException("Staff Category Not Found"));

		designation.setTitle(designationDto.getTitle());
		designation.setLevel(designationDto.getLevel());
		designation.setStaffCategory(staffCategory);
		Designation updateDesignation = designationRepo.save(designation);

		return modelMapper.map(updateDesignation, DesignationDto.class);
	}

	@Override
	public DesignationDto getDesignation(int designationId) {

		Designation getDesignation = designationRepo.findById(designationId)
				.orElseThrow(() -> new DesignationNotFoundException("Designation Not Found"));
		return modelMapper.map(getDesignation, DesignationDto.class);
	}

	@Override
	public List<DesignationDto> designationList() {
		List<Designation> designationList = designationRepo.findAll();
		List<DesignationDto> designationDtos = designationList.stream()
				.map(des -> modelMapper.map(des, DesignationDto.class)).collect(Collectors.toList());
		return designationDtos;
	}

	@Override
	public void deleteDesignation(int designationId) {
		designationRepo.deleteById(designationId);
	}

}
