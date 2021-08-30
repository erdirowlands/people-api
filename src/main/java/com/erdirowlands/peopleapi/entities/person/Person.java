package com.erdirowlands.peopleapi.entities.person;

import com.erdirowlands.peopleapi.models.Manager;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "awesomeCollection")
public class Person {

    @Id
    private String _id;



    private String name;
    private String age;
    private String balance;
    private String email;
    private String address;
    private List<Manager> managers;

    /**
     * Standard constructor to instantiate without ID or managers (managers is a Part 2 task implementation).
     */
    public Person(String name, String age, String balance, String email, String address) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.email = email;
        this.address = address;
    }

    /**
     * A constructor to instantiate with managers - managers is used in Part 2 of the task to demonstrate
     * a new endpoint, and pagination.
     */
    public Person(String name, String age, String balance, String email, String address, List<Manager> managers) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.email = email;
        this.address = address;
        this.managers = managers;
    }

    /**
     * A constructor to instantiate with IDs.
     */
    public Person(String _id, String name, String age, String balance, String email, String address, List<Manager> managers) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.email = email;
        this.address = address;
        this.managers = managers;
    }

    public Person() {

    }
}
