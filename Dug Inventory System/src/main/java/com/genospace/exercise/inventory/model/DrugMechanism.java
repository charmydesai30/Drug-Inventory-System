package com.genospace.exercise.inventory.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class DrugMechanism {

	private UUID Id;
	private String mainName;
	private String name;
	private String Type;
	
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getMainName() {
		return mainName;
	}
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
}
