package com.erdirowlands.peopleapi.services;

import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository pepeopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.pepeopleRepository = peopleRepository;
    }

    public List<Person> getPeople(String sortKey) {
        List<Person> people = this.pepeopleRepository.findAll();
        if (sortKey != null) {
            this.sortByName(people, sortKey);
        }
        return people;
    }

    private void sortByName(List<Person> people, String sortKey) {
        if (sortKey.equals("name")) {
            people.sort(Comparator.comparing(Person::getName));
        } else if (sortKey.equals("email")) {
            people.sort(Comparator.comparing(Person::getEmail));
        }
    }


}
