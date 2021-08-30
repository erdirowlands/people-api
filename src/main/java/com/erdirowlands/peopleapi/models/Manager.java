package com.erdirowlands.peopleapi.models;

import lombok.Data;

@Data
public class Manager {


    private String name;
    private String age;
    private String email;
    private String address;

    public Manager(String name, String age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }


}
