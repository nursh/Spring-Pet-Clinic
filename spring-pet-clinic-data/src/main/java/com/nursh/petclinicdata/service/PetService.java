package com.nursh.petclinicdata.service;

import com.nursh.petclinicdata.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Set<Pet> findAll();
    Pet save(Pet pet);
}
