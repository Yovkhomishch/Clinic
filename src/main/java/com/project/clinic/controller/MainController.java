package com.project.clinic.controller;

import com.project.clinic.domain.Owner;
import com.project.clinic.domain.Worker;
import com.project.clinic.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MainController {


    @Autowired
    private OwnerRepo ownerRepo;

    @GetMapping("/")
    public String greeting(Model model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Owner> owners = ownerRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            owners = ownerRepo.findByMobilePhone(filter);



        } else {
            owners = ownerRepo.findAll();


        }

        model.addAttribute("owners", owners);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal Worker worker,
                      @RequestParam String ownerName, @RequestParam String ownerSurname,
                      @RequestParam String ownerPhone, Model model) {
        Owner owner = new Owner(ownerName, ownerSurname, ownerPhone);

        ownerRepo.save(owner);


        Iterable<Owner> owners = ownerRepo.findAll();
        model.addAttribute("owners", owners);

        return "main";
    }


}
