package aut.isp.lab4.exercise3;

public class AquariumController {
    // Attributes
    private final FishFeeder feeder;
    private final String manufacturer;
    private final String model;
    private float currentTime;
    private float feedingTime;

    // Constructors
    public AquariumController(
            FishFeeder feeder,
            String manufacturer,
            String model,
            float currentTime,
            float feedingTime
    ) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
    }
    public AquariumController() {
        this(null, null, null, 0, 0);
    }

    // Methods
    public float getCurrentTime() {
        return this.currentTime;
    }
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;

        if(this.currentTime == this.feedingTime) {
            this.feeder.feed();
        }
    }

    public float getFeedingTime() {
        return this.feedingTime;
    }
    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    @Override
    public String toString() {
        return "{\n\tmanufacturer = \"" + this.manufacturer +
                "\",\n\tmodel = \"" + this.model +
                "\",\n\tcurrentTime = " + this.currentTime +
                "\n}";
    }
}
