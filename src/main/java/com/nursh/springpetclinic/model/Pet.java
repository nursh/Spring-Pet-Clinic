package com.nursh.springpetclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet {

    private Owner owner;
    private LocalDate birthDate;
    private PetType petType;

    public Pet() {
    }

    public Pet(Owner owner, LocalDate birthDate, PetType petType) {
        this.owner = owner;
        this.birthDate = birthDate;
        this.petType = petType;
    }
}
