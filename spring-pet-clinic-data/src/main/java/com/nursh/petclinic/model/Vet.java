package com.nursh.petclinic.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Vet() {
    }
}
