package isp.lab5.exercise1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Radu Miron
 * @version 1
 */
public class Exercise1Test {
  @Test
  public void testBehavior() {
    Address address = new Address("Observatorului", "Cluj-Napoca");
    Customer customer = new Customer("Mihai", "+40***", address);
    Product[] products = {
        new Product("SSD", 299.99, ProductCategory.ELECTRONICS),
        new Product("RAM", 149.99, ProductCategory.ELECTRONICS)
    };
    Double totalPrice = 0.0;
    for (Product product : products) {
      totalPrice += product.getPrice();
    }
    Order order = new Order(totalPrice, products, customer);

    Assert.assertEquals(totalPrice, order.getTotalPrice());

    Assert.assertEquals(customer, order.getCustomer());

    Assert.assertEquals(products[0], order.getProducts()[0]);
    Assert.assertEquals(products[1], order.getProducts()[1]);
  }
}
