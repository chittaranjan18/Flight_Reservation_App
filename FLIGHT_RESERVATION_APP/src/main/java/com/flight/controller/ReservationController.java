package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight.dto.ReservationRequest;
import com.flight.entities.Reservation;
import com.flight.services.ReservationService;

@Controller
public class ReservationController {
    
	@Autowired
     private ReservationService reservationService;
	@RequestMapping("/confReservation")
	public String confirmReservation(ReservationRequest request,ModelMap modelMap) {
		System.out.println(request.getFlightId());
     Reservation reservationId = reservationService.bookFlight(request);
    //System.out.println(reservationId);
     modelMap.addAttribute("reservationId",reservationId);
		return "confirmReservation"; 
	}
}
