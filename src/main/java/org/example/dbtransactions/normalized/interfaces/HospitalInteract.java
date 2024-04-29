package org.example.dbtransactions.normalized.interfaces;

import org.example.dbtransactions.normalized.entity.Hospital;

import java.util.List;

public interface HospitalInteract {

    List<Hospital> saveHospitals(List<Hospital> hospitals);

    Hospital save(Hospital hospital);
}
