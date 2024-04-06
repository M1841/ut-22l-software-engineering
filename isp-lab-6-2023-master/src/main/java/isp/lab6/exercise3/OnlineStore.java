package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OnlineStore {
  // Attributes
  private List<Product> products;
  private Map<String, ActiveSession> sessions;

  // Constructors
  public OnlineStore(List<Product> products, Map<String, ActiveSession> sessions) {
    this.products = products;
    this.sessions = sessions;
  }

  // Methods
  public List<Product> getProducts() {
    return products;
  }

  public List<Product> getProductsSorted(Comparator<Product> sortCriteria) {
    List<Product> sortedProducts = new ArrayList<>(products);
    sortedProducts.sort(sortCriteria);
    return sortedProducts;
  }

  void addSession(String username) {
    ActiveSession session = new ActiveSession(username);
    sessions.put(username, session);
  }

  void removeSession(String username) {
    sessions.remove(username);
  }

  public void addToCart(String username, Product product, int quantity) {
    ActiveSession session = sessions.get(username);
    session.addToCart(product, quantity);
  }

  public String checkout(String username) {
    ActiveSession session = sessions.get(username);
    return session.checkout();
  }
}
