package com.pluralsight.tddjunit5.airport;

public class EconomyFlight extends Flight {

    public EconomyFlight(String id) { super(id); }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengerSet.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return !passenger.isVip() ? passengerSet.remove(passenger) : false;
    }
}
