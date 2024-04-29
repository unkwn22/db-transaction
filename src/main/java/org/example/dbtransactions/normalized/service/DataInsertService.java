package org.example.dbtransactions.normalized.service;

import jakarta.annotation.PostConstruct;
import org.example.dbtransactions.normalized.entity.Care;
import org.example.dbtransactions.normalized.entity.Country;
import org.example.dbtransactions.normalized.entity.Hospital;
import org.example.dbtransactions.normalized.entity.SubjectTreatment;
import org.example.dbtransactions.normalized.interfaces.CareInteract;
import org.example.dbtransactions.normalized.interfaces.CountryInteract;
import org.example.dbtransactions.normalized.interfaces.HospitalInteract;
import org.example.dbtransactions.normalized.interfaces.SubjectTreatmentInteract;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class DataInsertService {

    private final CareInteract careInteract;
    private final CountryInteract countryInteract;
    private final HospitalInteract hospitalInteract;
    private final SubjectTreatmentInteract subjectTreatmentInteract;

    public DataInsertService(
        CareInteract careInteract,
        CountryInteract countryInteract,
        HospitalInteract hospitalInteract,
        SubjectTreatmentInteract subjectTreatmentInteract
    ) {
        this.careInteract = careInteract;
        this.countryInteract = countryInteract;
        this.hospitalInteract = hospitalInteract;
        this.subjectTreatmentInteract = subjectTreatmentInteract;
    }

    @PostConstruct
    @Transactional
    public void insertData() {
        Care primary = new Care(1, "primary care hospital");
        Care secondary = new Care(2, "secondary care hospital");
        Care tertiary  = new Care(3, "tertiary care hospital");
        Care savedPrimary = careInteract.save(primary);
        Care savedSecondary = careInteract.save(secondary);
        Care savedTertiary = careInteract.save(tertiary);

        Country korea = new Country("South Korea", "KOR");
        Country japan = new Country("Japan", "JP");
        Country usa = new Country("United States", "US");
        Country savedKorea = countryInteract.save(korea);
        Country savedJapan = countryInteract.save(japan);
        Country savedUnitedStates = countryInteract.save(usa);

        SubjectTreatment internal = new SubjectTreatment("Internal Medicine");
        SubjectTreatment pulmonology = new SubjectTreatment("Pulmonology");
        SubjectTreatment allergy = new SubjectTreatment("Allergy");
        SubjectTreatment orthopedic = new SubjectTreatment("Orthopedic");
        SubjectTreatment general = new SubjectTreatment("General");
        SubjectTreatment savedInternal = subjectTreatmentInteract.save(internal);
        SubjectTreatment savedPulmonology = subjectTreatmentInteract.save(pulmonology);
        SubjectTreatment savedAllergy = subjectTreatmentInteract.save(allergy);
        SubjectTreatment savedOrthopedic = subjectTreatmentInteract.save(orthopedic);
        SubjectTreatment savedGeneral = subjectTreatmentInteract.save(general);

        Hospital hospital1 = new Hospital("Pangyo Internal Clinic", savedPrimary, savedKorea, savedInternal);
        Hospital hospital2 = new Hospital("Bundang Seoul Univ. Hospital", savedTertiary, savedKorea, savedGeneral);
        Hospital hospital3 = new Hospital("Pangyo TCC Orthopedic Clinic", savedPrimary, savedKorea, savedOrthopedic);
        Hospital hospital4 = new Hospital("Cha Unv. Hospital", savedSecondary, savedKorea, savedGeneral);
        Hospital hospital5 = new Hospital("Jaeseng General Hospital", savedSecondary, savedKorea, savedGeneral);

        Hospital hospital6 = new Hospital("Meijo Hospital", savedPrimary, savedJapan, savedPulmonology);
        Hospital hospital7 = new Hospital("Nagoya Ekisaikai Hospital", savedTertiary, savedJapan, savedGeneral);
        Hospital hospital8 = new Hospital("Bisai Hospital", savedSecondary, savedJapan, savedAllergy);

        Hospital hospital9 = new Hospital("NYU Langone Orthopedic Hospital", savedSecondary, savedUnitedStates, savedOrthopedic);
        Hospital hospital10 = new Hospital("UCLA Medical Center", savedTertiary, savedUnitedStates, savedPulmonology);
        Hospital hospital11 = new Hospital("Mayo Clinic", savedPrimary, savedUnitedStates, savedAllergy);
        hospitalInteract.saveHospitals(Arrays.asList(hospital1, hospital2, hospital3, hospital4, hospital5, hospital6, hospital7, hospital8, hospital9, hospital10, hospital11));
    }
}
