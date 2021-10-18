package com.pluralsight.tddjunit5.airconditionning;

public class Thermometer {
    private double temperature;
    private Sensor sensor;

    public double getTemperature() {
        if (this.sensor.isBlocked()) {
            throw new RuntimeException("Sensor is blocked");
        }
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
