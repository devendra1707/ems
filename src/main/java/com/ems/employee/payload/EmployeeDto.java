package com.ems.employee.payload;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.ems.adg.model.Adg;
import com.ems.cadre.model.Cadre;
import com.ems.circle.model.Circle;
import com.ems.department.model.Department;
import com.ems.designation.model.Designation;
import com.ems.division.model.Division;
import com.ems.employeegroup.model.EmployeeGroup;
import com.ems.employeestatus.model.EmployeeStatus;
import com.ems.gender.model.Gender;
import com.ems.payscale.model.PayScale;
import com.ems.postheld.model.PostHeld;
import com.ems.region.model.Region;
import com.ems.reservationclasification.model.ReservationClasification;
import com.ems.specialisation.model.Specialisation;
import com.ems.staffcategory.model.StaffCategory;
import com.ems.station.model.Station;
import com.ems.zone.model.Zone;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private int employeeId;

	private String firstName;
	private String middleName;
	private String lastName;
	private String dateofBirth;
	private String father_HusbandName;
	private String employeeCode;
	private String currentOffice;
	private String reportingOffice;
	private String doPTBatch;
	private String dateOfJoiningCurrentOffice;
	private String referenceToOrderOfPosting;
	private String additionalCharge;
	private String additionalDuty;

	private Gender gender;

	private Department department;

	private Region region;

	private Adg adg;

	private Zone zone;

	private Circle circle;

	private Division division;

	private EmployeeGroup employeeGroup;

	private StaffCategory staffCategory;

	private Designation designation;

	private PostHeld postHeld;

	private Cadre cadre;

	private Specialisation specialisation;

	private ReservationClasification reservationClasification;

	private Station station;

	private EmployeeStatus employeeStatus;

	private PayScale payScale;

	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

}
