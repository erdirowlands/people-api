package com.erdirowlands.peopleapi.entities.person;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "people")
public class Person {

    @Id
    private String _id;
    private String name;
    private String age;
    private String balance;
    private String email;
    private String address;

    public Person(String name, String age, String balance, String email, String address) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.email = email;
        this.address = address;
    }

}
