package com.genospace.exercise.inventory.service;

import java.util.List;

import com.genospace.exercise.inventory.model.Drug;
import com.genospace.exercise.inventory.model.DrugMechanism;
import com.genospace.exercise.inventory.model.DrugName;
import com.genospace.exercise.inventory.model.Mechanism;
import com.genospace.exercise.inventory.model.MechanismName;
import com.genospace.exercise.inventory.model.DTO.DrugDTO;




public interface HelperService {

	public Drug saveDrug(Drug drug);
	public List<Drug> getDrug(String query);
	public List<DrugDTO> getDrug();
	public List<DrugName> getQueriedDrug(String query);
	public Mechanism saveMechanism(Mechanism mechanism);
	public void populateData();
	public List<Mechanism> getMechanism();
	public List<DrugDTO> getDrugWithMechanism(String genericName);
	public List<Mechanism> getMechanism(String name);
	public List<MechanismName> getQueriedMechanism(String name);
	public List<DrugMechanism> getSearchRecord(String query);

}
