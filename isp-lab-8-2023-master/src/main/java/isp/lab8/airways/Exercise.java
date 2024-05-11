package isp.lab8.airways;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Exercise {
  public static void main(String[] args) {
    int option = 0;

    final Scanner scanner = new Scanner(System.in);

    String appDirectory = getDirectory(System.getenv("LOCALAPPDATA") + "\\airways");
    String routesDirectory = getDirectory(appDirectory + "\\routes");

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
            route.toJson(routesDirectory);
            System.out.println("Route was added successfully");
          } catch (IOException err) {
            System.err.println(err);
          }
        }
        case 2 -> {
          System.out.print("Route name: ");
          String name = scanner.next();
          try {
            Route route = Route.fromJson(routesDirectory, name);
            System.out.println(route);
          } catch (IOException err) {
            System.err.println(err);
          }
        }
        case 3 -> {
          System.out.print("Route name: ");
          String name = scanner.next();
          try {
            Route.fromJson(routesDirectory, name);

            Path routePath = Paths.get(String.format(
                "%s\\%s.json",
                routesDirectory, name));

            Files.delete(routePath);
            System.out.println("Route was added successfully");
          } catch (IOException err) {
            System.err.println(err);
          }
        }
      }
    } while (option != 0);

    scanner.close();

  }

  private static String getDirectory(String path) {
    File directory = new File(path);

    if (!directory.isDirectory()) {
      directory.mkdir();
    }

    return path;
  }
}
