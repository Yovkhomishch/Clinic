package com.project.clinic.controller;

import com.project.clinic.domain.Role;
import com.project.clinic.domain.Worker;
import com.project.clinic.repos.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class RegistrationController {
    @Autowired
    private WorkerRepo workerRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addWorker(Worker worker, Map<String, Object> model){

        Worker dBWorker = workerRepo.findByLogin(worker.getLogin());

        if(dBWorker != null){
            model.put("message", "Worker Exists!");
            return "registration";
        }else {

            worker.setRoles(Collections.singleton(Role.USER));
            workerRepo.save(worker);
            return "redirect:/login";
        }
    }
}
