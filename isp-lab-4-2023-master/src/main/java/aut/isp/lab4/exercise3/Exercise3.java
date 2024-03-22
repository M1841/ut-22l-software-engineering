package aut.isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("ACME", "F500");
        fishFeeder.fillUp();

        AquariumController aquariumController = new AquariumController(
                fishFeeder, "ACME", "AC20", 9.28f, 9.30f
        );

        aquariumController.setCurrentTime(9.29f);
        aquariumController.setCurrentTime(9.30f);
    }
}
