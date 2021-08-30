package com.erdirowlands.peopleapi.entities.manager;

import com.erdirowlands.peopleapi.entities.person.Person;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "awesomeCollection")
public class Manager {

    @Id
    private String _id;
    private String name;
    private String age;
    private List<Person> employees;
    private String email;
    private String address;

    public Manager(String name, String age, List<Person> employees, String email, String address) {
        this.name = name;
        this.age = age;
        this.employees = employees;
        this.email = email;
        this.address = address;
    }


}
