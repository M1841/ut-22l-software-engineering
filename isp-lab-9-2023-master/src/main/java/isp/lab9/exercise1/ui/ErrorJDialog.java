package isp.lab9.exercise1.ui;

import javax.swing.*;

public class ErrorJDialog extends JDialog {
  public ErrorJDialog(String message, JFrame parentFrame) {
    this.setTitle("Error");
    this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    this.setLayout(null);
    this.setBounds(200, 200, 300, 200);

    JLabel errorLabel = new JLabel(message);
    errorLabel.setBounds(20, 20, 200, 20);
    this.add(errorLabel);

    JButton retryButton = new JButton("Retry");
    retryButton.setBounds(20, 70, 240, 20);
    this.add(retryButton);

    JButton exitButton = new JButton("Exit");
    exitButton.setBounds(20, 100, 240, 20);
    this.add(exitButton);

    retryButton.addActionListener(e -> {
      this.setVisible(false);
      parentFrame.setVisible(true);
    });

    exitButton.addActionListener(e -> {
      System.exit(0);
    });

    this.setVisible(true);
  }
}
