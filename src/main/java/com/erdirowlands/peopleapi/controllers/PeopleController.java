package com.erdirowlands.peopleapi.controllers;

import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.repositories.PeopleRepository;
import com.erdirowlands.peopleapi.services.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PeopleController {

    private final PeopleRepository peopleRepository;
    private final PeopleService peopleService;

    public PeopleController(PeopleRepository peopleRepository, PeopleService peopleService) {
        this.peopleRepository = peopleRepository;
        this.peopleService = peopleService;
    }

    @GetMapping("app/people")
    public ResponseEntity<List<Person>> getPeople(@RequestParam(required = false) String sortKey) throws Exception {
        try {
            List<Person> people = this.peopleRepository.findAll();
            if (sortKey != null) {
                people = this.peopleService.sortByNameOrEmail(people, sortKey);
            }
            return new ResponseEntity<>(people, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @PostMapping("app/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) throws Exception {
        try {
            Person newPerson = peopleRepository.save(new Person(person.getName(), person.getAge(), person.getBalance(),
                    person.getEmail(), person.getAddress()));
            return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
