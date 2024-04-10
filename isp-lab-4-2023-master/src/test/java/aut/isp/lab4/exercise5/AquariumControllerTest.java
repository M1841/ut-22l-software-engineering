package aut.isp.lab4.exercise5;

import org.junit.Assert;
import org.junit.Test;

public class AquariumControllerTest {
  @Test
  public void TestForTrue() {
    LevelSensor lvlSensor = new LevelSensor("ACME", "LS-1", "cm", 10.0f);
    TemperatureSensor tempSensor = new TemperatureSensor("ACME", "TS-1", "Celsius", 25.0f);
    Actuator alarm = new Alarm("ACME", "AL-1");
    Actuator heater = new Heater("ACME", "HT-1");
    FishFeeder feeder = new FishFeeder("ACME", "FF-1", 10);

    AquariumController controller = new AquariumController(
        feeder,
        "ACME",
        "AC-1",
        0.0f,
        0.0f,
        30,
        20.0f,
        lvlSensor,
        tempSensor,
        alarm,
        heater);

    controller.checkTemperature();
    controller.checkWaterLevel();

    Assert.assertTrue(alarm.getIsOn());
    Assert.assertTrue(heater.getIsOn());
  }

  @Test
  public void TestForFalse() {
    LevelSensor lvlSensor = new LevelSensor("ACME", "LS-1", "cm", 30.0f);
    TemperatureSensor tempSensor = new TemperatureSensor("ACME", "TS-1", "Celsius", 25.0f);
    Actuator alarm = new Alarm("ACME", "AL-1");
    Actuator heater = new Heater("ACME", "HT-1");
    FishFeeder feeder = new FishFeeder("ACME", "FF-1", 10);

    AquariumController controller = new AquariumController(
        feeder,
        "ACME",
        "AC-1",
        0.0f,
        0.0f,
        20,
        20.0f,
        lvlSensor,
        tempSensor,
        alarm,
        heater);

    controller.checkTemperature();
    controller.checkWaterLevel();

    Assert.assertFalse(alarm.getIsOn());
    Assert.assertFalse(heater.getIsOn());

  }
}
