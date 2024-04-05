package isp.lab6.exercise2;

public class Vehicle {
  // Attributes
  private final int VIN;
  private final String licensePlate;
  private final String make;
  private final String model;
  private final int year;
  private static int VINCounter = 0;

  // Getters & Setters
  public int getVIN() {
    return VIN;
  }

  public static void resetVINCounter() {
    VINCounter = 0;
  }

  // Constructors
  public Vehicle(String licensePlate, String make, String model, int year) {
    this.VIN = ++VINCounter;
    this.licensePlate = licensePlate;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  // Methods
  @Override
  public String toString() {
    return "Vehicle{" +
        "VIN=" + VIN +
        ", licensePlate='" + licensePlate + '\'' +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) obj;
    return VIN == vehicle.VIN;
  }

  @Override
  public int hashCode() {
    return VIN;
  }
}
