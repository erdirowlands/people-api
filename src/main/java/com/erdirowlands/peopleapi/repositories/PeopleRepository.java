package com.erdirowlands.peopleapi.repositories;

import com.erdirowlands.peopleapi.entities.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "people")
public interface PeopleRepository extends MongoRepository<Person, String> {

    List<Person> getAll();


}
