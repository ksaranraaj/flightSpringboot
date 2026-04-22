package com.example.Flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Flight.persistance.FlightPO;

public interface FlightDao extends JpaRepository<FlightPO, Integer> {

}