package com.ems.station.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.ems.state.model.State;

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
@Table(name = "station")
@Entity
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stationId;

	private String name;

	@CreationTimestamp
	private Date createdDate;

	private Date modifiedDate;

	private String uuid;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

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
