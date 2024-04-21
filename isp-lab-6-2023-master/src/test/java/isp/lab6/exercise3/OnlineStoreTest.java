package isp.lab6.exercise3;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class OnlineStoreTest {
  private OnlineStore onlineStore;
  private Product product1;
  private Product product2;
  private String username;

  @Before
  public void setUp() {
    product1 = new Product("product1", 10.0);
    product2 = new Product("product2", 20.0);
    List<Product> products = new ArrayList<>(Arrays.asList(product1, product2));
    Map<String, ActiveSession> sessions = new HashMap<>();
    onlineStore = new OnlineStore(products, sessions);
    username = "testUser";
    onlineStore.addSession(username);
  }

  @Test
  public void testGetProductsSorted() {
    List<Product> sortedProducts = onlineStore.getProductsSorted(Comparator.comparingDouble(p -> p.price));
    assertEquals(Arrays.asList(product1, product2), sortedProducts);
  }

  @Test
  public void testAddSession() {
    String newUsername = "newUser";
    onlineStore.addSession(newUsername);
    assertTrue(onlineStore.getSessions().containsKey(newUsername));
  }

  @Test
  public void testRemoveSession() {
    onlineStore.removeSession(username);
    assertFalse(onlineStore.getSessions().containsKey(username));
  }

  @Test
  public void testAddToCart() {
    onlineStore.addToCart(username, product1, 5);
    assertEquals(Integer.valueOf(5), onlineStore.getSessions().get(username).getCart().get(product1));
  }

  @Test
  public void testCheckout() {
    onlineStore.addToCart(username, product1, 5);
    String receipt = onlineStore.checkout(username);
    assertTrue(onlineStore.getSessions().get(username).getCart().isEmpty());
    assertTrue(receipt.contains("Receipt for " + username));
    assertTrue(receipt.contains(product1.name + " * 5 = 50.0"));
    assertTrue(receipt.contains("Total: 50.0"));
  }
}