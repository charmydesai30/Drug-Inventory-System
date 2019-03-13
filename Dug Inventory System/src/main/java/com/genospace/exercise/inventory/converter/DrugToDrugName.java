package com.genospace.exercise.inventory.converter;

import org.springframework.stereotype.Service;

import com.genospace.exercise.inventory.model.Drug;
import com.genospace.exercise.inventory.model.DrugName;


@Service
public class DrugToDrugName {


	
	  public DrugName convertDrug(Drug drug){
			 
		DrugName d = new DrugName();

	      
	        d.setMainName(drug.getMainName());
	     
	      

	        return d;
	    }

}
