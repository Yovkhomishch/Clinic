package com.project.clinic.controller;

import com.project.clinic.domain.Animal;
import com.project.clinic.domain.MedicalCard;
import com.project.clinic.domain.Worker;
import com.project.clinic.repos.AnimalRepo;
import com.project.clinic.repos.MedCardRepo;
import com.project.clinic.repos.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Set;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class AnimalController {


    @Autowired
    private WorkerRepo workerRepo;
    @Autowired
    private AnimalRepo animalRepo;
    @Autowired
    private MedCardRepo medCardRepo;


    @GetMapping("/animal_history/{animal}")
    public String animalReports(@AuthenticationPrincipal Worker worker,@PathVariable Long animal,  Model model) {

        Animal animal1 = animalRepo.findById(animal);
       // Worker worker1 = workerRepo.findById(worker.getId());
        Set<MedicalCard> medicalCards = animal1.getMedicalCards();

        model.addAttribute("animal", animal);
        model.addAttribute("worker", worker);
        model.addAttribute("medicalCards", medicalCards);

        return "animalReports";


    }

    @PostMapping("/animal_history/{animal}")
    public String addAnimalReport(@AuthenticationPrincipal Worker worker,@PathVariable Long animal,  @RequestParam String diagnosis,
                                  @RequestParam String anamnesis, @RequestParam String treatment, @RequestParam float temperature,
                                  Model model) {


        MedicalCard medicalCard = new MedicalCard(diagnosis, anamnesis, treatment, temperature, new Date(), workerRepo.
                findById(worker.getId()), animalRepo.findById(animal));
        medCardRepo.save(medicalCard);

        Set<MedicalCard> medicalCards = animalRepo.findById(animal).getMedicalCards();
        model.addAttribute("animal", animal);
        model.addAttribute("worker", worker);
        model.addAttribute("medicalCard", medicalCard);
        model.addAttribute("medicalCards", medicalCards);


        return "animalReports";
    }

}
