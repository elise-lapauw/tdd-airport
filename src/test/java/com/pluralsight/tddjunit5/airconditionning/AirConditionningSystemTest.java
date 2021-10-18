package com.pluralsight.tddjunit5.airconditionning;

import com.pluralsight.tddjunit5.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AirConditionningSystemTest {

    @InjectMocks
    AirConditionningSystem airConditionningSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testAirContionedSystemStarted() {
        when(thermometer.getTemperature()).thenReturn(25.0);
        airConditionningSystem.setTemperatureThreshold(24.0);
        airConditionningSystem.checkAirContionningSystem();
        assertTrue(airConditionningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();

    }

    @Test
    void testAirContionedSystemStopped() {
        when(thermometer.getTemperature()).thenReturn(23.0);
        airConditionningSystem.setTemperatureThreshold(24.0);
        airConditionningSystem.checkAirContionningSystem();
        assertFalse(airConditionningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();
    }
}
