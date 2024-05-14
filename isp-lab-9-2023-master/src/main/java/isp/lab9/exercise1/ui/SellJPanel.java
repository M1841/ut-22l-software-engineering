package isp.lab9.exercise1.ui;

import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.*;

public class SellJPanel extends JPanel {
  private StockMarketJFrame frame;
  private JTextField fundsField;
  private JComboBox<String> symbolSelect = new JComboBox<>();

  public SellJPanel(StockMarketJFrame frame) {
    this.frame = frame;
    initComponents();
  }

  private void initComponents() {
    setLayout(new GridLayout(2, 2));

    JPanel sellPanel = new JPanel();
    sellPanel.setLayout(new GridLayout(10, 2));

    JLabel fundsLabel = new JLabel("Available funds:");
    fundsField = new JTextField("$" + frame
        .getPortfolioService()
        .getFunds()
        .toPlainString());
    fundsField.setEditable(false);

    JLabel symbolLabel = new JLabel("Symbol:");
    symbolSelect.setModel(new DefaultComboBoxModel<>(frame
        .getPortfolioService()
        .getSymbols()
        .keySet()
        .toArray(new String[0])));

    JLabel quantityLabel = new JLabel("Quantity:");
    JTextField quantityField = new JTextField();

    JLabel earningsLabel = new JLabel("Total Earnings:");
    JTextField earningsField = new JTextField();
    earningsField.setEditable(false);

    JButton sellButton = new JButton("Sell");
    sellButton.addActionListener(_e -> sellShares(quantityField));

    JButton earningsButton = new JButton("Get Earnings");
    earningsButton.addActionListener(_e -> computeEarnings(quantityField, earningsField));

    sellPanel.add(fundsLabel);
    sellPanel.add(fundsField);
    sellPanel.add(new JPanel());
    sellPanel.add(new JPanel());
    sellPanel.add(symbolLabel);
    sellPanel.add(symbolSelect);
    sellPanel.add(new JPanel());
    sellPanel.add(new JPanel());
    sellPanel.add(quantityLabel);
    sellPanel.add(quantityField);
    sellPanel.add(new JPanel());
    sellPanel.add(new JPanel());
    sellPanel.add(earningsLabel);
    sellPanel.add(earningsField);
    sellPanel.add(new JPanel());
    sellPanel.add(new JPanel());
    sellPanel.add(earningsButton);
    sellPanel.add(sellButton);
    add(sellPanel);
    add(new JPanel());
    add(new JPanel());
    add(new JPanel());
  }

  private void computeEarnings(JTextField quantityField, JTextField earningsField) {
    if (symbolSelect.getSelectedItem() != null) {
      try {
        String symbol = (String) symbolSelect.getSelectedItem();
        BigDecimal price = frame.getMarketService().getStockPrice(symbol);

        try {
          int quantity = Integer.parseInt(quantityField.getText());
          DecimalFormat formatter = new DecimalFormat("#,##0.##");

          earningsField.setText(
              formatter.format(price.multiply(new BigDecimal(quantity))));
        } catch (NumberFormatException err) {
          earningsField.setText("Invelid quantity value!");
        }
      } catch (IOException err) {
        JOptionPane.showMessageDialog(
            this,
            err.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    } else {
      earningsField.setText("Invalid stock symbol!");
    }
  }

  private void sellShares(JTextField quantityField) {
    String symbol = (String) symbolSelect.getSelectedItem();

    if (frame.getPortfolioService().getSymbols().containsKey(symbol)) {
      try {
        int quantity = Integer.parseInt(quantityField.getText());
        int available_quantity = frame.getPortfolioService().getSymbols().get(symbol);
        if (quantity <= available_quantity) {
          try {
            frame.getPortfolioService().sellShares(symbol, quantity, frame);
          } catch (IOException err) {
            quantityField.setText("Server error! Try again later");
            System.err.println(err);
          }
        } else {
          quantityField.setText("You only own " + available_quantity + " units!");
        }
      } catch (NumberFormatException err) {
        quantityField.setText("Invalid value!");
      }
    } else {
      quantityField.setText("You don't own shares in " + symbol);
    }
  }

  public JTextField getFundsField() {
    return fundsField;
  }

  public JComboBox<String> getSymbolSelect() {
    return symbolSelect;
  }
}
