package isp.lab6.exercise3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActiveSessionTest {
  private ActiveSession activeSession;
  private Product product;

  @Before
  public void setUp() {
    activeSession = new ActiveSession("testUser");
   product = new Product("testProduct", 10.0);
  }

  @Test
  public void testAddToCart() {
    activeSession.addToCart(product, 5);
    assertTrue(activeSession.getCart().containsKey(product));
    assertEquals(Integer.valueOf(5), activeSession.getCart().get(product));
  }

  @Test
  public void testCheckout() {
    activeSession.addToCart(product, 5);
    String receipt = activeSession.checkout();
    assertTrue(activeSession.getCart().isEmpty());
    assertTrue(receipt.contains("Receipt for testUser"));
    assertTrue(receipt.contains("testProduct * 5 = 50.0"));
    assertTrue(receipt.contains("Total: 50.0"));
  }
}