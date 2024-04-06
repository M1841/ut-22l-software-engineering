package isp.lab5.exercise3;

public abstract class Sensor {
  // Attributes
  private String installLocation;
  private String name;

  // Constructors
  public Sensor(String installLocation, String name) {
    this.installLocation = installLocation;
    this.name = name;
  }

  // Methods
  public abstract double getCharacteristic();
}
