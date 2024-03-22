package aut.isp.lab4.exercise1;

public class AquariumController {
    // Attributes
    private final String manufacturer;
    private final String model;
    private float currentTime;

    // Constructors
    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }
    public AquariumController() {
        this(null, null, 0);
    }

    // Methods
    public float getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "{\n\tmanufacturer = \"" + this.manufacturer +
                "\",\n\tmodel = \"" + this.model +
                "\",\n\tcurrentTime = " + this.currentTime +
                "\n}";
    }
}
