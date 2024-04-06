package isp.lab5.exercise3;

public class MonitoringService {
  // Attributes
  private Sensor[] sensors = new Sensor[10];

  // Constructors
  public MonitoringService(Sensor[] sensors) {
    this.sensors = sensors;
  }

  // Methods
  public double getAverageTemperatureSensors() {
    double sum = 0;
    int count = 0;

    for (Sensor sensor : sensors) {
      if (sensor instanceof TemperatureSensor) {
        sum += sensor.getCharacteristic();
        count++;
      }
    }

    return sum / count;
  }

  public double getAverageAllSensors() {
    double sum = 0;
    int count = 0;

    for (Sensor sensor : sensors) {
      sum += sensor.getCharacteristic();
      count++;
    }

    return sum / count;
  }
}
