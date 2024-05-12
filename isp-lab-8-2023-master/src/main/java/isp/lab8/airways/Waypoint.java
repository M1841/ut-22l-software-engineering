package isp.lab8.airways;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class Waypoint extends JsonSerializable<Waypoint> {
  private int index;
  private String name;
  private double latitude;
  private double longitude;
  private int altitude;

  public double distanceTo(Waypoint other) {
    int earthRadius = 6371;
    double latitudeDistance = Math.toRadians(other.latitude - this.latitude);
    double longitudeDistance = Math.toRadians(other.longitude - this.longitude);

    double result = Math.pow(Math.sin(longitudeDistance / 2), 2);
    result *= Math.cos(Math.toRadians(this.latitude) * Math.cos(Math.toRadians(other.latitude)));
    result += Math.pow(Math.sin(latitudeDistance / 2), 2);
    result = 2 * Math.atan2(Math.sqrt(result), Math.sqrt(1 - result));
    result *= earthRadius;

    return result;
  }

  public static Waypoint fromConsole(Scanner scanner, int index) {
    System.out.print("Waypoint name: ");
    String name = scanner.next();

    System.out.print("Latitude: ");
    double latitude = scanner.nextDouble();

    System.out.print("Longitude: ");
    double longitude = scanner.nextDouble();

    System.out.print("Altitude: ");
    int altitude = scanner.nextInt();

    return new Waypoint(index, name, latitude, longitude, altitude);
  }

  public static void remove(String directory, String name) throws IOException {
    Waypoint.fromJson(directory, name, Waypoint.class);

    Path waypointPath = Paths.get(FileSystem.getPath(directory, name, true));
    Files.delete(waypointPath);
  }

  @Override
  public String toString() {
    return "Waypoint [index=" + index + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
        + ", altitude=" + altitude + "]";
  }
}
