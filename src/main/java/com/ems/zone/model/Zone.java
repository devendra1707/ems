package com.ems.zone.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.ems.adg.model.Adg;
import com.ems.circle.model.Circle;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "zone")
@Entity
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int zoneId;

	private String name;

	@CreationTimestamp
	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	@OneToMany(mappedBy = "zone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Circle> circle = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "adg_id")
	private Adg adg;
	
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
