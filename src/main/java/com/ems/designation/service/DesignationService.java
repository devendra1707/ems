package com.ems.designation.service;

import java.util.List;

import com.ems.designation.model.Designation;

public interface DesignationService {

	public Designation createDesignation(Designation designation);

	public Designation updateDesignation(int designationId, Designation designation);

	public Designation getDesignation(int designationId);

	public List<Designation> designationList();

	public void deleteDesignation(int designationId);

}
