package com.pluralsight.tddjunit5.mileage;

import com.pluralsight.tddjunit5.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mileage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMileageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengersPointMap() {
        return Collections.unmodifiableMap(passengersPointMap);
    }

    public void addMileage(Passenger passenger, int miles) {
        if (passengersMileageMap.containsKey(passenger)) {
            passengersMileageMap.put(passenger, passengersMileageMap.get(passenger) + miles);
        } else {
            passengersMileageMap.put(passenger, miles);
        }
    }

    public void calculateGivenPoints() {
        for (Passenger passenger : passengersMileageMap.keySet()) {
            passengersPointMap.put(passenger, passengersMileageMap.get(passenger) / (passenger.isVip() ? VIP_FACTOR : USUAL_FACTOR));
        }
    }
}
