package isp.lab3.exercise3;

public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    private static int count = 0;

    public static void printCount() {
        System.out.println("# of created vehicles: " + count);
    }

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        count++;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) speed %d fuel type %c",
                this.model, this.type, this.speed, this.fuelType);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }
}
