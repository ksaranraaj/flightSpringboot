package com.example.AirlineManagementSystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AirlineManagementSystem.beans.BookFlight;
import com.example.AirlineManagementSystem.repo.BookFlightDao;

import java.util.List;
import java.util.Optional;

@Service
public class BookFlightService {

    @Autowired
    private BookFlightDao bookFlightDao;

    // Retrieve all bookings
    public List<BookFlight> getAllBookings() {
        return bookFlightDao.findAll();
    }

    // Retrieve a booking by ID
    public Optional<BookFlight> getBookingById(int id) {
        return bookFlightDao.findById(id);
    }

    // Add a new booking
    public BookFlight addBooking(BookFlight bookFlight) {
        return bookFlightDao.save(bookFlight);
    }

    // Update an existing booking
    public BookFlight updateBooking(BookFlight bookFlight) {
        return bookFlightDao.save(bookFlight);
    }

    // Delete a booking by ID
    public void deleteBookingById(int id) {
        bookFlightDao.deleteById(id);
    }
}
