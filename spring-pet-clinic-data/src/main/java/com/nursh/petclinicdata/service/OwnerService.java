package com.nursh.petclinicdata.service;

import com.nursh.petclinicdata.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findbyLastname(String lastName);
    Owner findById(Long id);
    Set<Owner> findAll();
    Owner save(Owner owner);
}
