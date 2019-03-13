package com.genospace.exercise.inventory.model.DTO;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.genospace.exercise.inventory.model.Drug;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MechanismDTO {
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	private String name;
	
	
	private Set<Drug> drugs = new HashSet<>();

	public Set<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Drug> drugs) {
		this.drugs = drugs;
	}

}
