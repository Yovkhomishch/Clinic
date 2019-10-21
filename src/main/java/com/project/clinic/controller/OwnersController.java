package com.project.clinic.controller;

import com.project.clinic.domain.Animal;
import com.project.clinic.domain.Owner;
import com.project.clinic.repos.AnimalRepo;
import com.project.clinic.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class OwnersController {

    @Autowired
    private OwnerRepo ownerRepo;
    @Autowired
    private AnimalRepo animalRepo;


    @GetMapping("/owner_animal/{owner}")
    public String ownerAnimals(@PathVariable Integer owner, Model model) {

        Owner owner1 = ownerRepo.findById(owner);
        Set<Animal> animals = owner1.getAnimals();

        model.addAttribute("owner", owner);
        model.addAttribute("animals", animals);
        model.addAttribute("owner1", owner1);

        return "ownerAnimal";


    }

    @PostMapping("/owner_animal/{owner}")
    public String addOwnerAnimals(@PathVariable Integer owner, @RequestParam String name, @RequestParam Integer age,
                                  @RequestParam String spicies, Model model) {


        Owner owner1 = ownerRepo.findById(owner);

            Animal animal = new Animal();
            animal.setOwner(owner1);
            animal.setName(name);
            animal.setAge(age);
            animal.setSpicies(spicies);
            animal.setOwner(owner1);
            animalRepo.save(animal);



            Set<Animal> animals = owner1.getAnimals();


            model.addAttribute("animals", animals);
            model.addAttribute("animal", animal);
            model.addAttribute("owner", owner);





        return "ownerAnimal";
    }

    @GetMapping("/owner_animal/delete/{animal}")
    public String animDel(@PathVariable Long animal, Model model) {

        Animal animal1 = animalRepo.findById(animal);
        Owner owner1 = animal1.getOwner();
        animalRepo.delete(animal1);
        Integer owner = owner1.getId();



        Set<Animal> animals = owner1.getAnimals();
        model.addAttribute("animal1", animal1);
        model.addAttribute("animals", animals);
        model.addAttribute("owner", owner);

        return "ownerAnimal";

    }
//    @PostMapping("/owner_animal/update/{animal}")
//    public String updateAnimal(@PathVariable Long animal, @RequestParam String name, @RequestParam Integer age,
//                               @RequestParam String spicies, Model model ){
//        Animal animal1 = animalRepo.findById(animal);
//
//        if(name != null && !name.isEmpty()){
//            animal1.setName(name);
//        }
//        if(spicies != null && !spicies.isEmpty()){
//            animal1.setSpicies(spicies);
//        }if(age != null){
//            animal1.setAge(age);
//
//        }
//        animalRepo.save(animal1);
//        model.addAttribute("animal", animal);
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//        model.addAttribute("spicies", spicies);
//        return "ownerAnimal";
//
//
//    }

}
