package com.genospace.exercise.inventory.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "Drug")
public class Drug {
	
		@Id
		@GeneratedValue(generator = "UUID")
		@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
		@Column(name = "Drug_Id")
		private UUID id;

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getMainName() {
			return mainName;
		}

		public void setMainName(String mainName) {
			this.mainName = mainName;
		}

		@Column(name = "Generic_Name")
		@NotNull
		private String genericName;

		public String getGenericName() {
			return genericName;
		}

		public void setGenericName(String genericName) {
			this.genericName = genericName;
		}

		@Column(name = "Main_Name")
		private String mainName;
		@JsonIgnore
		@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@JoinTable(name = "Drug_Mechanism", joinColumns = { @JoinColumn(name = "Drug_id") }, inverseJoinColumns = {
				@JoinColumn(name = "Mechanism_id") })
		private Set<Mechanism> mechanisms = new HashSet<>();

		public Set<Mechanism> getMechanisms() {
			return mechanisms;
		}

		public void setMechanisms(Set<Mechanism> mechanisms) {
			this.mechanisms = mechanisms;
		}

	}


