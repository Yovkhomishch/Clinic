package com.project.clinic.repos;

import com.project.clinic.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
    Worker findByLogin(String login);

    Worker findById(Integer id);
}
