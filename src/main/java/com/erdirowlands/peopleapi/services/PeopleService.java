package com.erdirowlands.peopleapi.services;

import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepository pepeopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.pepeopleRepository = peopleRepository;
    }


    /**
     * Sorts a list of people alphabetically by name or email.
     * Deep copies the array and returns a new, sorted array to avoid
     * argument mutation.
     *
     * @param peopleToSort list to sort.
     * @param sortKey the key to sort by.
     * @return a new sorted list.
     * @throws Exception if the correct sort key is not specified.
     */
    public List<Person> sortByNameOrEmail(List<Person> peopleToSort, String sortKey) throws Exception {
        List<Person> peopleClone = new ArrayList<>();
        Iterator<Person> iterator = peopleToSort.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            Person newPerson = new Person(person.get_id(), person.getName(), person.getAge(), person.getBalance(),
                    person.getEmail(), person.getAddress(), person.getManagers());
            peopleClone.add(newPerson);
        }
        if (sortKey.equals("name")) {
            peopleClone.sort(Comparator.comparing(Person::getName));
            return peopleClone;
        } else if (sortKey.equals("email")) {
            peopleClone.sort(Comparator.comparing(Person::getEmail));
            return peopleClone;
        }
        throw new Exception("Sort key provided was not 'name' or 'email");
    }


}
