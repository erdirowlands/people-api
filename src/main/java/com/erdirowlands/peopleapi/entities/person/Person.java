package com.erdirowlands.peopleapi.entities.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "people")
public class Person{

    private String name;
    private String age;
    private String balance;
    private String email;
    private String address;


}
