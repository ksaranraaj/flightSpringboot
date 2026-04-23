package com.example.AirlineManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AirlineManagementSystem.persistance.CarrierPO;
@Repository
public interface CarrierDao extends JpaRepository<CarrierPO, Integer> {

}