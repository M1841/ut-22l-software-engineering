package isp.lab10.raceapp;

import java.awt.*;
import javax.swing.*;

import java.util.HashSet;
import java.util.Set;

public class CarRace {
  private JFrame frame;
  private CarPanel panel;
  private Set<Car> threads = new HashSet<>();

  public CarRace(String[] cars, Leaderboard leaderboard) {
    this.frame = new JFrame("Car Race");
    this.panel = new CarPanel();

    for (String car : cars) {
      this.threads.add(new Car(car, this.panel, leaderboard));
    }
  }

  public void window_setup() {
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.getContentPane().add(this.panel);
    this.frame.pack();
    this.frame.setSize(500, 300);
    this.frame.setVisible(true);
  }

  public void start() {
    this.frame.setVisible(true);
    this.threads.forEach(thread -> thread.start());
  }

  public void join() {
    this.threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException err) {
        System.err.println(err);
      }
    });
  }
}

class Car extends Thread {
  private String name;
  private int distance = 0;
  private CarPanel carPanel;
  private long duration;
  private Leaderboard leaderboard;

  public Car(String name, CarPanel carPanel, Leaderboard leaderboard) {
    // set thread name;
    setName(name);
    this.name = name;
    this.carPanel = carPanel;
    this.leaderboard = leaderboard;
  }

  public void run() {
    long startTime = System.currentTimeMillis();
    while (distance < 400) {
      // simulate the car moving at a random speed
      int speed = (int) (Math.random() * 10) + 1;
      distance += speed;

      carPanel.updateCarPosition(name, distance);

      try {
        // pause for a moment to simulate the passage of time
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    this.duration = System.currentTimeMillis() - startTime;
    leaderboard.addEntry(name, this.duration);
  }
}

class CarPanel extends JPanel {
  private int[] carPositions;
  private String[] carNames;
  private Color[] carColors;

  public CarPanel() {
    carPositions = new int[4];
    carNames = new String[] { "Red car", "Blue car", "Green car", "Yellow car" };
    carColors = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < 4; i++) {
      int yPos = 50 + i * 50; // Vertical position of the car
      int xPos = carPositions[i]; // Horizontal position of the car
      int carSize = 30; // Size of the car

      g.setColor(carColors[i]);
      g.fillOval(xPos, yPos, carSize, carSize);
      g.setColor(Color.BLACK);
      g.drawString(carNames[i], xPos, yPos - 5);
    }
  }

  public void updateCarPosition(String carName, int distance) {
    int carIndex = getCarIndex(carName);
    if (carIndex != -1) {
      carPositions[carIndex] = distance;
      repaint();
    }
  }

  private int getCarIndex(String carName) {
    for (int i = 0; i < 4; i++) {
      if (carNames[i].equals(carName)) {
        return i;
      }
    }
    return -1;
  }
}
