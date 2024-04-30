package org.example.dbtransactions.association.interfaces;

import org.example.dbtransactions.association.entity.People;

import java.util.List;

public interface PeopleInteract {

    People save(People people);

    List<People> savePeoples(List<People> peoples);

    People findById(Long id);

    List<People> findAll();

}
