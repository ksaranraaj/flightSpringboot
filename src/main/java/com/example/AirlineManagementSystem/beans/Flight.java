package com.example.AirlineManagementSystem.beans;

import org.springframework.stereotype.Component;

@Component
public class Flight {
    
    private int flightId;
    private String carrierName;
    private String origin;
    private String destination;
    private double airFare;
    private int seatCapacityBusinessClass;
    private int seatCapacityEconomyClass;
    private int seatCapacityExecutiveClass;
    
    public Flight() {}

    public Flight(int flightId, String carrierName, String origin, String destination, double airFare,
                  int seatCapacityBusinessClass, int seatCapacityEconomyClass, int seatCapacityExecutiveClass) {
        super();
        this.flightId = flightId;
        this.carrierName = carrierName;
        this.origin = origin;
        this.destination = destination;
        this.airFare = airFare;
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
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

    public double getAirFare() {
        return airFare;
    }

    public void setAirFare(double airFare) {
        this.airFare = airFare;
    }

    public int getSeatCapacityBusinessClass() {
        return seatCapacityBusinessClass;
    }

    public void setSeatCapacityBusinessClass(int seatCapacityBusinessClass) {
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
    }

    public int getSeatCapacityEconomyClass() {
        return seatCapacityEconomyClass;
    }

    public void setSeatCapacityEconomyClass(int seatCapacityEconomyClass) {
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
    }

    public int getSeatCapacityExecutiveClass() {
        return seatCapacityExecutiveClass;
    }

    public void setSeatCapacityExecutiveClass(int seatCapacityExecutiveClass) {
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
    }

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", carrierName=" + carrierName + ", origin=" + origin 
                + ", destination=" + destination + ", airFare=" + airFare 
                + ", seatCapacityBusinessClass=" + seatCapacityBusinessClass 
                + ", seatCapacityEconomyClass=" + seatCapacityEconomyClass 
                + ", seatCapacityExecutiveClass=" + seatCapacityExecutiveClass + "]";
    }
}