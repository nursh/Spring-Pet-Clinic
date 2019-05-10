package com.nursh.petclinic.bootstrap;

import com.nursh.petclinic.model.Owner;
import com.nursh.petclinic.model.Vet;
import com.nursh.petclinic.service.OwnerService;
import com.nursh.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        /******************
         *
         * Owners
         ******************/
        Owner ann = new Owner();
        ann.setId(1L);
        ann.setFirstName("Anna");
        ann.setLastName("Mull");


        Owner paige = new Owner();
        paige.setId(2L);
        paige.setFirstName("Paige");
        paige.setLastName("Turner");

        ownerService.save(ann);
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

        Vet bob = new Vet();
        bob.setId(2L);
        bob.setFirstName("Bob");
        bob.setLastName("Frapples");

        vetService.save(pete);
        vetService.save(bob);
        System.out.println("Loaded Vets...");

    }
}
