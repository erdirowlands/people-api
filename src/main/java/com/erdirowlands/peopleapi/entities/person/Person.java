package com.erdirowlands.peopleapi.entities.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private String age;
    private String balance;
    private String email;
    private String address;
}
