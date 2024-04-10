package aut.isp.lab4.exercise5;

public class AquariumController {
    // Attributes
    private final FishFeeder feeder;
    private final String manufacturer;
    private final String model;
    private float currentTime;
    private float feedingTime;
    private int presetTemeperature;
    private float presetLevel;
    private LevelSensor lvlSensor;
    private TemperatureSensor tempSensor;
    private Actuator alarm;
    private Actuator heater;

    // Getters & Setters
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    // Constructors
    public AquariumController(
            FishFeeder feeder,
            String manufacturer,
            String model,
            float currentTime,
            float feedingTime,
            int presetTemeperature,
            float presetLevel,
            LevelSensor lvlSensor,
            TemperatureSensor tempSensor,
            Actuator alarm,
            Actuator heater) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.presetTemeperature = presetTemeperature;
        this.presetLevel = presetLevel;
        this.lvlSensor = lvlSensor;
        this.tempSensor = tempSensor;
        this.alarm = alarm;
        this.heater = heater;
    }

    // Methods
    public void checkTemperature() {
        if (this.tempSensor.getValue() < this.presetTemeperature) {
            this.heater.turnOn();
        } else {
            this.heater.turnOff();
        }
    }

    public void checkWaterLevel() {
        if (this.lvlSensor.getValue() < this.presetLevel) {
            this.alarm.turnOn();
        } else {
            this.alarm.turnOff();
        }
    }

    @Override
    public String toString() {
        return "{\n\tmanufacturer = \"" + this.manufacturer +
                "\",\n\tmodel = \"" + this.model +
                "\",\n\tcurrentTime = " + this.currentTime +
                "\n}";
    }
}
