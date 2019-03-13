package com.genospace.exercise.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



public class DrugName {


	private String mainName;

	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
}
