package com.genospace.exercise.inventory.converter;
import org.springframework.stereotype.Service;


import com.genospace.exercise.inventory.model.Mechanism;
import com.genospace.exercise.inventory.model.MechanismName;

@Service
public class MechanismToMechanismName {

	
	 public MechanismName convertMechanism(Mechanism mechanism){
		 
		 MechanismName m  = new MechanismName();

		      
		        m.setName(mechanism.getName());
		     
		      

		        return m;
		    }
}
