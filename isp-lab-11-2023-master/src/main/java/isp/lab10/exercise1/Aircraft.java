package isp.lab10.exercise1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aircraft extends Thread {
  private String id;
  private int altitude;
  private CommandType typeToWaitFor;
  private Object lock;

  public Aircraft(String id) {
    this.id = id;
    this.lock = id;
  }

  public void receiveCommand(AtcCommand command) {
    if (this.typeToWaitFor != null && this.typeToWaitFor.equals(command.type)) {
      if (command instanceof TakeoffCommand) {
        this.altitude = ((TakeoffCommand) command).getAltitude();
      }

      this.typeToWaitFor = null;

      synchronized (lock) {
        lock.notify();
      }
    } else {
      System.out.println("#" + id + " can't currently execute command " + command.type);
    }
  }

  public void run() throws RuntimeException {
    System.out.println("#" + this.id + " On Stand");
    System.out.print("$ ");
    waitForCommand(CommandType.TAKEOFF_CMD);

    System.out.println("\n#" + this.id + " Taxing");
    System.out.print("$ ");
    waitSeconds(10);

    System.out.println("\n#" + this.id + " Taking Off");
    System.out.print("$ ");
    waitSeconds(5);

    System.out.println("\n#" + this.id + " Ascending");
    System.out.print("$ ");
    waitSeconds(10 * altitude * 1000);
    // waitSeconds(10 * altitude);

    System.out.println("\n#" + this.id + " Cruising");
    System.out.print("$ ");
    LocalDateTime startTime = LocalDateTime.now();
    waitForCommand(CommandType.LAND_CMD);

    LocalDateTime endTime = LocalDateTime.now();
    System.out.println("\n#" + this.id + " Cruised for " + startTime.until(endTime, ChronoUnit.SECONDS) + "s");
    System.out.println("#" + this.id + " Descending");
    System.out.print("$ ");
    waitSeconds(10 * altitude * 1000);
    // waitSeconds(10 * altitude);

    System.out.println("\n#" + this.id + " Landed");
    this.altitude = 0;
    System.out.print("$ ");
  }

  public void waitForCommand(CommandType command) throws RuntimeException {
    synchronized (lock) {
      try {
        this.typeToWaitFor = command;
        lock.wait();
      } catch (InterruptedException err) {
        throw new RuntimeException(err);
      }
    }
  }

  public void waitSeconds(int seconds) throws RuntimeException {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException err) {
      throw new RuntimeException(err);
    }
  }

  @Override
  public String toString() {
    return "#" + id + " at " + altitude + "m";
  }
}
