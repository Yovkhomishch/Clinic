package com.project.clinic.repos;


import com.project.clinic.domain.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepo extends CrudRepository<Owner, Long> {

    List<Owner> findByMobilePhone(String mobilePhone);
    Owner findById(Integer id);



}
