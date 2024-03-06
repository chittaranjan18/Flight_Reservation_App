package com.flight.checkin.integration.dto;

public class ReservationUpdateRequest {
   private Long id;
   private int NumberOfBags;
   private boolean checkInStatus;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getNumberOfBags() {
	return NumberOfBags;
}
public void setNumberOfBags(int numberOfBags) {
	NumberOfBags = numberOfBags;
}
public boolean isCheckInStatus() {
	return checkInStatus;
}
public void setCheckInStatus(boolean checkInStatus) {
	this.checkInStatus = checkInStatus;
}
   
}
