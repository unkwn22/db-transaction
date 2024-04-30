package org.example.dbtransactions.normalized.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    public City() {}

    public City(
        String name,
        Country country
    ) {
        this.name = name;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    protected String name;

    @ManyToOne(
        targetEntity = Country.class,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "country_id")
    protected Country country = new Country();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
