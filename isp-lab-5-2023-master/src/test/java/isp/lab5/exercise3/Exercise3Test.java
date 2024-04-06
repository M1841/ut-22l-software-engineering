package isp.lab5.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class Exercise3Test {
  @Test
  public void testBehavior() {
    Sensor[] sensors = new Sensor[10];
    sensors[0] = new TemperatureSensor("Room 1", "Temperature Sensor 1", 25.0);
    sensors[1] = new TemperatureSensor("Room 2", "Temperature Sensor 2", 26.0);
    sensors[2] = new TemperatureSensor("Room 3", "Temperature Sensor 3", 27.0);
    sensors[3] = new TemperatureSensor("Room 4", "Temperature Sensor 4", 28.0);
    sensors[4] = new TemperatureSensor("Room 5", "Temperature Sensor 5", 29.0);
    sensors[5] = new PressureSensor("Room 6", "Pressure Sensor 1", 1000.0);
    sensors[6] = new PressureSensor("Room 7", "Pressure Sensor 2", 1001.0);
    sensors[7] = new PressureSensor("Room 8", "Pressure Sensor 3", 1002.0);
    sensors[8] = new PressureSensor("Room 9", "Pressure Sensor 4", 1003.0);
    sensors[9] = new PressureSensor("Room 10", "Pressure Sensor 5", 1004.0);

    MonitoringService monitoringService = new MonitoringService(sensors);

    Assert.assertEquals(27.0, monitoringService.getAverageTemperatureSensors(), 0.0);
    Assert.assertEquals(514.5, monitoringService.getAverageAllSensors(), 0.0);
  }
}
