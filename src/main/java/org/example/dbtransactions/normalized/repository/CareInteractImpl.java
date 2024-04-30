package org.example.dbtransactions.normalized.repository;

import org.example.dbtransactions.normalized.entity.Care;
import org.example.dbtransactions.normalized.interfaces.CareInteract;
import org.example.dbtransactions.normalized.repository.repositories.CareRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CareInteractImpl implements CareInteract {

    private final CareRepository careRepository;

    public CareInteractImpl(CareRepository careRepository) {
        this.careRepository = careRepository;
    }

    @Override
    public List<Care> saveCares(List<Care> cares) {
        return careRepository.saveAll(cares);
    }

    @Override
    public Care save(Care care) {
        return careRepository.save(care);
    }
}
