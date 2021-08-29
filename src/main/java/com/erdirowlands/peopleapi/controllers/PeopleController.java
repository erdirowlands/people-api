package com.erdirowlands.peopleapi.controllers;

import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.services.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public List<Person> getPeople(@RequestParam(required = false) String sortKey) {
        return new ArrayList<>(peopleService.getPeople(sortKey));
    }

    @PostMapping("/people")
    public List<Person> addPerson(@RequestParam(required = false) String sortKey) {
        return new ArrayList<>(peopleService.getPeople(sortKey));
    }

}
