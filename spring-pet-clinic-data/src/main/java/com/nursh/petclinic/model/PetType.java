package com.nursh.petclinic.model;

import lombok.Data;

@Data
public class PetType extends BaseEntity {

    private String name;

    public PetType() {
    }

}
