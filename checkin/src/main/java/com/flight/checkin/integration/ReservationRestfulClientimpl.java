package com.flight.checkin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.flight.checkin.integration.dto.Reservation;
import com.flight.checkin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestfulClientimpl implements ReservationRestfulClient {
	
	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate=new RestTemplate();
		
		Reservation reservation = restTemplate.getForObject("http://localhost:8080/reservation/"+id, Reservation.class);
		return reservation;
	}
	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
	
	RestTemplate restTemplate=new RestTemplate();
	Reservation reservation=restTemplate.postForObject("http://localhost:8080/reservation/",request,Reservation.class);
     return reservation;
}
}
