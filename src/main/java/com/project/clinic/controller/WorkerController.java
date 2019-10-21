package com.project.clinic.controller;


import com.project.clinic.domain.Role;
import com.project.clinic.domain.Worker;
import com.project.clinic.repos.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerRepo workerRepo;

    @GetMapping
    public String workerList(Model model) {
        model.addAttribute("workers", workerRepo.findAll());

        return "workerList";
    }

    @GetMapping("{worker}")
    public String workerEditForm(@PathVariable Integer worker, Model model) {

        model.addAttribute("worker", workerRepo.findById(worker));
        model.addAttribute("roles", Role.values());
        return "workerEdit";
    }

    @PostMapping("{worker}")
    public String workerSave(@PathVariable Integer worker, @RequestParam String login,
                             @RequestParam Map<String, String> form) {

        Worker worker1 = workerRepo.findById(worker);
        if (login != null && !login.isEmpty()) {
            worker1.setLogin(login);
        }

        worker1.getRoles().clear();
        Set<String> workerRoles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for (String key : form.keySet()) {
            if (workerRoles.contains(key)) {
                worker1.getRoles().add(Role.valueOf(key));
            }
        }
        workerRepo.save(worker1);


        return "redirect:/worker";
    }
}
