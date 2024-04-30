package org.example.dbtransactions.association.repository;

import org.example.dbtransactions.association.entity.Family;
import org.example.dbtransactions.association.interfaces.FamilyInteract;
import org.example.dbtransactions.association.repository.repositories.FamilyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FamilyInteractImpl implements FamilyInteract {

    private final FamilyRepository familyRepository;

    public FamilyInteractImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }


    @Override
    public Family save(Family family) {
        return familyRepository.save(family);
    }

    @Override
    public List<Family> saveFamilies(List<Family> families) {
        return familyRepository.saveAll(families);
    }

    @Override
    public Family findById(Long id) {
        Optional<Family> family = familyRepository.findById(id);
        if(family.isEmpty()) throw new RuntimeException();
        return family.get();
    }
}
