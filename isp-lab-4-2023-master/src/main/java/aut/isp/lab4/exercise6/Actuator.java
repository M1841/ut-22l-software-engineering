package aut.isp.lab4.exercise6;

public class Actuator {
  // Attributes
  private final String manufacturer;
  private final String model;
  private boolean isOn;

  // Getters & Setters
  public boolean getIsOn() {
    return isOn;
  }

  // Constructors
  public Actuator(String manufacturer, String model) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.isOn = false;
  }

  // Methods
  public void turnOn() {
    this.isOn = true;
  }

  public void turnOff() {
    this.isOn = false;
  }

  @Override
  public String toString() {
    return "{\n\tmanufacturer = \"" + this.manufacturer +
        "\",\n\tmodel = \"" + this.model +
        "\",\n\tisOn = " + this.isOn +
        "\n}";
  }
}
