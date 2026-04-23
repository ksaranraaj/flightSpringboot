package com.example.AirlineManagementSystem.beans;

import org.springframework.stereotype.Component;

@Component
public class Carrier {
    private int carrierId;
    private String carrierName;
    
    private int thirtyDaysAdvanceBooking;
    private int sixtyDaysAdvanceBooking;
    private int ninetyDaysAdvanceBooking;
    private int bulkBooking;
    private int silverUser;
    private int goldUser;
    private int platinumUser;
    
    private int twoDaysBeforeTravelDate;
    private int tenDaysBeforeTravelDate;
    private int twentyDaysBeforeTravelDate;

    // Default constructor
    public Carrier() {}

    // Parameterized constructor
    public Carrier(int carrierId, String carrierName, int thirtyDaysAdvanceBooking, int sixtyDaysAdvanceBooking, 
                   int ninetyDaysAdvanceBooking, int bulkBooking, int silverUser, int goldUser, 
                   int platinumUser, int twoDaysBeforeTravelDate, int tenDaysBeforeTravelDate, 
                   int twentyDaysBeforeTravelDate) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.thirtyDaysAdvanceBooking = thirtyDaysAdvanceBooking;
        this.sixtyDaysAdvanceBooking = sixtyDaysAdvanceBooking;
        this.ninetyDaysAdvanceBooking = ninetyDaysAdvanceBooking;
        this.bulkBooking = bulkBooking;
        this.silverUser = silverUser;
        this.goldUser = goldUser;
        this.platinumUser = platinumUser;
        this.twoDaysBeforeTravelDate = twoDaysBeforeTravelDate;
        this.tenDaysBeforeTravelDate = tenDaysBeforeTravelDate;
        this.twentyDaysBeforeTravelDate = twentyDaysBeforeTravelDate;
    }

    // Getters and setters
    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getThirtyDaysAdvanceBooking() {
        return thirtyDaysAdvanceBooking;
    }

    public void setThirtyDaysAdvanceBooking(int thirtyDaysAdvanceBooking) {
        this.thirtyDaysAdvanceBooking = thirtyDaysAdvanceBooking;
    }

    public int getSixtyDaysAdvanceBooking() {
        return sixtyDaysAdvanceBooking;
    }

    public void setSixtyDaysAdvanceBooking(int sixtyDaysAdvanceBooking) {
        this.sixtyDaysAdvanceBooking = sixtyDaysAdvanceBooking;
    }

    public int getNinetyDaysAdvanceBooking() {
        return ninetyDaysAdvanceBooking;
    }

    public void setNinetyDaysAdvanceBooking(int ninetyDaysAdvanceBooking) {
        this.ninetyDaysAdvanceBooking = ninetyDaysAdvanceBooking;
    }

    public int getBulkBooking() {
        return bulkBooking;
    }

    public void setBulkBooking(int bulkBooking) {
        this.bulkBooking = bulkBooking;
    }

    public int getSilverUser() {
        return silverUser;
    }

    public void setSilverUser(int silverUser) {
        this.silverUser = silverUser;
    }

    public int getGoldUser() {
        return goldUser;
    }

    public void setGoldUser(int goldUser) {
        this.goldUser = goldUser;
    }

    public int getPlatinumUser() {
        return platinumUser;
    }

    public void setPlatinumUser(int platinumUser) {
        this.platinumUser = platinumUser;
    }

    public int getTwoDaysBeforeTravelDate() {
        return twoDaysBeforeTravelDate;
    }

    public void setTwoDaysBeforeTravelDate(int twoDaysBeforeTravelDate) {
        this.twoDaysBeforeTravelDate = twoDaysBeforeTravelDate;
    }

    public int getTenDaysBeforeTravelDate() {
        return tenDaysBeforeTravelDate;
    }

    public void setTenDaysBeforeTravelDate(int tenDaysBeforeTravelDate) {
        this.tenDaysBeforeTravelDate = tenDaysBeforeTravelDate;
    }

    public int getTwentyDaysBeforeTravelDate() {
        return twentyDaysBeforeTravelDate;
    }

    public void setTwentyDaysBeforeTravelDate(int twentyDaysBeforeTravelDate) {
        this.twentyDaysBeforeTravelDate = twentyDaysBeforeTravelDate;
    }

    // toString() method to display Carrier details
    @Override
    public String toString() {
        return "Carrier [carrierId=" + carrierId + ", carrierName=" + carrierName + 
               ", thirtyDaysAdvanceBooking=" + thirtyDaysAdvanceBooking + 
               ", sixtyDaysAdvanceBooking=" + sixtyDaysAdvanceBooking + 
               ", ninetyDaysAdvanceBooking=" + ninetyDaysAdvanceBooking + 
               ", bulkBooking=" + bulkBooking + ", silverUser=" + silverUser + 
               ", goldUser=" + goldUser + ", platinumUser=" + platinumUser + 
               ", twoDaysBeforeTravelDate=" + twoDaysBeforeTravelDate + 
               ", tenDaysBeforeTravelDate=" + tenDaysBeforeTravelDate + 
               ", twentyDaysBeforeTravelDate=" + twentyDaysBeforeTravelDate + "]";
    }
}