package isp.lab5.exercise3;

public class PressureSensor extends Sensor {
  // Attributes
  private double pressure;

  // Constructors
  public PressureSensor(String installLocation, String name, double pressure) {
    super(installLocation, name);
    this.pressure = pressure;
  }

  // Methods
  @Override
  public double getCharacteristic() {
    return pressure;
  }
}
