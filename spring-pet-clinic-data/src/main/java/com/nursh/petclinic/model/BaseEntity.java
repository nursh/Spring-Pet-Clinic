package com.nursh.petclinic.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    private Long id;

    public BaseEntity() {
    }
}
