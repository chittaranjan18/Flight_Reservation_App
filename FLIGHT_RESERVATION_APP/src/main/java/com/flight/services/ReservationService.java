package com.flight.services;

import com.flight.dto.ReservationRequest;
import com.flight.entities.Reservation;

public interface ReservationService {
 Reservation bookFlight(ReservationRequest request);
}
