package com.cpe.team24.entity;

import lombok.*;

import java.util.Collection;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class Airport {
    @Id
    @SequenceGenerator(name="AIRPORT_SEQ",sequenceName="AIRPORT_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AIRPORT_ID",unique = true, nullable = true)
    private Long id;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }


   @ManyToOne(fetch = FetchType.EAGER, targetEntity = City.class)
   @JoinColumn(name = "FIGHT_CITY_ID", insertable = true)
   private City city;

   @OneToMany(fetch = FetchType.EAGER)
   // mappedBy  = "airport"
   private Collection<FlightAirport> flightAirports;

}