package com.genospace.exercise.inventory.converter;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.genospace.exercise.inventory.model.Drug;
import com.genospace.exercise.inventory.model.DrugMechanism;
import com.genospace.exercise.inventory.model.Mechanism;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@Service
public class SearchResults {

	
	
 public DrugMechanism search(Object obj){
	 DrugMechanism dm = new DrugMechanism();
	 if(obj instanceof Mechanism)
	 {
		 Mechanism m = (Mechanism) obj;
		 dm.setName(m.getName());
		 dm.setId(m.getId());
		 dm.setType("Mechanism");
	 }
	 if(obj instanceof Drug)
	 {
		 Drug d = (Drug)obj;
		 dm.setMainName(d.getMainName());
		 dm.setId(d.getId());
		 dm.setType("Drug");
	 }
		
	 return dm;
		    }
}
