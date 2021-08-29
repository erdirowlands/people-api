package com.erdirowlands.peopleapi.repositories;

import com.erdirowlands.peopleapi.entities.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface PeopleRepository extends MongoRepository<Person, String> {

}
