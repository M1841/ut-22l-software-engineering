package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
  // Attributes
  private String username;
  private Map<Product, Integer> cart;

  // Getters & Setters
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Map<Product, Integer> getCart() {
    return cart;
  }

  public void setCart(Map<Product, Integer> cart) {
    this.cart = cart;
  }

  // Constructors
  public ActiveSession(String username) {
    this.username = username;
    this.cart = new HashMap<>();
  }

  // Methods
  public void addToCart(Product product, int quantity) {
    if (cart.containsKey(product)) {
      cart.put(product, cart.get(product) + quantity);
    } else {
      cart.put(product, quantity);
    }
  }

  public String checkout() {
    String receipt = "Receipt for " + username + ":\n";
    double total = 0;

    for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
      double currentPrice = entry.getKey().price * entry.getValue();

      total += currentPrice;
      receipt += entry.getKey().name + " * " + entry.getValue() + " = " + currentPrice + "\n";
    }

    receipt += "Total: " + total;

    cart.clear();

    return receipt;
  }
}
