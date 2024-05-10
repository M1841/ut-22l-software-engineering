package isp.lab10.raceapp;

import java.awt.*;
import javax.swing.*;

public class Semaphore {
  private JFrame frame;
  private SemaphorePanel panel;
  private SemaphoreThread thread;

  public Semaphore() {
    this.frame = new JFrame("Semaphore");
    this.panel = new SemaphorePanel();
    this.thread = new SemaphoreThread(this.panel);
  }

  public void window_setup() {
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.getContentPane().add(this.panel);
    this.frame.pack();
    this.frame.setVisible(true);
  }

  public void start_and_wait() throws InterruptedException {
    this.thread.start();
    this.thread.join();
  }

  public void set_visible() {
    this.frame.setVisible(true);
  }
}

class SemaphoreThread extends Thread {
  private SemaphorePanel semaphorePanel;

  public SemaphoreThread(SemaphorePanel semaphorePanel) {
    this.semaphorePanel = semaphorePanel;
  }

  public void run() {
    try {
      semaphorePanel.setGray();
      Thread.sleep((int) (Math.random() * 5000) + 2000);

      semaphorePanel.setYellow();
      Thread.sleep((int) (Math.random() * 5000) + 2000);

      semaphorePanel.setGreen();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class SemaphorePanel extends JPanel {
  private Color color;

  public SemaphorePanel() {
    setPreferredSize(new Dimension(100, 300));
    color = Color.GRAY;
  }

  public void setGray() {
    color = Color.GRAY;
    repaint();
  }

  public void setYellow() {
    color = Color.YELLOW;
    repaint();
  }

  public void setGreen() {
    color = Color.GREEN;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int diameter = Math.min(getWidth(), getHeight()) - 20;
    int x = (getWidth() - diameter) / 2;
    int y = (getHeight() - diameter) / 2;

    g.setColor(color);
    g.fillOval(x, y, diameter, diameter);

    g.setColor(Color.BLACK);
    g.drawOval(x, y, diameter, diameter);
  }
}
