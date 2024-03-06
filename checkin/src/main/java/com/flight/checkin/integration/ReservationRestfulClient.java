package com.flight.checkin.integration;

import com.flight.checkin.integration.dto.Reservation;
import com.flight.checkin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestfulClient {
      public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
    	  
}
