package com.erdirowlands.peopleapi.controllers;

import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.services.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public List<Person> getPeople(@RequestParam(required = false) String sortKey) {
        List<Person> people = peopleService.getPeople(sortKey);
        people.sort(Comparator.comparing(Person::getName));
        return people;
    }

}
