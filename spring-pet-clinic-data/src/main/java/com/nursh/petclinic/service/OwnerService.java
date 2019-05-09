package com.nursh.petclinic.service;

import com.nursh.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastname(String lastName);

}
