package isp.lab6.exercise2;

import org.junit.Test;
import org.junit.Assert;

public class TestExercise2 {
  @Test
  public void testAddVehicle() {
    VehicleRegistry vehicleRegistry = new VehicleRegistry();
    Vehicle.resetVINCounter();
    Vehicle vehicle1 = new Vehicle("AB-01-CD", "Audi", "A4", 2019);
    Vehicle.resetVINCounter();
    Vehicle vehicle2 = new Vehicle("BC-02-DE", "BMW", "X5", 2020);

    vehicleRegistry.addVehicle(vehicle1);

    Assert.assertTrue(vehicleRegistry.getVehicles().contains(vehicle1));
    Assert.assertTrue(vehicleRegistry.getVehicles().contains(vehicle2));
  }

  @Test
  public void testRemoveVehicle() {
    Vehicle.resetVINCounter();
    VehicleRegistry vehicleRegistry = new VehicleRegistry();
    Vehicle vehicle1 = new Vehicle("AB-01-CD", "Audi", "A4", 2019);

    vehicleRegistry.addVehicle(vehicle1);
    vehicleRegistry.removeVehicle(vehicle1);

    Assert.assertFalse(vehicleRegistry.getVehicles().contains(vehicle1));
  }

  @Test
  public void testIsRegistered() {
    Vehicle.resetVINCounter();
    VehicleRegistry vehicleRegistry = new VehicleRegistry();
    Vehicle vehicle1 = new Vehicle("AB-01-CD", "Audi", "A4", 2019);

    vehicleRegistry.addVehicle(vehicle1);

    Assert.assertTrue(vehicleRegistry.isRegistered(1));
    Assert.assertFalse(vehicleRegistry.isRegistered(2));
  }
}
