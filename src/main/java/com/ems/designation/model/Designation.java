package com.ems.designation.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.ems.staffcategory.model.StaffCategory;

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
@Table(name = "designation")
@Entity
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int designationId;

	private String title;
	private String level;

	@CreationTimestamp
	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	@ManyToOne
	@JoinColumn(name = "staffCategory_id")
	private StaffCategory staffCategory;
	
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
