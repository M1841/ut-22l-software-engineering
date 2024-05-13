/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolioQueryService;
import isp.lab9.exercise1.services.StockMarketQueryService;
import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mihai.hulea
 * @author radu.miron
 */
public class StockMarketJFrame extends JFrame {
  private StockMarketQueryService marketService;
  private UserPortfolioQueryService portfolioService;

  private PortfolioJPanel portfolioJPanel;
  private BuyJPanel buyJPanel;

  /**
   * Creates new form StockMarketJFrame
   */
  public StockMarketJFrame() {
    try {
      marketService = new StockMarketQueryService();
      marketService.refreshMarketData();

      portfolioService = new UserPortfolioQueryService();
    } catch (IOException ex) {
      Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

    initComponents();
    setVisible(true);
  }

  /**
   * Initializes the window with the tabs and main panels. Each panel is definied
   * in its own class.
   */
  private void initComponents() {
    this.setSize(700, 400);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Market", new MarketJPanel(this));

    portfolioJPanel = new PortfolioJPanel(this);
    tabs.addTab("UserPortfolio", portfolioJPanel);

    buyJPanel = new BuyJPanel(this);
    tabs.addTab("Buy", buyJPanel);
    tabs.addTab("Sell", new SellJPanel());

    this.add(tabs);
  }

  public StockMarketQueryService getMarketService() {
    return marketService;
  }

  public UserPortfolioQueryService getPortfolioService() {
    return portfolioService;
  }

  public PortfolioJPanel getPortfolioJPanel() {
    return portfolioJPanel;
  }

  public BuyJPanel getBuyJPanel() {
    return buyJPanel;
  }
}
