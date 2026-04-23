package com.example.AirlineManagementSystem.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AirlineManagementSystem.beans.BookFlight;
import com.example.AirlineManagementSystem.service.BookFlightService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookflight")
public class BookFlightController {

    @Autowired
    private BookFlightService bookFlightService;

    // Get all bookings
    @GetMapping("/getAllBookings")
    public List<BookFlight> getAllBookings() {
        return bookFlightService.getAllBookings();
    }

    // Get booking by ID
    @GetMapping("/getBooking/{id}")
    public Optional<BookFlight> getBookingById(@PathVariable int id) {
        return bookFlightService.getBookingById(id);
    }

    // Add a new booking
    @PostMapping("/addBooking")
    public BookFlight addBooking(@RequestBody BookFlight bookFlight) {
        return bookFlightService.addBooking(bookFlight);
    }

    // Update an existing booking
    @PutMapping("/updateBooking")
    public BookFlight updateBooking(@RequestBody BookFlight bookFlight) {
        return bookFlightService.updateBooking(bookFlight);
    }

    // Delete a booking by ID
    @DeleteMapping("/deleteBooking/{id}")
    public String deleteBookingById(@PathVariable int id) {
        bookFlightService.deleteBookingById(id);
        return "Booking with ID " + id + " has been deleted.";
    }
}

