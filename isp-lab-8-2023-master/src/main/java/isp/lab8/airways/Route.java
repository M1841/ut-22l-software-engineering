package isp.lab8.airways;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class Route extends JsonSerializable<Route> {
  private String name;
  private ArrayList<Waypoint> waypoints;

  public double totalDistance() {
    return IntStream.range(0, waypoints.size() - 1)
        .mapToDouble(i -> waypoints.get(i).distanceTo(waypoints.get(i + 1)))
        .sum();
  }

  public static Route fromConsole(Scanner scanner) {
    System.out.print("Route name: ");
    String name = scanner.next();

    ArrayList<Waypoint> waypoints = new ArrayList<>();
    boolean isAddingWaypoint = true;
    int index = 0;

    while (isAddingWaypoint) {
      System.out.print("Add a waypoint? (1 - Yes / 0 - No): ");
      int option = scanner.nextInt();

      if (option == 1) {
        waypoints.add(Waypoint.fromConsole(scanner, index++));
      } else {
        isAddingWaypoint = false;
      }
    }

    return new Route(name, waypoints);
  }

  public static Route fromDirectory(String directory, String name) throws IOException {
    ArrayList<Waypoint> waypoints = new ArrayList<>();

    for (String waypointName : FileSystem.getFilesInDirectory(directory + "\\" + name)) {
      waypointName = waypointName.split("[.]", 0)[0];
      waypoints.add(Waypoint.fromJson(directory + "\\" + name, waypointName, Waypoint.class));
    }
    waypoints.sort((a, b) -> a.getIndex() - b.getIndex());

    return new Route(name, waypoints);
  }

  public void toDirectory(String directory) throws IOException {
    String routeDirectory = FileSystem.getDirectory(directory + "\\" + this.name);

    for (Waypoint waypoint : this.waypoints) {
      waypoint.toJson(routeDirectory, waypoint.getName());
    }
  }

  public static void remove(String directory, String name) throws IOException {
    Route route = Route.fromDirectory(directory, name);
    String routeDirectory = FileSystem.getPath(directory, name, false);

    for (Waypoint waypoint : route.waypoints) {
      Waypoint.remove(routeDirectory, waypoint.getName());
    }

    Path routePath = Paths.get(routeDirectory);
    Files.delete(routePath);
  }

  public static ArrayList<Route> allFromDirectory(String directory) throws IOException {
    ArrayList<Route> routes = new ArrayList<>();

    for (String routeName : FileSystem.getFilesInDirectory(directory)) {
      routes.add(Route.fromDirectory(directory, routeName));
    }

    return routes;
  }

  @Override
  public String toString() {
    return "Route [name=" + name + ", waypoints=" + waypoints + ", totalDistance()=" + totalDistance() + "]";
  }
}
