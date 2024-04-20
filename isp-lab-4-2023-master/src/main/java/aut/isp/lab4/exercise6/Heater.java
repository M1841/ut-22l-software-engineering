package aut.isp.lab4.exercise6;

public class Heater extends Actuator {
  // Constructors
  public Heater(String manufacturer, String model) {
    super(manufacturer, model);
  }

  // Methods
  @Override
  public void turnOn() {
    System.out.println("Heater is on.");
    super.turnOn();
  }

  @Override
  public void turnOff() {
    System.out.println("Heater is off.");
    super.turnOff();
  }
}
