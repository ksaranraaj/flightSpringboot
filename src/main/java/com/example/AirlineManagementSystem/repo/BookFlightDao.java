package com.example.AirlineManagementSystem.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AirlineManagementSystem.beans.BookFlight;

@Repository
public interface BookFlightDao extends JpaRepository<BookFlight, Integer> {
    // Additional custom queries can be added here if needed
}

