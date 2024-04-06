package isp.lab5.exercise2;

public class SmartWatch implements Chargeable {
  // Attributes
  private int batteryLevel;

  // Methods
  @Override
  public int getBatteryLevel() {
    return batteryLevel;
  }

  @Override
  public void charge(int durationInMinutes) {
    int newLevel = batteryLevel + 2 * durationInMinutes;
    batteryLevel = Math.min(newLevel, 100);
  }
}
