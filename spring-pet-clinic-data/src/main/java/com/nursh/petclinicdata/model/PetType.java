package com.nursh.petclinicdata.model;

import lombok.Data;

@Data
public class PetType extends BaseEntity {

    private String name;

    public PetType() {
    }

}
