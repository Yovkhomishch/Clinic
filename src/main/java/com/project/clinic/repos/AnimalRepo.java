package com.project.clinic.repos;

import com.project.clinic.domain.Animal;
import com.project.clinic.domain.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface AnimalRepo extends CrudRepository<Animal, Integer> {

List<Animal> findAnimalByOwner(Owner owner);

List<Animal> findAnimalByOwnerId(Long id);
Animal findById(Long id);
}
