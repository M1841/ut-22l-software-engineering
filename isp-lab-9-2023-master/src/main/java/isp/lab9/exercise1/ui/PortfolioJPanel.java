package isp.lab9.exercise1.ui;

import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

/**
 * todo: implement portfolio panel; for each owned stock add symbol, quantity,
 * price per unit, total price of the position
 * it should look similar to the 'Market' panel
 */
public class PortfolioJPanel extends JPanel {
  private StockMarketJFrame frame;

  public PortfolioJPanel(StockMarketJFrame frame) {
    this.frame = frame;
    initComponent();
  }

  private void initComponent() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JLabel funds = new JLabel("Available funds: $" + frame.getPortfolioService().getFunds().toPlainString());

    JTable table = new JTable();
    table.setModel(frame.getPortfolioService());
    JScrollPane scrollPane = new JScrollPane(table);

    JButton refreshButton = new JButton("Refresh");
    refreshButton.addActionListener(event -> refreshData(event));

    add(funds);
    add(scrollPane);
    add(refreshButton);
  }

  private void refreshData(ActionEvent event) {
    if (frame.getPortfolioService().getRowCount() >= 1) {
      try {
        frame.getPortfolioService()
            .refreshMarketData();
      } catch (IOException err) {
        JOptionPane.showMessageDialog(
            this,
            err.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);

        Logger.getLogger(StockMarketJFrame.class.getName())
            .log(Level.SEVERE, null, err);
      }
    }
  }
}
