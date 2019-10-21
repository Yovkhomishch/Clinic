package com.project.clinic.repos;

import com.project.clinic.domain.MedicalCard;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface MedCardRepo extends CrudRepository<MedicalCard,Long> {
    MedicalCard findByDate(Date date);

}
