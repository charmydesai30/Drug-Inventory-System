package com.genospace.exercise.inventory.model.DTO;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.genospace.exercise.inventory.model.Mechanism;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class DrugDTO {
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

	
	private String genericName;

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	
	private String mainName;

	
	private Set<Mechanism> mechanisms = new HashSet<>();

	public Set<Mechanism> getMechanisms() {
		return mechanisms;
	}

	public void setMechanisms(Set<Mechanism> mechanisms) {
		this.mechanisms = mechanisms;
	}

}
