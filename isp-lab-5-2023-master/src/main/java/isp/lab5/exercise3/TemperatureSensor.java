package isp.lab5.exercise3;

public class TemperatureSensor extends Sensor {
  // Attributes
  private double temperature;

  // Constructors
  public TemperatureSensor(String installLocation, String name, double temperature) {
    super(installLocation, name);
    this.temperature = temperature;
  }

  // Methods
  @Override
  public double getCharacteristic() {
    return temperature;
  }
}
