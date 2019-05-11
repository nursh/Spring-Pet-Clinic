package com.nursh.petclinic.model;

import lombok.Data;

@Data
public class Speciality extends BaseEntity {

    private String description;

    public Speciality() {
    }
}
