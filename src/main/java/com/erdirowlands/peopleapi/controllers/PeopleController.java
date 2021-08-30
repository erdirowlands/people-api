package com.erdirowlands.peopleapi.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.erdirowlands.peopleapi.entities.person.Person;
import com.erdirowlands.peopleapi.repositories.PeopleRepository;
import com.erdirowlands.peopleapi.services.PeopleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * A CRUD Web API for People.
 * Response Entity exception handling is provided by a ControllerAdvice class in the utils package,
 * which will return any exceptions as JSON to the client.
 */
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
                    person.getEmail(), person.getAddress(), person.getManagers()));
            return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("app/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") String id, @RequestBody Person person)
            throws Exception {
        try {
            Optional<Person> personData = peopleRepository.findById(id);
            if (personData.isPresent()) {
                Person existingPerson = personData.get();
                Person updatedPerson = new Person(person.getName(), person.getAge(), person.getBalance(),
                        person.getEmail(), person.getAddress(), person.getManagers());
                updatedPerson.set_id(existingPerson.get_id());
                return new ResponseEntity<>(peopleRepository.save(updatedPerson), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("app/people/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") String id) throws Exception {
        try {
            peopleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * An example of pagination using an unrealistic endpoint: Will return Employees who have no managers. At time of submission,
     * only two employees have managers, just to demonstrate working pagination with a larger result set.
     * @param page the page number to be returned
     * @param size the size of results per page
     * @return Paginated results of managers with no employees
     */
    @GetMapping("app/people/no-managers")
    public ResponseEntity<Map<String, Object>> findManagersWithNoEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size) throws Exception {

        try {
            Pageable paging = PageRequest.of(page, size);
            Page<Person> peoplePage = this.peopleRepository.findPeopleByManagersIsNull(paging);
            List<Person> people = peoplePage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("people", people);
            response.put("currentPage", peoplePage.getNumber());
            response.put("totalItems", peoplePage.getTotalElements());
            response.put("totalPages", peoplePage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
