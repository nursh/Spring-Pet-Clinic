package com.nursh.petclinic.service.SpringDataJPA;

import com.nursh.petclinic.model.Owner;
import com.nursh.petclinic.repositories.OwnerRepository;
import com.nursh.petclinic.repositories.PetRepository;
import com.nursh.petclinic.repositories.PetTypeRepository;
import com.nursh.petclinic.service.OwnerService;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Transactional
public class OwnerJPAService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public OwnerJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }




    @Override
    public Owner findByLastname(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        List <Owner> owners = ownerRepository.findAllByLastNameLike(lastName);
        owners.forEach(owner -> Hibernate.initialize(owner.getPets()));
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        Hibernate.initialize(optionalOwner.get().getPets());
        optionalOwner.get().getPets().forEach(pet -> Hibernate.initialize(pet.getVisits()));
        return optionalOwner.orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach((owners::add));
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
