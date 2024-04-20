package aut.isp.lab4.exercise6;

public class AquariumController {
    // Attributes
    private final FishFeeder feeder;
    private final String manufacturer;
    private final String model;
    private final int presetTemperature;
    private final float presetLevel;
    private final float presetPH;
    private final LevelSensor lvlSensor;
    private final TemperatureSensor tempSensor;
    private final PHSensor phSensor;
    private final Actuator alarm;
    private final Actuator heater;
    private final Actuator pump;
    private float currentTime;
    private float feedingTime;

    // Constructors
    public AquariumController(
            FishFeeder feeder,
            String manufacturer,
            String model,
            float currentTime,
            float feedingTime,
            int presetTemperature,
            float presetLevel,
            float presetPH,
            LevelSensor lvlSensor,
            TemperatureSensor tempSensor,
            PHSensor phSensor,
            Actuator alarm,
            Actuator heater,
            Actuator pump) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.presetPH = presetPH;
        this.lvlSensor = lvlSensor;
        this.tempSensor = tempSensor;
        this.phSensor = phSensor;
        this.alarm = alarm;
        this.heater = heater;
        this.pump = pump;
    }

    // Getters & Setters
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    // Methods
    public void checkTemperature() {
        if (this.tempSensor.getValue() < this.presetTemperature) {
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

    public void checkPH() {
        if (this.phSensor.getValue() / this.presetPH > 1 || this.presetPH / this.phSensor.getValue() > 1) {
            if (this.phSensor.getValue() / this.presetPH > 1.25 || this.presetPH / this.phSensor.getValue() > 1.25) {
                this.alarm.turnOn();
                this.pump.turnOff();
            } else {
                this.alarm.turnOff();
                this.pump.turnOn();
            }
        } else {
            this.alarm.turnOff();
            this.pump.turnOff();
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
