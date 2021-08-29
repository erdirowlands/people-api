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
    public ResponseEntity<List<Person>> getPeople(@RequestParam(required = false) String sortKey) {
        try {
            List<Person> people = new ArrayList<>(peopleService.getPeople(sortKey));
            return new ResponseEntity<>(people, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("app/people")
    public ResponseEntity<List<Person>> createPerson(@RequestBody Person person) {
        Person person = this.peopleService.
    }

}
