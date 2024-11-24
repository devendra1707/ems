package com.ems.employeestatus.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ems.employeestatus.exception.EmployeeStatusNotFoundException;
import com.ems.employeestatus.model.EmployeeStatus;
import com.ems.employeestatus.payload.EmployeeStatusDto;
import com.ems.employeestatus.repo.EmployeeStatusRepo;
import com.ems.employeestatus.service.EmployeeStatusService;

@Service
public class EmployeeStatusServiceImpl implements EmployeeStatusService {
	private EmployeeStatusRepo employeeStatusRepo;
	private ModelMapper modelMapper;

	public EmployeeStatusServiceImpl(EmployeeStatusRepo employeeStatusRepo, ModelMapper modelMapper) {
		this.employeeStatusRepo = employeeStatusRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmployeeStatusDto createEmployeeStatus(EmployeeStatusDto employeeStatusDto) {
		EmployeeStatus createEmployeeStatus = modelMapper.map(employeeStatusDto, EmployeeStatus.class);
		EmployeeStatus saveEmployeeStatus = employeeStatusRepo.save(createEmployeeStatus);
		return modelMapper.map(saveEmployeeStatus, EmployeeStatusDto.class);
	}

	@Override
	public EmployeeStatusDto updateEmployeeStatus(int employeeStatusId, EmployeeStatusDto employeeStatusDto) {
		EmployeeStatus employeeStatus = employeeStatusRepo.findById(employeeStatusId)
				.orElseThrow(() -> new EmployeeStatusNotFoundException("EmployeeStatus Not Found"));
		employeeStatus.setTitle(employeeStatus.getTitle());
		EmployeeStatus updateEmployeeStatus = employeeStatusRepo.save(employeeStatus);

		return modelMapper.map(updateEmployeeStatus, EmployeeStatusDto.class);
	}

	@Override
	public EmployeeStatusDto getEmployeeStatus(int employeeStatusId) {

		EmployeeStatus getEmployeeStatus = employeeStatusRepo.findById(employeeStatusId)
				.orElseThrow(() -> new EmployeeStatusNotFoundException("EmployeeStatus Not Found"));
		return modelMapper.map(getEmployeeStatus, EmployeeStatusDto.class);
	}

	@Override
	public List<EmployeeStatusDto> employeeStatusList() {
		List<EmployeeStatus> employeeStatusList = employeeStatusRepo.findAll();
		List<EmployeeStatusDto> dtos = employeeStatusList.stream()
				.map(emp -> modelMapper.map(emp, EmployeeStatusDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public void deleteEmployeeStatus(int employeeStatusId) {
		employeeStatusRepo.deleteById(employeeStatusId);
	}
}
