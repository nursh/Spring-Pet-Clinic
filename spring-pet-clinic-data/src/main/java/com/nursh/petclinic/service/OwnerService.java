package com.nursh.petclinic.service;

import com.nursh.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastname(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
