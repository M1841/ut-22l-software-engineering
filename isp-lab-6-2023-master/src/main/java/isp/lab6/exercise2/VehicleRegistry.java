package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
  // Attribures
  private Set<Vehicle> vehicles;

  // Getters & Setters
  public Set<Vehicle> getVehicles() {
    return vehicles;
  }

  // Constructors
  public VehicleRegistry() {
    this.vehicles = new HashSet<>();
  }

  // Methods
  public void addVehicle(Vehicle vehicle) {
    this.vehicles.add(vehicle);
  }

  public void removeVehicle(Vehicle vehicle) {
    this.vehicles.remove(vehicle);
  }

  public boolean isRegistered(int VIN) {
    for (Vehicle vehicle : this.vehicles) {
      if (vehicle.getVIN() == VIN) {
        return true;
      }
    }
    return false;
  }

  public void printVehicles() {
    this.vehicles.forEach(System.out::println);
  }
}
