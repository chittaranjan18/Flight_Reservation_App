package com.flight.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.checkin.integration.ReservationRestfulClient;
import com.flight.checkin.integration.dto.Reservation;
import com.flight.checkin.integration.dto.ReservationUpdateRequest;

@Controller
public class ReservationController {
   
	@Autowired
	private ReservationRestfulClient restClient;
	@RequestMapping("/startCheckIn")
	public String showCheckIn() {
		return "startCheckedIn";
	}
	@RequestMapping("/proceedCheckIn")
	public String proceedCheckIn(@RequestParam("id")long id,ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(id);
		modelMap.addAttribute("reservation",reservation);
		return "displayReservation";
	}
	@RequestMapping("/update")
	public String updateStatus(@RequestParam("id")long id,@RequestParam("NumberOfBags")int NumberOfBags,@RequestParam("checkedIn")boolean checkedIn) {
	   
		ReservationUpdateRequest request=new ReservationUpdateRequest();
		request.setId(id);
		request.setNumberOfBags(NumberOfBags);
		request.setCheckInStatus(checkedIn);
		
		
		restClient.updateReservation(request);
		return "completeReservation";
	}
}
