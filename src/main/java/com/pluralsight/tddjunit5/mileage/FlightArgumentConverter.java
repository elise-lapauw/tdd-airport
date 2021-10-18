package com.pluralsight.tddjunit5.mileage;

import com.pluralsight.tddjunit5.airport.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;


public class FlightArgumentConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> target) throws ArgumentConversionException {
        //Assertions.assertEquals(String.class, source.getClass(), "Can only convert from String");
        //Assertions.assertEquals(Flight.class, target.getClass(), "Can only convert to Flight");

        String[] flightString = source.toString().split(";");
        Flight flight = null;

        switch (flightString[1].toLowerCase().trim()) {
            case "e" : flight = new EconomyFlight(flightString[0]);
                break;
            case "b" : flight = new BusinessFlight(flightString[0]);
                break;
            case "p" : flight = new PremiumFlight(flightString[0]);
                break;
        }

        flight.addPassenger(new Passenger(flightString[2].trim(), Boolean.valueOf(flightString[3].trim())));
        flight.setDistance(Integer.valueOf(flightString[4].trim()));

        return flight;
    }
}
