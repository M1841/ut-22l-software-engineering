package aut.isp.lab4.exercise5;

public class Sensor {
  // Attributes
  private final String manufacturer;
  private final String model;
  private final String unitOfMeasurement;

  // Getters & Setters
  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public String getUnitOfMeasurement() {
    return unitOfMeasurement;
  }

  // Constructors
  public Sensor(String manufacturer, String model, String unitOfMeasurement) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.unitOfMeasurement = unitOfMeasurement;
  }

  // Methods
  @Override
  public String toString() {
    return "{\n\tmanufacturer = \"" + this.manufacturer +
        "\",\n\tmodel = \"" + this.model +
        "\",\n\tunitOfMeasurement = \"" + this.unitOfMeasurement +
        "\"\n}";
  }

}
