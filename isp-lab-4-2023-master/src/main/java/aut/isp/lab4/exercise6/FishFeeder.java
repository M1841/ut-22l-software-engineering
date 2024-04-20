package aut.isp.lab4.exercise6;

public class FishFeeder {
    // Attributes
    private final String manufacturer;
    private final String model;
    private int meals;

    // Constructors
    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public FishFeeder(String manufacturer, String model) {
        this(manufacturer, model, 0);
    }

    public FishFeeder() {
        this(null, null, 0);
    }

    // Methods
    public int getMeals() {
        return this.meals;
    }

    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("The fish are fed");
        } else
            System.out.println("Feeder is empty");
    }

    public void fillUp() {
        if (meals < 14) {
            meals++;
            System.out.println("Feeder refilled");
        } else
            System.out.println("Feeder is full");
    }

    @Override
    public String toString() {
        return "{\n\tmanufacturer = \"" + this.manufacturer +
                "\",\n\tmodel = \"" + this.model +
                "\",\n\tmeals = " + this.meals +
                "\n}";
    }
}
