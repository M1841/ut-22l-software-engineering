package isp.lab10.raceapp;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Timer extends Thread {
  private JFrame frame = new JFrame("Timer");
  private long value = 0;
  private boolean isRunning = true;

  public void window_setup() {
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(200, 100);
    this.frame.setLayout(null);

    JLabel text = new JLabel("Timer: " + this.value);
    text.setBounds(20, 20, 200, 20);
    this.frame.add(text);
    this.frame.setVisible(true);
  }

  public void run() {
    try {
      while (isRunning) {
        this.value++;
        Thread.sleep(10);
      }
    } catch (InterruptedException err) {
      System.err.println(err);
    }
  }

  public void stopTimer() {
    this.isRunning = false;
  }
}