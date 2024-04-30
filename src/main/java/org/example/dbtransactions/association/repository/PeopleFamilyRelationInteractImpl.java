package org.example.dbtransactions.association.repository;

import org.example.dbtransactions.association.entity.PeopleFamilyRelation;
import org.example.dbtransactions.association.interfaces.PeopleFamilyRelationInteract;
import org.example.dbtransactions.association.repository.repositories.PeopleFamilyRelationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleFamilyRelationInteractImpl implements PeopleFamilyRelationInteract {

    private final PeopleFamilyRelationRepository peopleFamilyRelationRepository;

    public PeopleFamilyRelationInteractImpl(PeopleFamilyRelationRepository peopleFamilyRelationRepository) {
        this.peopleFamilyRelationRepository = peopleFamilyRelationRepository;
    }

    @Override
    public PeopleFamilyRelation save(PeopleFamilyRelation peopleFamilyRelation) {
        return peopleFamilyRelationRepository.save(peopleFamilyRelation);
    }

    @Override
    public List<PeopleFamilyRelation> savePeopleFamilyRelations(List<PeopleFamilyRelation> peopleFamilyRelations) {
        return peopleFamilyRelationRepository.saveAll(peopleFamilyRelations);
    }
}
