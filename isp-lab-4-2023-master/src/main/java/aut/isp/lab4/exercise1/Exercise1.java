package aut.isp.lab4.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        AquariumController aquariumController = new AquariumController(
                "ACME", "AC20", 8.48f
        );
        aquariumController.setCurrentTime(8.49f);
        System.out.println(aquariumController);
    }
}
