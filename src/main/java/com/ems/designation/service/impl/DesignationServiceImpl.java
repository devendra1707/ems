package com.ems.designation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.designation.exception.DesignationNotFoundException;
import com.ems.designation.model.Designation;
import com.ems.designation.repo.DesignationRepo;
import com.ems.designation.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	private DesignationRepo designationRepo;

	public DesignationServiceImpl(DesignationRepo designationRepo) {
		this.designationRepo = designationRepo;
	}

	@Override
	public Designation createDesignation(Designation designation) {
		Designation createDesignation = designationRepo.save(designation);
		return createDesignation;
	}

	@Override
	public Designation updateDesignation(int designationId, Designation designation) {
		Designation getDesignation = designationRepo.findById(designationId)
				.orElseThrow(() -> new DesignationNotFoundException("Designation Not Found"));
		if (getDesignation != null) {
			getDesignation.setTitle(designation.getTitle());
			getDesignation.setLevel(designation.getLevel());

			designationRepo.save(getDesignation);
		}

		return getDesignation;
	}

	@Override
	public Designation getDesignation(int designationId) {

		Designation getDesignation = designationRepo.findById(designationId)
				.orElseThrow(() -> new DesignationNotFoundException("Designation Not Found"));
		return getDesignation;
	}

	@Override
	public List<Designation> designationList() {
		List<Designation> designationList = designationRepo.findAll();
		return designationList;
	}

	@Override
	public void deleteDesignation(int designationId) {
		designationRepo.deleteById(designationId);
	}
}
