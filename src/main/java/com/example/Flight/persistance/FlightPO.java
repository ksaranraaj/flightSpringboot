package com.example.Flight.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Flight")
public class FlightPO {

    @Id
    @Column(name = "flightId")
    private int flightId;

    @Column(name = "carrierName")
    private String carrierName;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "airFare")
    private double airFare;

    @Column(name = "seatCapacityBusinessClass")
    private int seatCapacityBusinessClass;

    @Column(name = "seatCapacityEconomyClass")
    private int seatCapacityEconomyClass;

    @Column(name = "seatCapacityExecutiveClass")
    private int seatCapacityExecutiveClass;

    public FlightPO() {}

    public FlightPO(int flightId, String carrierName, String origin, String destination, double airFare,
                    int seatCapacityBusinessClass, int seatCapacityEconomyClass, int seatCapacityExecutiveClass) {
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
        return "FlightPO [flightId=" + flightId + ", carrierName=" + carrierName + ", origin=" + origin +
               ", destination=" + destination + ", airFare=" + airFare + ", seatCapacityBusinessClass=" +
               seatCapacityBusinessClass + ", seatCapacityEconomyClass=" + seatCapacityEconomyClass +
               ", seatCapacityExecutiveClass=" + seatCapacityExecutiveClass + "]";
    }
}