package com.genospace.exercise.inventory.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.genospace.exercise.inventory.model.Drug;
import com.genospace.exercise.inventory.model.DrugMechanism;
import com.genospace.exercise.inventory.model.DrugName;
import com.genospace.exercise.inventory.model.Mechanism;
import com.genospace.exercise.inventory.model.MechanismName;
import com.genospace.exercise.inventory.model.DTO.DrugDTO;
import com.genospace.exercise.inventory.service.HelperService;


@RestController
public class EntryController {
	//**********Test data endpoints************
	@Autowired
	private HelperService helper;
	//populate drug and mechanism data
		//@ResponseStatus(HttpStatus.OK)
		@RequestMapping(method = RequestMethod.POST, value = "populatedata")
		public void  populateData() {
			helper.populateData();
		}
	//get all drugs
	@RequestMapping(value = "/drugs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DrugDTO>> getDrug()
	{
		
//		List<Drug> drugs = drugService.getDrug();
//
//		for(Drug d : drugs) {
//			System.out.println(d.getGenericName());
//		}
		return new ResponseEntity<List<DrugDTO>>(helper.getDrug(), HttpStatus.OK);
	}
	
	//get all mechanisms
	@RequestMapping(value = "/mechanisms", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mechanism>> getMechanism()
	{
		
//		List<Mechanism> mech = helper.getMechanism();
//		
//		for(Mechanism d : mech) {
//			System.out.println(d.getName());
//		}
		return new ResponseEntity<List<Mechanism>>(helper.getMechanism(), HttpStatus.OK);
	}
	
	//************Full record endpoints below***************
	
	//get full drug record on enetering main name
	@RequestMapping(method = RequestMethod.GET, value = "drugRecord", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DrugDTO>> getDrugWithMechanism(@RequestParam("searchQuery") String mainName) {
		
		return new ResponseEntity<List<DrugDTO>>(helper.getDrugWithMechanism(mainName), HttpStatus.OK);//send out a JSON
		
	}

	
	
	//search a mechanism based on name with collection of drugs associated
	@RequestMapping(method = RequestMethod.GET, value = "mechanism", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mechanism>> getMechanism(@RequestParam("search") String name) {
		
		return new ResponseEntity<List<Mechanism>>(helper.getMechanism(name), HttpStatus.OK);//send out a JSON
		
	}
	

	
	
	//*****************seach endpoint sbelow*********************
	
	// get drug based on input characters of name
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DrugName>> getQueriedDrug(@RequestParam("query") String query) {
		
		return new ResponseEntity<List<DrugName>>(helper.getQueriedDrug(query), HttpStatus.OK);//send out a JSON
		
	}
	
	
	//get mechanism based on  name
	@RequestMapping(method = RequestMethod.GET, value="mechsearch", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MechanismName>> getQueriedMechanism(@RequestParam("mech") String query) {
		
		return new ResponseEntity<List<MechanismName>>(helper.getQueriedMechanism(query), HttpStatus.OK);//send out a JSON
		
	}
	
	//get drugs and mechanisms together in search 
	
	@RequestMapping(method = RequestMethod.GET, value="search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DrugMechanism>> getSearchRecord(@RequestParam("searchString") String query) {
		
		return new ResponseEntity<List<DrugMechanism>>(helper.getSearchRecord(query), HttpStatus.OK);//send out a JSON
		
	}
	
	
}
