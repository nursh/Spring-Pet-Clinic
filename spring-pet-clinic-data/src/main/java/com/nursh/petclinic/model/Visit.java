package com.nursh.petclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

    public Visit() {
    }
}
