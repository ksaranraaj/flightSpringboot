package com.example.AirlineManagementSystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AirlineManagementSystem.Exception.NotFoundException;
import com.example.AirlineManagementSystem.beans.Carrier;
import com.example.AirlineManagementSystem.persistance.CarrierPO;
import com.example.AirlineManagementSystem.repo.CarrierDao;


@Service
public class CarrierService {

    @Autowired
    CarrierDao carrierDao;

    // Get a single Carrier
    public Carrier getCarrierById(Integer id) {
        CarrierPO carrierPO = carrierDao.findById(id)
                .orElseThrow(() -> new NotFoundException("Carrier", "Id", id));
        return convertToPOJO(carrierPO);
    }

    // Get all Carriers
    public List<Carrier> getAllCarriers() {
        List<CarrierPO> carrierPOList = carrierDao.findAll();
        List<Carrier> carrierList = new ArrayList<>();
        carrierPOList.forEach(c -> carrierList.add(convertToPOJO(c)));
        return carrierList;
    }

    // Add a new Carrier
    public void addCarrier(Carrier carrier) {
        CarrierPO carrierPO = convertToPersistenceObject(carrier);
        carrierDao.save(carrierPO);
    }

    // Update an existing Carrier
    public Carrier updateCarrier(Carrier carrier) {
        carrierDao.findById(carrier.getCarrierId())
                .orElseThrow(() -> new NotFoundException("Update Operation", "Id", carrier.getCarrierId()));
        CarrierPO carrierPO = convertToPersistenceObject(carrier);
        carrierDao.save(carrierPO);
        return carrier;
    }

    // Delete a Carrier by ID
    public void deleteCarrierById(Integer id) {
        carrierDao.findById(id)
                .orElseThrow(() -> new NotFoundException("Carrier", "Id", id));
        carrierDao.deleteById(id);
    }

    // Delete multiple Carriers
    public Integer[] deleteMultipleCarriers(Integer[] ids) {
        carrierDao.deleteAllByIdInBatch(Arrays.asList(ids));
        return ids;
    }

    // Delete all Carriers
    public void deleteAllCarriers() {
        carrierDao.deleteAll();
    }
    

    // Helper method to convert from PO to Persistence Object
    public CarrierPO convertToPersistenceObject(Carrier carrier) {
        CarrierPO carrierPO = new CarrierPO();
        carrierPO.setCarrierId(carrier.getCarrierId());
        carrierPO.setCarrierName(carrier.getCarrierName());
        carrierPO.setThirtyDaysAdvanceBooking(carrier.getThirtyDaysAdvanceBooking());
        carrierPO.setSixtyDaysAdvanceBooking(carrier.getSixtyDaysAdvanceBooking());
        carrierPO.setNinetyDaysAdvanceBooking(carrier.getNinetyDaysAdvanceBooking());
        carrierPO.setBulkBooking(carrier.getBulkBooking());
        carrierPO.setSilverUser(carrier.getSilverUser());
        carrierPO.setGoldUser(carrier.getGoldUser());
        carrierPO.setPlatinumUser(carrier.getPlatinumUser());
        carrierPO.setTwoDaysBeforeTravelDate(carrier.getTwoDaysBeforeTravelDate());
        carrierPO.setTenDaysBeforeTravelDate(carrier.getTenDaysBeforeTravelDate());
        carrierPO.setTwentyDaysBeforeTravelDate(carrier.getTwentyDaysBeforeTravelDate());
        return carrierPO;
    }

    // Helper method to convert from Persistence Object to PO
    public Carrier convertToPOJO(CarrierPO carrierPO) {
        Carrier carrier = new Carrier();
        carrier.setCarrierId(carrierPO.getCarrierId());
        carrier.setCarrierName(carrierPO.getCarrierName());
        carrier.setThirtyDaysAdvanceBooking(carrierPO.getThirtyDaysAdvanceBooking());
        carrier.setSixtyDaysAdvanceBooking(carrierPO.getSixtyDaysAdvanceBooking());
        carrier.setNinetyDaysAdvanceBooking(carrierPO.getNinetyDaysAdvanceBooking());
        carrier.setBulkBooking(carrierPO.getBulkBooking());
        carrier.setSilverUser(carrierPO.getSilverUser());
        carrier.setGoldUser(carrierPO.getGoldUser());
        carrier.setPlatinumUser(carrierPO.getPlatinumUser());
        carrier.setTwoDaysBeforeTravelDate(carrierPO.getTwoDaysBeforeTravelDate());
        carrier.setTenDaysBeforeTravelDate(carrierPO.getTenDaysBeforeTravelDate());
        carrier.setTwentyDaysBeforeTravelDate(carrierPO.getTwentyDaysBeforeTravelDate());
        return carrier;
    }
}











