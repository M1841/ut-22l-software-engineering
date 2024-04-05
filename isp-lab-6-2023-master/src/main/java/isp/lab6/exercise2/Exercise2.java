package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();
        Vehicle vehicle1 = new Vehicle("AB-01-CD", "Audi", "A4", 2019);
        Vehicle vehicle2 = new Vehicle("BC-02-DE", "BMW", "X5", 2020);
        Vehicle vehicle3 = new Vehicle("CD-03-EF", "Citroen", "C-Class", 2021);
        Vehicle vehicle4 = new Vehicle("DE-04-FG", "Volkswagen", "Golf", 2022);

        vehicleRegistry.addVehicle(vehicle1);
        vehicleRegistry.addVehicle(vehicle2);
        vehicleRegistry.addVehicle(vehicle3);
        vehicleRegistry.addVehicle(vehicle4);

        vehicleRegistry.printVehicles();

        System.out.println(
                "VIN 1 is"
                        + (vehicleRegistry.isRegistered(1) ? " " : " not ")
                        + "registered");
        System.out.println(
                "VIN 5 is"
                        + (vehicleRegistry.isRegistered(5) ? " " : " not ")
                        + "registered");

        vehicleRegistry.removeVehicle(vehicle3);
        vehicleRegistry.printVehicles();
    }
}
