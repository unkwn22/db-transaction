package org.example.dbtransactions.queryDSL.repositories;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.dbtransactions.association.entity.CustomPeopleCommand;
import org.example.dbtransactions.association.entity.QFamily;
import org.example.dbtransactions.association.entity.QPeople;
import org.example.dbtransactions.association.entity.QPeopleFamilyRelation;
import org.example.dbtransactions.queryDSL.interfaces.PeopleCustomInteract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleCustomInteractImpl implements PeopleCustomInteract {

    @PersistenceContext
    private EntityManager em;

    private JPAQueryFactory jpaQueryFactory;

    public PeopleCustomInteractImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Tuple> findPeopleById(Long id) {
        QPeople people = QPeople.people;
        QPeopleFamilyRelation peopleFamilyRelation = QPeopleFamilyRelation.peopleFamilyRelation;
        QFamily family = QFamily.family;

        return jpaQueryFactory.select(
            people.id.as("people_id"),
            people.name.as("people_name"),
            family.id.as("family_id"),
            family.name.as("family_name")
        ).from(QPeople.people)
        .leftJoin(peopleFamilyRelation).on(peopleFamilyRelation.people.id.eq(people.id))
        .leftJoin(family).on(peopleFamilyRelation.family.id.eq(family.id))
        .where(
            people.id.eq(id)
        )
        .fetch();
    }
}
