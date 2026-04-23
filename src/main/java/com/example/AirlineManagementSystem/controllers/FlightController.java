package com.example.AirlineManagementSystem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineManagementSystem.beans.Flight;
import com.example.AirlineManagementSystem.service.FlightService;

@RestController
@RequestMapping("flight")
public class FlightController {

    @Autowired
    private Environment env;

    @Autowired
    private FlightService flightService;

    @GetMapping("getFlight")
    public Flight getFlight() {
        return flightService.getFlight();
    }

    @GetMapping("getAllFlights")
    public List<Flight> getAllFlights() {
        List<Flight> flightList = flightService.getAllFlights();
        flightList.forEach(f -> System.out.println(f));
        return flightList;
    }

    @GetMapping("getFlightById")
    public ResponseEntity<Flight> getFlightById(@RequestParam Integer id) {
        Flight flight = flightService.getFlightById(id);
        return ResponseEntity.ok().header("getFlightById", id.toString()).body(flight);
    }

   

    @PostMapping("/addFlight")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight) {
        System.out.println(flight);
        flightService.addFlight(flight);
        return ResponseEntity.ok().build();
    }

    @PutMapping("updateFlight")
    @ResponseStatus(HttpStatus.OK)
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

    @DeleteMapping("deleteFlightById/{id}")
    public ResponseEntity<String> deleteFlightById(@PathVariable Integer id) {
        flightService.deleteFlightById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "GET,POST,OPTIONS,DELETE,PUT");
        return new ResponseEntity<>("Flight deleted successfully", responseHeaders, HttpStatus.OK);
    }

    @DeleteMapping("deleteMultipleFlights")
    public Integer[] deleteMultipleFlights(@RequestParam Integer[] ids) {
        return flightService.deleteMultipleFlights(ids);
    }

    @DeleteMapping("deleteAllFlights")
    public void deleteAllFlights() {
        flightService.deleteAllFlights();
    }

    @GetMapping("/env")
    public Map<String, String> getEnvironmentDetails() {
        String server = env.getProperty("server.port");
        String database = env.getProperty("spring.jpa.database-platform");
        String h2console = env.getProperty("spring.h2.console.enabled");
        String logFile = env.getProperty("logging.file.name");

        Map<String, String> envDetails = new HashMap<>();
        envDetails.put("server", server);
        envDetails.put("database", database);
        envDetails.put("h2console-Enabled", h2console);
        envDetails.put("Log File", logFile);

        return envDetails;
    }
}