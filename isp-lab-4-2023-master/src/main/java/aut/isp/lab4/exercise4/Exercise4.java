package aut.isp.lab4.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("ACME", "F500");
        fishFeeder.fillUp();

        AquariumController aquariumController = new AquariumController(
                fishFeeder, "ACME", "AC20", 2.0f, 5.0f);

        aquariumController.setCurrentTime(5.0f);
        aquariumController.setCurrentTime(8.0f);

    }
}
