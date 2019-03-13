package com.genospace.exercise.inventory.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.genospace.exercise.inventory.model.Drug;



public interface DrugRepository extends CrudRepository<Drug, UUID> {
	public List<Drug> findByMainName(String genericName);

	public List<Drug> findByMainNameStartingWith(String query);


}
