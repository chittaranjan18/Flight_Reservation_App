 package com.flight.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dto.ReservationRequest;
import com.flight.entities.Flight;
import com.flight.entities.Passenger;
import com.flight.entities.Reservation;
import com.flight.repositories.FlightRepository;
import com.flight.repositories.PassengerRepository;
import com.flight.repositories.ReservationRepository;
import com.flight.utilities.EmailSending;
import com.flight.utilities.PDFgenerator;
@Service
public class ReservationServiceImpl implements ReservationService {
     
	
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private EmailSending emailSending;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		 String filePath="D:\\tickets\\booking";
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		long flightId = request.getFlightId();
		System.out.println(flightId);
		Optional<Flight> findById = flightRepo.findById(flightId);
		
		 if (!findById.isPresent()) {
			 System.out.println("flight not found");
	        }
		 Flight flight = findById.get();
		
		
		Reservation reservation =new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		reservationRepo.save(reservation);
		
		PDFgenerator pdf=new PDFgenerator();
		pdf.generatePDF(filePath+reservation.getId()+".pdf", request.getFirstName(), request.getEmail(), request.getPhone(), flight.getOperatingAirlines(), flight.getDateOfDeparture(), flight.getDepartureCity(), flight.getArrivalCity());
		//emailSending.sendItinerary(passenger.getEmail(),filePath);
		return reservation;
	}

}
