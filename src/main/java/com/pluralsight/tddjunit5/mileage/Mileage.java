package com.pluralsight.tddjunit5.mileage;

import com.pluralsight.tddjunit5.airport.Passenger;

import java.util.HashMap;
import java.util.Map;

public class Mileage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMileageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointMap = new HashMap<>();

    public void addMileage(Passenger passenger, int miles) {
        
    }
}
