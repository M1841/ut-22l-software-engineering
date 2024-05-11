package isp.lab8.airways;

import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class Route {
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

  public static Route fromJson(String directory, String name) throws IOException {
    String path = String.format(
        "%s\\%s.json",
        directory, name);

    String jsonContent = FileReader.readAllLines(path).stream().collect(Collectors.joining("\n"));

    ObjectMapper objectMapper = new ObjectMapper();

    return objectMapper.readValue(jsonContent, Route.class);
  }

  public void toJson(String directory) throws IOException {
    String path = String.format(
        "%s\\%s.json",
        directory, this.name);

    FileWriter fileWriter = new FileWriter(path);
    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.writeValue(fileWriter, this);
  }

  @Override
  public String toString() {
    return "Route [name=" + name + ", waypoints=" + waypoints + ", totalDistance()=" + totalDistance() + "]";
  }
}
