package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Dacia", "Logan", 150, 'B');
        Vehicle v2 = new Vehicle("Tesla", "S", 200, 'E');

        System.out.println("Vehicles are " + (v1.equals(v2) ? "" : "not ") + "equal");

        Vehicle.printCount();
    }
}
