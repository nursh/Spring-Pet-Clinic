package com.nursh.petclinic.bootstrap;

import com.nursh.petclinic.model.*;
import com.nursh.petclinic.service.OwnerService;
import com.nursh.petclinic.service.PetTypeService;
import com.nursh.petclinic.service.SpecialtyService;
import com.nursh.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        /******************
         *
         * PetTypes
         ******************/
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        /******************
         *
         * Specialties
         ******************/
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        /******************
         *
         * Owners
         ******************/
        Owner ann = new Owner();
        ann.setId(1L);
        ann.setFirstName("Anna");
        ann.setLastName("Mull");
        ann.setAddress("384 Besserer Street");
        ann.setCity("Ottawa");
        ann.setTelephone("(932)-282-0871");

        Pet annPet = new Pet();
        annPet.setPetType(savedDogPetType);
        annPet.setOwner(ann);
        annPet.setBirthDate(LocalDate.now());
        annPet.setName("Bingo");
        ann.getPets().add(annPet);
        ownerService.save(ann);

        Owner paige = new Owner();
        paige.setId(2L);
        paige.setFirstName("Paige");
        paige.setLastName("Turner");
        paige.setAddress("298 Hangon Street");
        paige.setCity("Toronto");
        paige.setTelephone("(892)-982-2897");

        Pet paigePet = new Pet();
        paigePet.setPetType(savedCatPetType);
        paigePet.setOwner(paige);
        paigePet.setBirthDate(LocalDate.now());
        paigePet.setName("Ursula");
        paige.getPets().add(paigePet);
        ownerService.save(paige);

        System.out.println("Loaded Owners...");

        /*****************
         *
         * Vets
         *****************/

        Vet pete = new Vet();
        pete.setId(1L);
        pete.setFirstName("Pete");
        pete.setLastName("Cruiser");
        pete.getSpecialities().add(savedRadiology);

        Vet bob = new Vet();
        bob.setId(2L);
        bob.setFirstName("Bob");
        bob.setLastName("Frapples");
        bob.getSpecialities().add(savedSurgery);

        vetService.save(pete);
        vetService.save(bob);
        System.out.println("Loaded Vets...");
    }
}
