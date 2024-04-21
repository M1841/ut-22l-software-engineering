package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ConsoleInterface {
  private static final OnlineStore onlineStore = new OnlineStore(new ArrayList<>(),
      new HashMap<>());
  private static final LoginSystem loginSystem = new LoginSystem(new HashSet<>(), onlineStore);
  private static final Scanner scanner = new Scanner(System.in);
  private static String loggedInUser;

  public static void run() {
    boolean exit_1 = false;

    while (!exit_1) {
      if (loggedInUser == null) {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();

        switch (option) {
          case 1 -> {
            System.out.print("Username: ");
            String username = scanner.next();

            System.out.print("Password: ");
            String password = scanner.next();

            loginSystem.register(username, password);

            System.out.println("User registered successfully");
          }
          case 2 -> {
            System.out.print("Username: ");
            String username = scanner.next();

            System.out.print("Password: ");
            String password = scanner.next();

            if (loginSystem.login(username, password)) {
              System.out.println("Login successful");
              loggedInUser = username;
            } else {
              System.out.println("Invalid credentials");
            }
          }
          case 0 -> exit_1 = true;
          default -> System.out.println("Invalid option. Please try again.");
        }
      } else {
        boolean exit_2 = false;
        while (!exit_2) {
          System.out.println("1. Logout");
          System.out.println("2. Add to cart");
          System.out.println("3. Checkout");
          System.out.print("Choose an option: ");

          int option = scanner.nextInt();

          switch (option) {
            case 1 -> {
              if (loginSystem.logout(loggedInUser)) {
                System.out.println("Logout successful.");
                loggedInUser = null;
              } else {
                System.out.println("Logout failed.");
              }
              exit_2 = true;
            }
            case 2 -> {
              System.out.print("Product Name: ");
              String productName = scanner.next();

              System.out.print("Price: ");
              double productPrice = scanner.nextDouble();

              System.out.print("Quantity: ");
              int quantity = scanner.nextInt();

              Product product = new Product(productName, productPrice);

              onlineStore.addToCart(loggedInUser, product, quantity);

              System.out.println("Product added to cart.");
            }
            case 3 -> System.out.println(onlineStore.checkout(loggedInUser));
            default -> System.out.println("Invalid option. Please try again.");
          }
        }
      }
    }
  }
}