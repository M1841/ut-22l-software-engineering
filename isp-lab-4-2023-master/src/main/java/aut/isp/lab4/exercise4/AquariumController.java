package aut.isp.lab4.exercise4;

public class AquariumController {
    // Attributes
    private final FishFeeder feeder;
    private final String manufacturer;
    private final String model;
    private float currentTime;
    private float feedingTime;
    private float lightOnTime;
    private float lightOffTime;

    // Constructors
    public AquariumController(
            FishFeeder feeder,
            String manufacturer,
            String model,
            float currentTime,
            float feedingTime) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.lightOnTime = 0;
        this.lightOffTime = 0;
    }

    public AquariumController() {
        this(null, null, null, 0, 0);
    }

    // Methods
    public float getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime % 24;

        if (this.currentTime == this.feedingTime) {
            this.feeder.feed();
        }

        if (this.currentTime < 8) {
            this.lightOnTime = this.currentTime;
            this.lightOffTime = 0;
            System.out.println("The light is on");
        } else {
            this.lightOnTime = 7;
            this.lightOffTime = this.currentTime - 7;
            System.out.println("The light is off");
        }
    }

    public float getFeedingTime() {
        return this.feedingTime;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime % 24;
    }

    @Override
    public String toString() {
        return "{\n\tmanufacturer = \"" + this.manufacturer +
                "\",\n\tmodel = \"" + this.model +
                "\",\n\tcurrentTime = " + this.currentTime +
                "\n}";
    }
}
