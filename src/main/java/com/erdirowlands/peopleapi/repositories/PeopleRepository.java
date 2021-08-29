package com.erdirowlands.peopleapi.repositories;

import com.erdirowlands.peopleapi.entities.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PeopleRepository extends MongoRepository<Person, String> {

}
