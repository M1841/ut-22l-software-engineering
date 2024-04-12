package isp.lab7.safehome;

public class AccessKey {
  // Attributes
  private String pin;

  // Getters & Setters
  public String getPin() {
    return this.pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  // Constructors
  public AccessKey(String pin) {
    this.pin = pin;
  }
}
