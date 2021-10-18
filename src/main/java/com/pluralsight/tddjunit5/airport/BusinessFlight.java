package com.pluralsight.tddjunit5.airport;

public class BusinessFlight extends Flight {

    public BusinessFlight(String id) { super(id); }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passenger.isVip() ? passengerSet.add(passenger) : false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
