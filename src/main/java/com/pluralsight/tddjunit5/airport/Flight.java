package com.pluralsight.tddjunit5.airport;

import java.util.*;

public abstract class Flight {

    private String id;
    Set<Passenger> passengerSet = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengerSet() {
        return Collections.unmodifiableSet(passengerSet);
    }


    public abstract boolean addPassenger(Passenger passenger);
    /*{
        if ("Economy".equals(flightType)) {
            return passengersList.add(passenger);
        } else if ("Business".equals(flightType)) {
            if (passenger.isVip()) {
                return passengersList.add(passenger);
            }
            return false;
        } else {
            throw new RuntimeException("Unknown type: " + flightType);
        }
    }*/

    public abstract boolean removePassenger(Passenger passenger);
    /*{
        if ("Economy".equals(flightType)) {
            if (!passenger.isVip()) {
                return passengersList.remove(passenger);
            }
            return false;
        } else if ("Business".equals(flightType)) {
            return false;
        } else {
            throw new RuntimeException("Unknown type: " + flightType);
        }
    }*/
}
