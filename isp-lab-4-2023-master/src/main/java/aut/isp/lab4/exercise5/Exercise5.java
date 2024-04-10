package aut.isp.lab4.exercise5;

public class Exercise5 {
    public static void main(String[] args) {
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
                heater
        );

        controller.checkTemperature();
        controller.checkWaterLevel();
        
    }
}
