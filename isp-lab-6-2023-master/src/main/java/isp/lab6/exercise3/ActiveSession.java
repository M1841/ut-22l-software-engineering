package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
  // Attributes
  private final String username;
  private final Map<Product, Integer> cart;

  // Getters & Setters

  public Map<Product, Integer> getCart() {
    return cart;
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
    StringBuilder receipt = new StringBuilder("Receipt for " + username + ":\n");
    double total = 0;

    for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
      double currentPrice = entry.getKey().price * entry.getValue();

      total += currentPrice;
      receipt.append(entry.getKey().name).append(" * ").append(entry.getValue()).append(" = ").append(String.format("%.2f", currentPrice)).append("\n");
    }

    receipt.append("Total: ").append(String.format("%.2f", total));

    cart.clear();

    return receipt.toString();
  }
}
