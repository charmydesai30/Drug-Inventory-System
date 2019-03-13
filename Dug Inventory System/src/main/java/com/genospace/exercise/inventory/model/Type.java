package com.genospace.exercise.inventory.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name ="Types")
public class Type {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID Id;
	private String name;
	private String type;
	private UUID entityId;
	
	
	
	public UUID getEntityId() {
		return entityId;
	}
	public void setEntityId(UUID entityId) {
		this.entityId = entityId;
	}
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
