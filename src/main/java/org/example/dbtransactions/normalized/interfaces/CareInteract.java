package org.example.dbtransactions.normalized.interfaces;

import org.example.dbtransactions.normalized.entity.Care;

import java.util.List;

public interface CareInteract {

    List<Care> saveCares(List<Care> cares);

    Care save(Care care);
}
