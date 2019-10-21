package com.project.clinic.service;

import com.project.clinic.repos.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WorkerService implements UserDetailsService {

    @Autowired
    private WorkerRepo workerRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return workerRepo.findByLogin(s);
    }
}
