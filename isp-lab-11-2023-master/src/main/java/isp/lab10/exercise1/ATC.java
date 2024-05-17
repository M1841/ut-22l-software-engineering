package isp.lab10.exercise1;

import java.util.HashMap;

public class ATC {
  HashMap<String, Aircraft> aircrafts = new HashMap<>();

  public void addAircraft(String id) {
    System.out.println("Aircraft #" + id + " added");

    Aircraft aircraft = new Aircraft(id);
    aircraft.start();

    aircrafts.put(id, aircraft);
  }

  public void sendCommand(AtcCommand command) {
    System.out.println("Aircraft #" + command.aircraftId + " received command " + command.getType());

    aircrafts.get(command.getAircraftId()).receiveCommand(command);
  }

  public void showAircrafts() {
    System.out.println("Aircrafts:");

    aircrafts.forEach((id, aircraft) -> {
      System.out.println(aircraft);
    });
  }
}

class AtcCommand {
  protected CommandType type;
  protected String aircraftId;

  public CommandType getType() {
    return this.type;
  }

  public String getAircraftId() {
    return this.aircraftId;
  }
}

class TakeoffCommand extends AtcCommand {
  private int altitude;

  public TakeoffCommand(String aircraftId, int altitude) {
    this.type = CommandType.TAKEOFF_CMD;
    this.aircraftId = aircraftId;
    this.altitude = altitude;
  }

  public int getAltitude() {
    return this.altitude;
  }
}

class LandCommand extends AtcCommand {
  public LandCommand(String aircraftId) {
    this.type = CommandType.LAND_CMD;
    this.aircraftId = aircraftId;
  }
}

enum CommandType {
  TAKEOFF_CMD,
  LAND_CMD
}
