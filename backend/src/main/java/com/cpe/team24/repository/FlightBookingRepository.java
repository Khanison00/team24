package com.cpe.team24.repository;

import com.cpe.team24.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface FlightBookingRepository extends JpaRepository<FlightBooking,Long> {
    public Optional<FlightBooking> findById(Long id);
}
