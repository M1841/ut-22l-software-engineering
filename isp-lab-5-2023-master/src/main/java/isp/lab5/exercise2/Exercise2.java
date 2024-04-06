package isp.lab5.exercise2;

public class Exercise2 {
  public static void main(String[] args) {
    Chargeable laptop = new Laptop();
    Chargeable phone = new SmartPhone();
    Chargeable watch = new SmartWatch();

    int oneHour = 60;

    laptop.charge(oneHour);
    phone.charge(oneHour);
    watch.charge(oneHour);

    System.out.println("Laptop battery level after 1 hour: " + laptop.getBatteryLevel());
    System.out.println("Phone battery level after 1 hour: " + phone.getBatteryLevel());
    System.out.println("Watch battery level after 1 hour: " + watch.getBatteryLevel());
  }
}
