package com.genospace.exercise.inventory.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genospace.exercise.inventory.converter.DrugToDrugName;
import com.genospace.exercise.inventory.converter.EntityToDTOConverter;
import com.genospace.exercise.inventory.converter.MechanismToMechanismName;
import com.genospace.exercise.inventory.converter.SearchResults;
import com.genospace.exercise.inventory.model.Drug;
import com.genospace.exercise.inventory.model.DrugMechanism;
import com.genospace.exercise.inventory.model.DrugName;
import com.genospace.exercise.inventory.model.Mechanism;
import com.genospace.exercise.inventory.model.MechanismName;
import com.genospace.exercise.inventory.model.Type;
import com.genospace.exercise.inventory.model.DTO.DrugDTO;
import com.genospace.exercise.inventory.repository.DrugRepository;
import com.genospace.exercise.inventory.repository.MechanismRepository;
import com.genospace.exercise.inventory.repository.TypeRepository;
import com.genospace.exercise.inventory.service.HelperService;


@Service
public class HelperServiceImpl implements HelperService{
	@Autowired 
	private DrugRepository drugRepo;
	@Autowired 
	private MechanismRepository mechRepo;
	@Autowired 
	private TypeRepository typeRepo;

	@Autowired
	private EntityToDTOConverter entityToDTOConverter;
	
	@Autowired
	private DrugToDrugName converter;
	
	@Autowired
	private MechanismToMechanismName convertMech;
	
	@Autowired
	private SearchResults searchRsults;
	
	@Override
	public Drug saveDrug(Drug drug) {
		return drugRepo.save(drug);
	}

	@Override
	public List<Drug> getDrug(String genericName) {
		 
		return (List<Drug>) drugRepo.findByMainName(genericName);
	}
	
	@Override
	public List<DrugName> getQueriedDrug(String query) {
		 
		List<Drug> drugs = (List<Drug>)drugRepo.findByMainNameStartingWith(query);
		List<DrugName> drugName = new ArrayList<>();
		for(Drug d : drugs){
			drugName.add(converter.convertDrug(d));
		}
		return drugName;
	}
	
	public List<DrugDTO> getDrug() {

		List<Drug> drugs = (List<Drug>) drugRepo.findAll();
		List<DrugDTO> drugsDTO = new ArrayList<>();
		for(Drug d : drugs){
			drugsDTO.add(entityToDTOConverter.convertDrugEntityToDTO(d));
		}
		return drugsDTO;

		//return (List<Drug>) drugRepo.findAll();
		
	}

	@Override
	public Mechanism saveMechanism(Mechanism mechanism) {
		
		return mechRepo.save(mechanism);
	}

	@Override
	public void populateData() {
		drugRepo.deleteAll();
        mechRepo.deleteAll();
		
		Mechanism m = new Mechanism();
		Mechanism m1 = new Mechanism();
		m.setName("Mechname");
		m1.setName("SecondMechName");
		for ( int i =0; i<5; i++)
		{
			Drug d = new Drug();
			
			d.setGenericName("DrugName" + i);
			d.setMainName("MainName"+ i);

			
			d.getMechanisms().add(m);

			m.getDrugs().add(d);
			if(i % 2 == 0) {
				d.getMechanisms().add(m1);
				m1.getDrugs().add(d);
			}
				
			
			drugRepo.save(d);
			
		}
		
	}

	@Override
	public List<Mechanism> getMechanism() {
		return (List<Mechanism>) mechRepo.findAll();
	}

	@Override
	public List<DrugDTO> getDrugWithMechanism(String genericName) {
		
		List<Drug> drugs = (List<Drug>) drugRepo.findByMainName(genericName);
		List<DrugDTO> drugsDTO = new ArrayList<>();
		for(Drug d : drugs){
			drugsDTO.add(entityToDTOConverter.convertDrugEntityToDTO(d));
		}
		return drugsDTO;
		
	}

	@Override
	public List<Mechanism> getMechanism(String name) {
		return (List<Mechanism>) mechRepo.findByName(name);
		
	}

	@Override
	public List<MechanismName> getQueriedMechanism(String name) {
		List<Mechanism> mechanism = (List<Mechanism>) mechRepo.findByName(name);
		List<MechanismName> mech = new ArrayList<>();
		for(Mechanism m : mechanism){
			mech.add(convertMech.convertMechanism(m));
		}
		return mech;
	}
	
	
	public List<DrugMechanism> getSearchRecord(String query)
	{
		List<Mechanism> mechanism = (List<Mechanism>) mechRepo.findByNameStartingWith(query);
		List<Drug> drugs = (List<Drug>) drugRepo.findByMainNameStartingWith(query);
		List<Object> mergedList= new ArrayList<>();
		mergedList.addAll(drugs);
		mergedList.addAll(mechanism);
		List<DrugMechanism> dm = new ArrayList<>();
		for(Object obj:mergedList )
		{
			dm.add(searchRsults.search(obj));
			
			
		}
		
		
		return dm;
	}

}
