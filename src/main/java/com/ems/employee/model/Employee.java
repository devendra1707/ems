package com.ems.employee.model;

import java.util.Date;
import java.util.UUID;

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

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@ManyToOne
	@JoinColumn(name = "gender_id")
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;
	
	@ManyToOne
	@JoinColumn(name = "adg_id")
	private Adg adg;
	
	@ManyToOne
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	@ManyToOne
	@JoinColumn(name = "circle_id")
	private Circle circle;
	
	@ManyToOne
	@JoinColumn(name = "division_id")
	private Division division;
	
	@ManyToOne
	@JoinColumn(name = "employeeGroup_id")
	private EmployeeGroup employeeGroup;

	@ManyToOne
	@JoinColumn(name = "staffCategory_id")
	private StaffCategory staffCategory;
	
	@ManyToOne
	@JoinColumn(name = "designation_id")
	private Designation designation;
	
	@ManyToOne
	@JoinColumn(name = "postHeld_id")
	private PostHeld postHeld;
	
	@ManyToOne
	@JoinColumn(name = "cadre_id")
	private Cadre cadre;
	
	@ManyToOne
	@JoinColumn(name = "specialisation_id")
	private Specialisation specialisation;
	
	@ManyToOne
	@JoinColumn(name = "reservationClasification_id")
	private ReservationClasification reservationClasification;
	
	@ManyToOne
	@JoinColumn(name = "station_id")
	private Station station;
	
	@ManyToOne
	@JoinColumn(name = "employeeStatus_id")
	private EmployeeStatus employeeStatus;
	
	@ManyToOne
	@JoinColumn(name = "payScale_id")
	private PayScale payScale;

	@CreationTimestamp
	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	@PrePersist
	public void generateUuid() {
		if (this.uuid == null || this.uuid.isEmpty()) {
			this.uuid = UUID.randomUUID().toString();
		}
		// Set modifiedDate only when creating the entity
		if (this.modifiedDate == null) {
			this.modifiedDate = new Date();
		}
	}
}
