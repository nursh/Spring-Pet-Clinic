package com.nursh.springpetclinic.model;

import lombok.Data;

@Data
public class PetType {

    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }
}
