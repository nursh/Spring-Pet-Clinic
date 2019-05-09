package com.nursh.petclinic.model;

import lombok.Data;

@Data
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
