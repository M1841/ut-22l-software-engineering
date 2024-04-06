package isp.lab5.exercise2;

public class Laptop implements Chargeable {
  // Attributes
  private int batteryLevel;

  // Methods
  @Override
  public int getBatteryLevel() {
    return batteryLevel;
  }

  @Override
  public void charge(int durationInMinutes) {
    int newLevel = batteryLevel + (int) Math.round(0.5 * durationInMinutes);
    batteryLevel = Math.min(newLevel, 100);
  }
}
