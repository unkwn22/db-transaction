package org.example.dbtransactions.association.interfaces;

import org.example.dbtransactions.association.entity.Family;

import java.util.List;

public interface FamilyInteract {

    Family save(Family family);

    List<Family> saveFamilies(List<Family> families);

    Family findById(Long id);
}
