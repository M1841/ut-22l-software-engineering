package isp.lab10.raceapp;

import javax.swing.*;

public class Leaderboard {
  private JFrame frame = new JFrame("Leaderboard");
  private int spot = 1;

  public void window_setup() {
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(300, 200);
    this.frame.setLayout(null);
    this.frame.setVisible(true);
  }

  public void addEntry(String name, long duration) {
    String text = String.format(
        "%d) %.2fs - %s\n",
        this.spot,
        duration / 1000f,
        name);
    JLabel entry = new JLabel(text);
    entry.setBounds(20, this.spot++ * 20, 200, 20);
    this.frame.add(entry);
    this.frame.revalidate();
    this.frame.repaint();
    this.frame.setVisible(true);
  }
}