package com.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
