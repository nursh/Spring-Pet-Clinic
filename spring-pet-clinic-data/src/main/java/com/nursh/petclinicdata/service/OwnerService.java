package com.nursh.petclinicdata.service;

import com.nursh.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastname(String lastName);

}
