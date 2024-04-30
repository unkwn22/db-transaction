package org.example.dbtransactions.queryDSL.interfaces;

import com.querydsl.core.Tuple;

import java.util.List;

public interface PeopleCustomInteract {

    List<Tuple> findPeopleById(Long id);
}
