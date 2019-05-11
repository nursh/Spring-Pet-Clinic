package com.nursh.petclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends BaseEntity {

    private Owner owner;
    private String name;
    private LocalDate birthDate;
    private PetType petType;

    public Pet() {
    }

}
