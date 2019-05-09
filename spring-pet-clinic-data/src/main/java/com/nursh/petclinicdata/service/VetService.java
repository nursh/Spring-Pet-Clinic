package com.nursh.petclinicdata.service;

import com.nursh.petclinicdata.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Set<Vet> findAll();
    Vet save(Vet vet);
}
