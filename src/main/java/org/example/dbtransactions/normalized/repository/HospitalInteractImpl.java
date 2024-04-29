package org.example.dbtransactions.normalized.repository;

import org.example.dbtransactions.normalized.entity.Hospital;
import org.example.dbtransactions.normalized.interfaces.HospitalInteract;
import org.example.dbtransactions.normalized.repository.repositories.HospitalRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalInteractImpl implements HospitalInteract {

    private final HospitalRepository hospitalRepository;

    public HospitalInteractImpl(
        HospitalRepository hospitalRepository
    ) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Hospital> saveHospitals(List<Hospital> hospitals) {
        return hospitalRepository.saveAll(hospitals);
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }
}
