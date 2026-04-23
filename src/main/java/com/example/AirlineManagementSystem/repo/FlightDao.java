package com.example.AirlineManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AirlineManagementSystem.persistance.FlightPO;

@Repository
public interface FlightDao extends JpaRepository<FlightPO, Integer> {

}