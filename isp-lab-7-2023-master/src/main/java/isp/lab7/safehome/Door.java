package isp.lab7.safehome;

public class Door {
  // Attributes
  private DoorStatus status;

  // Getters & Setters
  public DoorStatus getStatus() {
    return this.status;
  }

  public void setStatus(DoorStatus status) {
    this.status = status;
  }

  // Constructors
  public Door(DoorStatus status) {
    this.status = status;
  }

  // Methods
  public void lockDoor() {
    this.status = DoorStatus.CLOSED;
  }

  public void unlockDoor() {
    this.status = DoorStatus.OPEN;
  }
}
