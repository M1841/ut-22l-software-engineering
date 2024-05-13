package isp.lab9.exercise1.services;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

public class UserPortfolioQueryService extends AbstractTableModel {
  private String[] columns = new String[] { "Name", "Symbol", "Quantity", "Price per Unit", "Total Price" };
  private Map<String, Integer> symbols = new HashMap<>();
  private List<StockItem> items = new ArrayList<>();
  private BigDecimal funds = BigDecimal.valueOf(0);

  public void refreshMarketData() throws IOException {
    items = YahooWebClient.get(
        symbols.keySet()
            .toArray(new String[0]))
        .stream()
        .map(item -> {
          item.setQuantity(symbols.get(item.getSymbol()));
          return item;
        })
        .collect(Collectors.toList());
    this.fireTableDataChanged();
  }

  public void buyShares(String symbol, int quantity) {
    symbols.put(symbol, quantity);

    try {
      this.refreshMarketData();
    } catch (IOException err) {
      System.err.println(err);
    }
  }

  public BigDecimal getStockPrice(String symbol) throws IOException {
    StockItem stock = YahooWebClient.get(symbol);
    return stock.getPrice();
  }

  public Map<String, Integer> getSymbols() {
    return symbols;
  }

  @Override
  public int getRowCount() {
    return items.size();
  }

  @Override
  public int getColumnCount() {
    return 5;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    StockItem i = items.get(rowIndex);

    switch (columnIndex) {
      case 0:
        return i.getName();
      case 1:
        return i.getSymbol();
      case 2:
        return i.getQuantity();
      case 3:
        return i.getPrice();
      case 4:
        return i.getTotalPrice();
    }
    return "N/A";
  }

  @Override
  public String getColumnName(int index) {
    return columns[index];
  }

  public BigDecimal getFunds() {
    return funds;
  }
}
