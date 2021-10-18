package com.pluralsight.tddjunit5.mileage;

import com.pluralsight.tddjunit5.airport.Flight;
import com.pluralsight.tddjunit5.airport.Passenger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** TestInstance
 * Indique que l'on souhaite que les tests soient exécutés sur 1 seule instance de la classe
 * car on souhaite tester l'accumulation de points
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MileageTest {

    private Mileage mileage;

    @BeforeAll
    void beforeAll() {
        mileage = new Mileage();
    }

    @ParameterizedTest
    @ValueSource(strings = { "1; e; Mike; false; 349", "2; b; John; true; 278", "3; e; Mike; false; 319", "4; p; John; true; 817",
    "5; e; Mike; false; 623", "6; e; John; true; 978"})
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger: flight.getPassengerSet()) {
            mileage.addMileage(passenger, flight.getDistance());
        }
        assertTrue(true);
    }

    @AfterAll
    void afterAll() {
        mileage.calculateGivenPoints();
        assertEquals(64, mileage.getPassengersPointMap().get(new Passenger("Mike", false)).intValue());
        assertEquals(207, mileage.getPassengersPointMap().get(new Passenger("John", true)).intValue());
    }
}
