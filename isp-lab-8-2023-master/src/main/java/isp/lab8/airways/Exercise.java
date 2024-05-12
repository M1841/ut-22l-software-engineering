package isp.lab8.airways;

import java.io.*;
import java.util.*;

public class Exercise {
  public static void main(String[] args) {
    int option = 0;

    final Scanner scanner = new Scanner(System.in);

    String appDirectory = FileSystem.getDirectory(System.getenv("LOCALAPPDATA") + "\\airways");
    String routesDirectory = FileSystem.getDirectory(appDirectory + "\\routes");

    do {
      System.out.println("1 - Add a route");
      System.out.println("2 - View a route");
      System.out.println("3 - Delete a route");
      System.out.println("4 - List all routes");
      System.out.println("0 - Exit");

      System.out.print("Choose an option: ");
      option = scanner.nextInt();

      switch (option) {
        case 1 -> {
          Route route = Route.fromConsole(scanner);

          try {
            route.toDirectory(routesDirectory);
            System.out.println("Route was added successfully");
          } catch (IOException err) {
            System.err.println(err);
          }
        }
        case 2 -> {
          System.out.print("Route name: ");
          String name = scanner.next();

          try {
            Route route = Route.fromDirectory(routesDirectory, name);
            System.out.println(route);
          } catch (IOException err) {
            System.err.println(err);
          } catch (NullPointerException err) {
            System.out.println("Couldn't find route");
          }
        }
        case 3 -> {
          System.out.print("Route name: ");
          String name = scanner.next();
          try {
            Route.remove(routesDirectory, name);
            System.out.println("Route was deleted successfully");
          } catch (IOException err) {
            System.err.println(err);
          } catch (NullPointerException err) {
            System.out.println("Couldn't find route");
          }
        }
        case 4 -> {
          try {
            ArrayList<Route> routes = Route.allFromDirectory(routesDirectory);
            routes.forEach(route -> {
              System.out.println(route);
            });
          } catch (Exception err) {
            System.err.println(err);
          }
        }
        case 0 -> System.out.println("Exiting");
        default -> System.out.println("Invalid option, try again");
      }
    } while (option != 0);

    scanner.close();
  }
}
