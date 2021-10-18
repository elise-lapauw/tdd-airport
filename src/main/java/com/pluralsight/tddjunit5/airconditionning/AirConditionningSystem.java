package com.pluralsight.tddjunit5.airconditionning;

public class AirConditionningSystem {

    private Thermometer thermometer;
    private double temperatureThreshold;
    private boolean open;

    public AirConditionningSystem() {
        this.open = false;
    }

    public void checkAirContionningSystem() {
        this.open = thermometer.getTemperature() >= this.temperatureThreshold;
    }

    public void setTemperatureThreshold(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }

    public boolean isOpen() {
        return open;
    }

}
