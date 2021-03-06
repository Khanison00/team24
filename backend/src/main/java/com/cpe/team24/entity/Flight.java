package com.cpe.team24.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="FLIGHT")
public class Flight {

    @Id
    @SequenceGenerator(name="FLIGHT_seq",sequenceName="FLIGHT_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FLIGHT_seq")
    @Column(name = "FLIGHT_ID", unique = true, nullable = true)
    private Long id;

    @Size(max = 255)
    @Pattern(regexp = "[a-z A-Z]*")
    private String description;
    
    @NotNull
    @PositiveOrZero
    private Double price;

    @NotNull
    private Date depart;

    @NotNull
    private Date arrive;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<FlightBookingLink> flightBookingLinks;

    // -------- Joke --------

    @OneToMany(mappedBy = "flight",fetch = FetchType.LAZY)
    private Collection<FlightAirport> flightAirports;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Airplane.class)
    @JoinColumn(name = "FIGHT_AIRPLANE_ID", insertable = true)
    private Airplane airplane;

    //Getter Setter
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }

    public Collection<FlightAirport> getFlightAirports() {
        return flightAirports;
    }

    public void setFlightAirports(Collection<FlightAirport> flightAirports) {
        this.flightAirports = flightAirports;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}