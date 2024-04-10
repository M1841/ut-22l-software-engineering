package aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor {
  // Attributes
  private float value;

  // Getters & Setters
  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }

  // Constructors
  public LevelSensor(String manufacturer, String model, String unitOfMeasurement, float value) {
    super(manufacturer, model, unitOfMeasurement);
    this.value = value;
  }

  // Methods
  @Override
  public String toString() {
    return "{\n\tmanufacturer = \"" + this.getManufacturer() +
        "\",\n\tmodel = \"" + this.getModel() +
        "\",\n\tunitOfMeasurement = \"" + this.getUnitOfMeasurement() +
        "\",\n\tvalue = " + this.value +
        "\n}";
  }
}
