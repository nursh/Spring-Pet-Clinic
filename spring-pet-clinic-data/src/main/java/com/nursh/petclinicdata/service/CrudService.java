package com.nursh.petclinicdata.service;

import java.util.Set;

public interface CrudService<T, ID> {

    T findbyId(ID id);
    Set<T> findAll();
    T save(T object);
    void delete(T object);
    void deletebyId(ID id);
}
