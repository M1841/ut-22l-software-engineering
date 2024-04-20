package aut.isp.lab4.exercise6;

public class Pump extends Actuator {
    // Constructors
    public Pump(String manufacturer, String model) {
        super(manufacturer, model);
    }

    // Methods
    @Override
    public void turnOn() {
        System.out.println("Pump is on.");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Pump is off.");
        super.turnOff();
    }
}
