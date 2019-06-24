package com.nursh.petclinic.service.SpringDataJPA;

import com.nursh.petclinic.model.Pet;
import com.nursh.petclinic.repositories.PetRepository;
import com.nursh.petclinic.service.PetService;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Transactional
public class PetJPAService implements PetService {

    private final PetRepository petRepository;

    public PetJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        Hibernate.initialize(optionalPet.get().getVisits());
        return optionalPet.orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
