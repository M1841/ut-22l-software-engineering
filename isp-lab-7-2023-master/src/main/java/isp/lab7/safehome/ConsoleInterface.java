package isp.lab7.safehome;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleInterface {
  private static final DoorLockController controller = new DoorLockController(new HashMap<>(), new Door(DoorStatus.CLOSED));
  private static final Scanner scanner = new Scanner(System.in);

  public static void run() {
    boolean exit1 = false;
    while (!exit1) {
      System.out.println("1. Log in as Tenant");
      System.out.println("2. Log in as Admin");
      System.out.println("0. Exit");

      System.out.print("Choose an option: ");
      int option = scanner.nextInt();

      switch (option) {
        case 1 -> {
          System.out.print("Pin: ");
          String pin = scanner.next();
          try {
            DoorStatus status = controller.enterPin(pin);
            System.out.println("Door is now " + status);
          } catch (InvalidPinException err) {
            System.out.println("Invalid pin");
          } catch (TooManyAttemptsException err) {
            System.out.println("Too many attempts");
          }
        }
        case 2 -> {
          System.out.println("1. Add Tenant");
          System.out.println("2. Remove Tenant");
          System.out.println("3. Enter Pin");
          System.out.println("4. View Access Logs");
          System.out.println("0. Exit");
          System.out.print("Choose an option: ");

          option = scanner.nextInt();

          switch (option) {
            case 1 -> {
              System.out.print("Tenant Name: ");
              String tenantName = scanner.next();

              System.out.print("Pin: ");
              String pin = scanner.next();

              try {
                controller.addTenant(pin, tenantName);
                System.out.println("Tenant added successfully.");
              } catch (Exception err) {
                System.out.println("Tenant already exists");
              }
            }
            case 2 -> {
              System.out.print("Tenant Name: ");
              String tenantName = scanner.next();

              try {
                controller.removeTenant(tenantName);
                System.out.println("Tenant removed successfully.");
              } catch (Exception err) {
                System.out.println("Tenant not found");
              }
            }
            case 3 -> {
              System.out.print("Pin: ");
              String pin = scanner.next();
              try {
                DoorStatus status = controller.enterPin(pin);
                System.out.println("Door is now " + status);
              } catch (InvalidPinException err) {
                System.out.println("Invalid pin");
              } catch (TooManyAttemptsException err) {
                System.out.println("Too may attempts");
              }
            }
            case 4 -> System.out.println(controller.getAccessLogs());
            case 0 -> exit1 = true;
            default -> System.out.println("Invalid option. Please try again.");
          }
        }
        case 0 -> exit1 = true;
        default -> System.out.println("Invalid option. Please try again.");
      }


    }
  }
}