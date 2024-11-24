package com.ems.designation.service;

import java.util.List;

import com.ems.designation.payload.DesignationDto;

public interface DesignationService {

	public DesignationDto createDesignation(DesignationDto designationDto, int staffCategoryId);

	public DesignationDto updateDesignation(int designationId, DesignationDto designationDto, int staffCategoryId);

	public DesignationDto getDesignation(int designationId);

	public List<DesignationDto> designationList();

	public void deleteDesignation(int designationId);

}
