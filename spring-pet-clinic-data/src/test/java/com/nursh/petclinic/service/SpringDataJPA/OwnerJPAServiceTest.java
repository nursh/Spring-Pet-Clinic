package com.nursh.petclinic.service.SpringDataJPA;

import com.nursh.petclinic.model.Owner;
import com.nursh.petclinic.repositories.OwnerRepository;
import com.nursh.petclinic.repositories.PetRepository;
import com.nursh.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerJPAService ownerJPAService;

    Owner owner;
    static final String LAST_NAME = "Jigen";

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastname() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner jigen = ownerJPAService.findByLastname(LAST_NAME);
        assertEquals(LAST_NAME, jigen.getLastName());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner owner = ownerJPAService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerJPAService.findById(1L);
        assertNull(owner);
    }


    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet();
        ownerSet.add(Owner.builder().id(7L).build());


        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners = ownerJPAService.findAll();
        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerJPAService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJPAService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}