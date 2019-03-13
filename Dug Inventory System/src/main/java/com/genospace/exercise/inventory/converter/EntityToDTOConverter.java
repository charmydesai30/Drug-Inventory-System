package com.genospace.exercise.inventory.converter;


import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.genospace.exercise.inventory.model.Drug;
import com.genospace.exercise.inventory.model.Mechanism;
import com.genospace.exercise.inventory.model.DTO.DrugDTO;
@JsonInclude(Include.NON_NULL)
@Service
public class EntityToDTOConverter {

    public DrugDTO convertDrugEntityToDTO(Drug drug){
		 
        DrugDTO d = new DrugDTO();

        d.setGenericName(drug.getGenericName());
        d.setId(drug.getId());
        d.setMainName(drug.getMainName());
        //Setting Mechanisms
        for(Mechanism m : drug.getMechanisms()){
            //Setting everything except the drug
            Mechanism mech = new Mechanism();
            mech.setId(m.getId());
            mech.setName(m.getName());
            //Setting this to null to avoid circular reference
            mech.setDrugs(null);
            d.getMechanisms().add(mech);
        }

        return d;
    }

}
