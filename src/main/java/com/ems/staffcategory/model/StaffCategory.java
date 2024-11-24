package com.ems.staffcategory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.ems.designation.model.Designation;
import com.ems.postheld.model.PostHeld;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "staffCategory")
@Entity
public class StaffCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffCategoryId;

	private String title;

	@CreationTimestamp
	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	@OneToMany(mappedBy = "staffCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Designation> designations = new ArrayList<>();

	@OneToMany(mappedBy = "staffCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PostHeld> postHelds = new ArrayList<>();

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
