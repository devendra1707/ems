package com.ems.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.adg.exception.AdgNotFoundException;
import com.ems.adg.model.Adg;
import com.ems.adg.repo.AdgRepo;
import com.ems.cadre.exception.CadreNotFoundException;
import com.ems.cadre.model.Cadre;
import com.ems.cadre.repo.CadreRepo;
import com.ems.circle.exception.CircleNotFoundExcepption;
import com.ems.circle.model.Circle;
import com.ems.circle.repo.CircleRepo;
import com.ems.department.exception.DepartmentNotFoundException;
import com.ems.department.model.Department;
import com.ems.department.repo.DepartmentRepo;
import com.ems.designation.exception.DesignationNotFoundException;
import com.ems.designation.model.Designation;
import com.ems.designation.repo.DesignationRepo;
import com.ems.division.exception.DivisionNotFoundException;
import com.ems.division.model.Division;
import com.ems.division.repo.DivisionRepo;
import com.ems.employee.exception.EmployeeNotFoundExcepption;
import com.ems.employee.model.Employee;
import com.ems.employee.payload.EmployeeDto;
import com.ems.employee.repo.EmployeeRepo;
import com.ems.employee.service.EmployeeService;
import com.ems.employeegroup.exception.EmployeeGroupNotFoundException;
import com.ems.employeegroup.model.EmployeeGroup;
import com.ems.employeegroup.repo.EmployeeGroupRepo;
import com.ems.employeestatus.exception.EmployeeStatusNotFoundException;
import com.ems.employeestatus.model.EmployeeStatus;
import com.ems.employeestatus.repo.EmployeeStatusRepo;
import com.ems.gender.exception.GenderNotFoundException;
import com.ems.gender.model.Gender;
import com.ems.gender.repo.GenderRepository;
import com.ems.payscale.exception.PayScaleNotFoundException;
import com.ems.payscale.model.PayScale;
import com.ems.payscale.repo.PayScaleRepo;
import com.ems.postheld.exception.PostHeldNotFoundException;
import com.ems.postheld.model.PostHeld;
import com.ems.postheld.repo.PostHeldRepo;
import com.ems.region.exception.RegionNotFoundException;
import com.ems.region.model.Region;
import com.ems.region.repo.RegionRepo;
import com.ems.reservationclasification.exception.ReservationClasificationNotFoundException;
import com.ems.reservationclasification.model.ReservationClasification;
import com.ems.reservationclasification.repo.ReservationClasificationRepo;
import com.ems.specialisation.exception.SpecialisationNotFoundException;
import com.ems.specialisation.model.Specialisation;
import com.ems.specialisation.repo.SpecialisationRepo;
import com.ems.staffcategory.exception.StaffCategoryNotFoundException;
import com.ems.staffcategory.model.StaffCategory;
import com.ems.staffcategory.repo.StaffCategoryRepo;
import com.ems.station.exception.StationNotFoundException;
import com.ems.station.model.Station;
import com.ems.station.repo.StationRepo;
import com.ems.zone.exception.ZoneNotFoundException;
import com.ems.zone.model.Zone;
import com.ems.zone.repo.ZoneRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired

	private StaffCategoryRepo categoryRepo;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private RegionRepo regionRepo;

	@Autowired
	private AdgRepo adgRepo;

	@Autowired
	private ZoneRepo zoneRepo;

	@Autowired
	private CircleRepo circleRepo;

	@Autowired
	private DivisionRepo divisionRepo;

	@Autowired
	private EmployeeGroupRepo employeeGroupRepo;

	@Autowired
	private DesignationRepo designationRepo;

	@Autowired
	private PostHeldRepo postHeldRepo;

	@Autowired
	private CadreRepo cadreRepo;

	@Autowired
	private SpecialisationRepo specialisationRepo;

	@Autowired
	private ReservationClasificationRepo reservationClasificationRepo;

	@Autowired
	private StationRepo stationRepo;

	@Autowired
	private EmployeeStatusRepo employeeStatusRepo;

	@Autowired
	private PayScaleRepo payScaleRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto, int staffCategoryId, int genderId, int departmentId,
			int regionId, int adgId, int zoneId, int circleId, int divisionId, int employeeGroupId, int designationId,
			int postHeldId, int cadreId, int specialisationId, int reservationClasificationId, int stationId,
			int employeeStatusId, int payScaleId) {

		Circle circle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));

		StaffCategory staffCategory = categoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("Staff Category Not Found"));

		Gender gender = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender Not Found"));

		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));

		Region region = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not Found"));

		Adg adg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not Found"));

		Zone zone = zoneRepo.findById(zoneId).orElseThrow(() -> new ZoneNotFoundException("Zone Not Found"));

		Division division = divisionRepo.findById(divisionId)
				.orElseThrow(() -> new DivisionNotFoundException("Division Not Found"));

		EmployeeGroup employeeGroup = employeeGroupRepo.findById(employeeGroupId)
				.orElseThrow(() -> new EmployeeGroupNotFoundException("EmployeeGroup Not Found"));

		Designation designation = designationRepo.findById(designationId)
				.orElseThrow(() -> new DesignationNotFoundException("Designation Not Found"));

		PostHeld postHeld = postHeldRepo.findById(postHeldId)
				.orElseThrow(() -> new PostHeldNotFoundException("PostHeld Not Found"));

		Specialisation specialisation = specialisationRepo.findById(specialisationId)
				.orElseThrow(() -> new SpecialisationNotFoundException("Specialisation Not Found"));

		Cadre cadre = cadreRepo.findById(cadreId).orElseThrow(() -> new CadreNotFoundException("Cadre Not Found"));

		ReservationClasification reservationClasification = reservationClasificationRepo
				.findById(reservationClasificationId)
				.orElseThrow(() -> new ReservationClasificationNotFoundException("ReservationClasification Not Found"));

		Station station = stationRepo.findById(stationId)
				.orElseThrow(() -> new StationNotFoundException("Station Not Found"));

		EmployeeStatus employeeStatus = employeeStatusRepo.findById(employeeStatusId)
				.orElseThrow(() -> new EmployeeStatusNotFoundException("EmployeeStatus Not Found"));

		PayScale payScale = payScaleRepo.findById(payScaleId)
				.orElseThrow(() -> new PayScaleNotFoundException("PayScale Not Found"));

		Employee employee = modelMapper.map(employeeDto, Employee.class);

		employee.setGender(gender);
		employee.setDepartment(department);
		employee.setRegion(region);
		employee.setAdg(adg);
		employee.setZone(zone);
		employee.setCircle(circle);
		employee.setDivision(division);
		employee.setEmployeeGroup(employeeGroup);
		employee.setStaffCategory(staffCategory);
		employee.setDesignation(designation);
		employee.setPostHeld(postHeld);
		employee.setCadre(cadre);
		employee.setSpecialisation(specialisation);
		employee.setReservationClasification(reservationClasification);
		employee.setStation(station);
		employee.setEmployeeStatus(employeeStatus);
		employee.setPayScale(payScale);

		Employee saveEmployee = employeeRepo.save(employee);

		return modelMapper.map(saveEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto, int staffCategoryId, int genderId,
			int departmentId, int regionId, int adgId, int zoneId, int circleId, int divisionId, int employeeGroupId,
			int designationId, int reservationClasificationId, int postHeldId, int cadreId, int specialisationId,
			int stationId, int employeeStatusId, int payScaleId) {

		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundExcepption("Employee Not Found"));

		Circle circle = circleRepo.findById(circleId)
				.orElseThrow(() -> new CircleNotFoundExcepption("Circle Not Found"));

		StaffCategory staffCategory = categoryRepo.findById(staffCategoryId)
				.orElseThrow(() -> new StaffCategoryNotFoundException("Staff Category Not Found"));

		Gender gender = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender Not Found"));

		Department department = departmentRepo.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));

		Region region = regionRepo.findById(regionId)
				.orElseThrow(() -> new RegionNotFoundException("Region Not Found"));

		Adg adg = adgRepo.findById(adgId).orElseThrow(() -> new AdgNotFoundException("Adg Not Found"));

		Zone zone = zoneRepo.findById(zoneId).orElseThrow(() -> new ZoneNotFoundException("Zone Not Found"));

		Division division = divisionRepo.findById(divisionId)
				.orElseThrow(() -> new DivisionNotFoundException("Division Not Found"));

		EmployeeGroup employeeGroup = employeeGroupRepo.findById(employeeGroupId)
				.orElseThrow(() -> new EmployeeGroupNotFoundException("EmployeeGroup Not Found"));

		Designation designation = designationRepo.findById(designationId)
				.orElseThrow(() -> new DesignationNotFoundException("Designation Not Found"));

		PostHeld postHeld = postHeldRepo.findById(postHeldId)
				.orElseThrow(() -> new PostHeldNotFoundException("PostHeld Not Found"));

		Specialisation specialisation = specialisationRepo.findById(specialisationId)
				.orElseThrow(() -> new SpecialisationNotFoundException("Specialisation Not Found"));

		Cadre cadre = cadreRepo.findById(cadreId).orElseThrow(() -> new CadreNotFoundException("Cadre Not Found"));

		ReservationClasification reservationClasification = reservationClasificationRepo
				.findById(reservationClasificationId)
				.orElseThrow(() -> new ReservationClasificationNotFoundException("ReservationClasification Not Found"));

		Station station = stationRepo.findById(stationId)
				.orElseThrow(() -> new StationNotFoundException("Station Not Found"));

		EmployeeStatus employeeStatus = employeeStatusRepo.findById(employeeStatusId)
				.orElseThrow(() -> new EmployeeStatusNotFoundException("EmployeeStatus Not Found"));

		PayScale payScale = payScaleRepo.findById(payScaleId)
				.orElseThrow(() -> new PayScaleNotFoundException("PayScale Not Found"));

		employee.setGender(gender);
		employee.setDepartment(department);
		employee.setRegion(region);
		employee.setAdg(adg);
		employee.setZone(zone);
		employee.setCircle(circle);
		employee.setDivision(division);
		employee.setEmployeeGroup(employeeGroup);
		employee.setStaffCategory(staffCategory);
		employee.setDesignation(designation);
		employee.setPostHeld(postHeld);
		employee.setCadre(cadre);
		employee.setSpecialisation(specialisation);
		employee.setReservationClasification(reservationClasification);
		employee.setStation(station);
		employee.setEmployeeStatus(employeeStatus);
		employee.setPayScale(payScale);

		employee.setFirstName(employeeDto.getFirstName());
		employee.setMiddleName(employeeDto.getMiddleName());
		employee.setLastName(employeeDto.getLastName());
		employee.setDateofBirth(employeeDto.getDateofBirth());
		employee.setFather_HusbandName(employeeDto.getFather_HusbandName());
		employee.setEmployeeCode(employeeDto.getEmployeeCode());
		employee.setCurrentOffice(employeeDto.getCurrentOffice());
		employee.setReportingOffice(employeeDto.getReportingOffice());
		employee.setDoPTBatch(employeeDto.getDoPTBatch());
		employee.setDateOfJoiningCurrentOffice(employeeDto.getDateOfJoiningCurrentOffice());
		employee.setReferenceToOrderOfPosting(employeeDto.getReferenceToOrderOfPosting());
		employee.setAdditionalCharge(employeeDto.getAdditionalCharge());
		employee.setAdditionalDuty(employeeDto.getAdditionalDuty());

		Employee updateEmployee = employeeRepo.save(employee);

		return modelMapper.map(updateEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployee(int employeeId) {
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundExcepption("Employee Not Found"));

		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> employeeList() {
		List<Employee> employees = employeeRepo.findAll();
		List<EmployeeDto> employeeDtos = employees.stream().map(emp -> modelMapper.map(emp, EmployeeDto.class))
				.collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public void deleteEmployee(int employeeId) {

		employeeRepo.deleteById(employeeId);
	}

}
