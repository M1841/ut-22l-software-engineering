package aut.isp.lab4.exercise6;

import org.junit.Assert;
import org.junit.Test;

public class AquariumControllerTest {
    @Test
    public void TestForNoChange() {
        PHSensor phSensor = new PHSensor("ACME", "PS-1", "Logarithmic Units", 7.0f);
        Actuator alarm = new Alarm("ACME", "AL-1");
        Actuator pump = new Pump("ACME", "PM-1");

        AquariumController controller = new AquariumController(
                null,
                "ACME",
                "AC-1",
                0.0f,
                0.0f,
                30,
                20.0f,
                7.0f,
                null,
                null,
                phSensor,
                alarm,
                null,
                pump);

        controller.checkPH();

        Assert.assertFalse(alarm.getIsOn());
        Assert.assertFalse(pump.getIsOn());
    }

    @Test
    public void TestForSmallChange() {
        PHSensor phSensor = new PHSensor("ACME", "PS-1", "Logarithmic Units", 7.1f);
        Actuator alarm = new Alarm("ACME", "AL-1");
        Actuator pump = new Pump("ACME", "PM-1");

        AquariumController controller = new AquariumController(
                null,
                "ACME",
                "AC-1",
                0.0f,
                0.0f,
                30,
                20.0f,
                7.0f,
                null,
                null,
                phSensor,
                alarm,
                null,
                pump);

        controller.checkPH();

        Assert.assertFalse(alarm.getIsOn());
        Assert.assertTrue(pump.getIsOn());
    }

    @Test
    public void TestForBigChange() {
        PHSensor phSensor = new PHSensor("ACME", "PS-1", "Logarithmic Units", 9.0f);
        Actuator alarm = new Alarm("ACME", "AL-1");
        Actuator pump = new Pump("ACME", "PM-1");

        AquariumController controller = new AquariumController(
                null,
                "ACME",
                "AC-1",
                0.0f,
                0.0f,
                30,
                20.0f,
                7.0f,
                null,
                null,
                phSensor,
                alarm,
                null,
                pump);

        controller.checkPH();

        Assert.assertTrue(alarm.getIsOn());
        Assert.assertFalse(pump.getIsOn());
    }
}
