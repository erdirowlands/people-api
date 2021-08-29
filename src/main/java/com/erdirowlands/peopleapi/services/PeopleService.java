package com.erdirowlands.peopleapi.services;

import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * Sorts a list of people alphabetically by name or email
     *
     * @param peopleToSort list to sort.
     * @param sortKey      the key to sort by.
     * @return to avoid mutation of args by the comparing function, returns a new list.
     * @throws Exception if the correct sort key is not specified.
     */
    public List<Person> sortByName(List<Person> peopleToSort, String sortKey) throws Exception {
        List<Person> people = new ArrayList<>(peopleToSort);
        if (sortKey.equals("name")) {
            people.sort(Comparator.comparing(Person::getName));
            return people;
        } else if (sortKey.equals("email")) {
            people.sort(Comparator.comparing(Person::getEmail));
            return people;
        }
        throw new Exception("Sort key provided was not 'name' or 'email");
    }


}
