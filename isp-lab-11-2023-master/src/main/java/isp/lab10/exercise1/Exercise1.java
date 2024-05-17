package isp.lab10.exercise1;

import java.util.Scanner;

public class Exercise1 {
  static DummyAircraft dummyAircraft = null;

  public static void main(String[] args) {
    ATC atc = new ATC();
    Scanner scanner = new Scanner(System.in);
    boolean is_running = true;

    while (is_running) {
      System.out.print("$ ");

      String rawCommand = scanner.next();

      switch (rawCommand) {
        case "add" -> {
          String aircraftId = scanner.next();

          atc.addAircraft(aircraftId);
        }
        case "takeoff" -> {
          String aircraftId = scanner.next();
          int altitude = scanner.nextInt();

          AtcCommand command = new TakeoffCommand(aircraftId, altitude);
          atc.sendCommand(command);
        }
        case "land" -> {
          String aircraftId = scanner.next();

          AtcCommand command = new LandCommand(aircraftId);
          atc.sendCommand(command);
        }
        case "list" -> {
          atc.showAircrafts();
        }
        case "exit" -> {
          System.out.println("Exiting");
          is_running = false;
        }
        case "help" -> {
          System.out.println("Available commands:");
          System.out.println("`add <id>` - add an aircraft with a given id");
          System.out.println("`exit` - leave out of this menu");
          System.out.println("`help` - display a list of all available commands");
          System.out.println("`land <id>` - send aircraft #<id> a request to land");
          System.out.println("`list` - display a list of all the registered aircrafts and their altitude");
          System.out.println(
              "`takeoff <id> <altitude>` - send aircraft #<id> a request to take off and cruise at <altitude> meters high");
        }
        default -> {
          System.out.println("Invalid command! Run `help` to see available commands");
        }
      }
    }

    scanner.close();
  }
}
