package com.example.AirlineManagementSystem.beans;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int bookingId;
	private int flightId;
	private int userId;
	private int noOfSeats;
	private String seatCategory;
	private Date traveldate;
	private String origin;
	private String destination;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingId ,int flightId, int userId, int noOfSeats, String seatCategory, Date traveldate, 
			String origin, String destination) {
		super();
		this.bookingId=bookingId;
		this.flightId = flightId;
		this.userId = userId;
		this.noOfSeats = noOfSeats;
		this.seatCategory = seatCategory;
		this.traveldate = traveldate;
		this.origin = origin;
		this.destination = destination;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	public Date getTraveldate() {
		return traveldate;
	}
	public void setTraveldate(Date traveldate) {
		this.traveldate = traveldate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", flightId=" + flightId + ", userId=" + userId + ", noOfSeats="
				+ noOfSeats + ", seatCategory=" + seatCategory + ", traveldate=" + traveldate + 
				", origin=" + origin + ", destination=" + destination + "]";
	}
	
}
