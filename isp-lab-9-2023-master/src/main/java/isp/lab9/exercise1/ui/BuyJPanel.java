package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuyJPanel extends JPanel {
  private StockMarketJFrame mainFrame;
  private JTextField availableFundsTextField;

  public BuyJPanel(StockMarketJFrame mainFrame) {
    this.mainFrame = mainFrame;
    initComponents();
  }

  private void initComponents() {
    setLayout(new GridLayout(2, 2));

    JPanel buyPanel = new JPanel();
    buyPanel.setLayout(new GridLayout(10, 2));

    JLabel availableFundsLabel = new JLabel("Available funds:");
    availableFundsTextField = new JTextField(
        "$" + mainFrame.getPortfolioService().getFunds().toPlainString());
    availableFundsTextField.setEditable(false);

    JLabel symbolLabel = new JLabel("Symbol:");
    JComboBox<String> symbolComboBox = new JComboBox<>();
    symbolComboBox.setModel(new DefaultComboBoxModel<>(mainFrame.getMarketService().getSymbols()));

    JLabel quantityLabel = new JLabel("Quantity:");
    JTextField quantityTextField = new JTextField();

    JLabel costLabel = new JLabel("Total cost:");
    JTextField costTextField = new JTextField();
    costTextField.setEditable(false);

    JButton buyButton = new JButton("Buy");
    buyButton.addActionListener(event -> buyShares(symbolComboBox, quantityTextField));

    JButton costButton = new JButton("Get cost");
    costButton
        .addActionListener(e -> calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField));

    buyPanel.add(availableFundsLabel);
    buyPanel.add(availableFundsTextField);
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(symbolLabel);
    buyPanel.add(symbolComboBox);
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(quantityLabel);
    buyPanel.add(quantityTextField);
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(costLabel);
    buyPanel.add(costTextField);
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(new JPanel()); // empty cell in the grid
    buyPanel.add(costButton);
    buyPanel.add(buyButton);
    add(buyPanel);
    add(new JPanel()); // empty cell in the grid
    add(new JPanel()); // empty cell in the grid
    add(new JPanel()); // empty cell in the grid

  }

  /**
   * Calculates the total transaction cost
   */
  private void calculateTotalCostActionPerformed(JComboBox<String> symbolComboBox,
      JTextField quantityTextField,
      JTextField totalCostTextField) {
    try {
      String symbol = (String) symbolComboBox.getSelectedItem();
      BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

      try {
        int quantity = Integer.parseInt(quantityTextField.getText());
        DecimalFormat formatter = new DecimalFormat("#,##0.##");
        totalCostTextField.setText(
            formatter.format(stockPrice.multiply(new BigDecimal(quantity))));
      } catch (NumberFormatException e) {
        totalCostTextField.setText("Invalid quantity value!");
      }
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this,
          ex.getMessage(),
          "Error",
          JOptionPane.ERROR_MESSAGE);
      Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void buyShares(JComboBox<String> symbolComboBox, JTextField quantityTextField) {
    String symbol = (String) symbolComboBox.getSelectedItem();

    try {
      int quantity = Integer.parseInt(quantityTextField.getText());
      if (mainFrame.getPortfolioService().getFunds().compareTo(BigDecimal.valueOf(quantity)) > 0) {
        try {
          mainFrame.getPortfolioService().buyShares(symbol, quantity, mainFrame);
        } catch (IOException err) {
          quantityTextField.setText("Server error! Try again later");
          System.err.println(err);
        }
      } else {
        quantityTextField.setText("Insufficient funds!");
      }
    } catch (NumberFormatException err) {
      quantityTextField.setText("Invalid value!");
    }
  }

  public JTextField getAvailableFundsTextField() {
    return availableFundsTextField;
  }
}
