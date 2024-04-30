package org.example.dbtransactions.common.service;

import jakarta.annotation.PostConstruct;
import org.example.dbtransactions.association.entity.Family;
import org.example.dbtransactions.association.entity.People;
import org.example.dbtransactions.association.entity.PeopleFamilyRelation;
import org.example.dbtransactions.association.interfaces.FamilyInteract;
import org.example.dbtransactions.association.interfaces.PeopleFamilyRelationInteract;
import org.example.dbtransactions.association.interfaces.PeopleInteract;
import org.example.dbtransactions.normalized.entity.*;
import org.example.dbtransactions.normalized.interfaces.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInsertService {

    /* Normalized database */
    private final CareInteract careInteract;
    private final CountryInteract countryInteract;
    private final HospitalInteract hospitalInteract;
    private final SubjectTreatmentInteract subjectTreatmentInteract;
    private final CityInteract cityInteract;

    /* Association database */
    private final PeopleInteract peopleInteract;
    private final FamilyInteract familyInteract;
    private final PeopleFamilyRelationInteract peopleFamilyRelationInteract;


    public DataInsertService(
        CareInteract careInteract,
        CountryInteract countryInteract,
        HospitalInteract hospitalInteract,
        SubjectTreatmentInteract subjectTreatmentInteract,
        CityInteract cityInteract,
        PeopleInteract peopleInteract,
        FamilyInteract familyInteract,
        PeopleFamilyRelationInteract peopleFamilyRelationInteract
    ) {
        this.careInteract = careInteract;
        this.countryInteract = countryInteract;
        this.hospitalInteract = hospitalInteract;
        this.subjectTreatmentInteract = subjectTreatmentInteract;
        this.cityInteract = cityInteract;
        this.peopleInteract = peopleInteract;
        this.familyInteract = familyInteract;
        this.peopleFamilyRelationInteract = peopleFamilyRelationInteract;
    }

    @PostConstruct
    @Transactional
    public void normalizedInsertData() {
        List<Hospital> foundHospitals = hospitalInteract.findAll();
        if(!foundHospitals.isEmpty()) return;

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

        City seoul = new City("Seoul", savedKorea);
        City gyeonggi = new City("Gyeong-gi", savedKorea);
        City busan = new City("Busan", savedKorea);

        City tokyo = new City("Tokyo", savedJapan);
        City okinawa = new City("Okinawa", savedJapan);
        City osaka = new City("Osaka", savedJapan);

        City la = new City("Los-Angeles", savedUnitedStates);
        City newyork = new City("New york", savedUnitedStates);
        City utah = new City("Utah", savedUnitedStates);
        cityInteract.saveCities(Arrays.asList(seoul, gyeonggi, busan, tokyo, okinawa, osaka, la, newyork, utah));

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

    @PostConstruct
    @Transactional
    public void associationInsertData() {
        List<People> foundPeople = peopleInteract.findAll();
        if(!foundPeople.isEmpty()) return;

        People jason = new People("Jason");
        People grace = new People("Grace");
        People jae = new People("Jae");
        People youngsun = new People("Young Sun");

        People yerim = new People("Yerim");
        People gwangjin = new People("Gwangjin");
        People wonyoung = new People("Won young");
        People savedjason = peopleInteract.save(jason);
        People savedgrace = peopleInteract.save(grace);
        People savedjae = peopleInteract.save(jae);
        People savedyoungsun = peopleInteract.save(youngsun);
        People savedyerim = peopleInteract.save(yerim);
        People savedgwangjin = peopleInteract.save(gwangjin);
        People savedwonyoung = peopleInteract.save(wonyoung);

        Family choi = new Family("Choi");
        Family shin = new Family("Shin");
        Family kim = new Family("Kim");
        Family savedChoi = familyInteract.save(choi);
        Family savedShin = familyInteract.save(shin);
        Family savedKim = familyInteract.save(kim);

        PeopleFamilyRelation choiRelation1 = new PeopleFamilyRelation(savedjason, savedChoi);
        PeopleFamilyRelation choiRelation2 = new PeopleFamilyRelation(savedgrace, savedChoi);
        PeopleFamilyRelation choiRelation3 = new PeopleFamilyRelation(savedjae, savedChoi);
        PeopleFamilyRelation choiRelation4 = new PeopleFamilyRelation(savedyoungsun, savedChoi);

        PeopleFamilyRelation shinRelation = new PeopleFamilyRelation(savedyoungsun, savedShin);

        PeopleFamilyRelation kimRelation1 = new PeopleFamilyRelation(savedyerim, savedKim);
        PeopleFamilyRelation kimRelation2 = new PeopleFamilyRelation(savedgwangjin, savedKim);
        PeopleFamilyRelation kimRelation3 = new PeopleFamilyRelation(savedwonyoung, savedKim);

        peopleFamilyRelationInteract.savePeopleFamilyRelations(Arrays.asList(choiRelation1, choiRelation2, choiRelation3, choiRelation4, shinRelation, kimRelation1, kimRelation2, kimRelation3));
    }
}
