package com.example.AirlineManagementSystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AirlineManagementSystem.beans.Flight;
import com.example.AirlineManagementSystem.Exception.NotFoundException;
import com.example.AirlineManagementSystem.persistance.FlightPO;
import com.example.AirlineManagementSystem.repo.FlightDao;

@Service
public class FlightService {

    @Autowired
    private FlightDao flightDao;

    public Flight getFlight() {
        // Example for a default flight instance
        return new Flight(1, "Example Airlines", "NYC", "LAX", 300.0, 20, 100, 10);
    }

    public List<Flight> getAllFlights() {
        List<FlightPO> flightPOList = flightDao.findAll();
        List<Flight> flightList = new ArrayList<>();
        flightPOList.forEach(fp -> flightList.add(convertToPOJO(fp)));
        return flightList;
    }

    public Flight getFlightById(@RequestParam Integer id) {
        return convertToPOJO(flightDao.findById(id).orElseThrow(() -> 
            new NotFoundException("Flight", "Id", id)));
    }

    public List<Flight> getAllFlightsByCarrierAndFare(@PathVariable String carrier, @PathVariable double fare) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (FlightPO flightPO : flightDao.findAll()) {
            if (flightPO.getCarrierName().equalsIgnoreCase(carrier) && flightPO.getAirFare() <= fare) {
                filteredFlights.add(convertToPOJO(flightPO));
            }
        }
        return filteredFlights;
    }

    public void addFlight(@RequestBody Flight flight) {
        FlightPO flightPO = convertToPersistenceObject(flight);
        flightDao.save(flightPO);
    }

    public Flight updateFlight(@RequestBody Flight flight) {
        FlightPO flightPO = convertToPersistenceObject(flight);
        flightDao.findById(flight.getFlightId())
                 .orElseThrow(() -> new NotFoundException("Flight", "Id", flight.getFlightId()));
        flightDao.save(flightPO);
        return flight;
    }

    public void deleteFlightById(Integer id) {
        flightDao.deleteById(id);
    }

    public Integer[] deleteMultipleFlights(@RequestParam Integer[] ids) {
        flightDao.deleteAllByIdInBatch(Arrays.asList(ids));
        return ids;
    }

    public void deleteAllFlights() {
        flightDao.deleteAll();
    }

    private FlightPO convertToPersistenceObject(Flight flight) {
        FlightPO flightPO = new FlightPO();
        flightPO.setFlightId(flight.getFlightId());
        flightPO.setCarrierName(flight.getCarrierName());
        flightPO.setOrigin(flight.getOrigin());
        flightPO.setDestination(flight.getDestination());
        flightPO.setAirFare(flight.getAirFare());
        flightPO.setSeatCapacityBusinessClass(flight.getSeatCapacityBusinessClass());
        flightPO.setSeatCapacityEconomyClass(flight.getSeatCapacityEconomyClass());
        flightPO.setSeatCapacityExecutiveClass(flight.getSeatCapacityExecutiveClass());
        return flightPO;
    }

    private Flight convertToPOJO(FlightPO flightPO) {
        Flight flight = new Flight();
        flight.setFlightId(flightPO.getFlightId());
        flight.setCarrierName(flightPO.getCarrierName());
        flight.setOrigin(flightPO.getOrigin());
        flight.setDestination(flightPO.getDestination());
        flight.setAirFare(flightPO.getAirFare());
        flight.setSeatCapacityBusinessClass(flightPO.getSeatCapacityBusinessClass());
        flight.setSeatCapacityEconomyClass(flightPO.getSeatCapacityEconomyClass());
        flight.setSeatCapacityExecutiveClass(flightPO.getSeatCapacityExecutiveClass());
        return flight;
    }
}