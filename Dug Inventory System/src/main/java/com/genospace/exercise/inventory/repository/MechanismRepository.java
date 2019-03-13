package com.genospace.exercise.inventory.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.genospace.exercise.inventory.model.Mechanism;

public interface MechanismRepository extends CrudRepository<Mechanism, UUID> {

	List<Mechanism> findByName(String name);

	List<Mechanism> findByNameStartingWith(String query);

}
