package com.genospace.exercise.inventory.repository;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;
import com.genospace.exercise.inventory.model.Type;
public interface TypeRepository extends CrudRepository<Type,UUID>{

}
