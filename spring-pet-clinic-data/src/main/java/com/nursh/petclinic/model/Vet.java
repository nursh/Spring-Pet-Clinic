package com.nursh.petclinic.model;

import lombok.Data;

import java.util.Set;

@Data
public class Vet extends Person {

    private Set<Speciality> specialities;

    public Vet() {
    }
}
