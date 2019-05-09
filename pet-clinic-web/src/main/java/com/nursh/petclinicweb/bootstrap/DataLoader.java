package com.nursh.petclinicweb.bootstrap;

import com.nursh.petclinicdata.model.Owner;
import com.nursh.petclinicdata.model.Vet;
import com.nursh.petclinicdata.service.OwnerService;
import com.nursh.petclinicdata.service.VetService;
import com.nursh.petclinicdata.service.maps.OwnerServiceMap;
import com.nursh.petclinicdata.service.maps.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    public final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
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
        ann.setId(2L);
        ann.setFirstName("Paige");
        ann.setLastName("Turner");

        ownerService.save(ann);
        ownerService.save(paige);

        System.out.println("Loaded Owners ------------------");

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

        System.out.println("Loaded Vets ------------------");



    }
}
