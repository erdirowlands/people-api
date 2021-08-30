package com.erdirowlands.peopleapi.repositories;

import com.erdirowlands.peopleapi.entities.manager.Manager;
import com.erdirowlands.peopleapi.entities.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ManagerRepository extends MongoRepository<Manager, String> {
    Page<Manager> findManagerByEmployeesIsNull(Pageable pageable);

}
