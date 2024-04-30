package org.example.dbtransactions.association.interfaces;

import org.example.dbtransactions.association.entity.PeopleFamilyRelation;

import java.util.List;

public interface PeopleFamilyRelationInteract {

    PeopleFamilyRelation save (PeopleFamilyRelation peopleFamilyRelation);

    List<PeopleFamilyRelation> savePeopleFamilyRelations (List<PeopleFamilyRelation> peopleFamilyRelations);
}
