package org.example.dbtransactions.association.repository;

import org.example.dbtransactions.association.entity.People;
import org.example.dbtransactions.association.interfaces.PeopleInteract;
import org.example.dbtransactions.association.repository.repositories.PeopleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeopleInteractImpl implements PeopleInteract {

    private final PeopleRepository peopleRepository;

    public PeopleInteractImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public People save(People people) {
        return peopleRepository.save(people);
    }

    @Override
    public List<People> savePeoples(List<People> peoples) {
        return peopleRepository.saveAll(peoples);
    }

    @Override
    public People findById(Long id) {
        Optional<People> people = peopleRepository.findById(id);
        if(people.isEmpty()) throw new RuntimeException();
        return people.get();
    }

    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }
}
