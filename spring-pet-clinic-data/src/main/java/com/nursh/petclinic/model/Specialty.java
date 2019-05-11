package com.nursh.petclinic.model;

import lombok.Data;

@Data
public class Specialty extends BaseEntity {

    private String description;

    public Specialty() {
    }
}
