package isp.lab5.exercise1;

import java.time.LocalDateTime;

public class Order {
  // Attributes
  private final String orderId;
  private final LocalDateTime date;
  private final Double totalPrice;
  private int maxId = 0;
  private Product[] products = new Product[10];
  private Customer customer;

  // Constructors
  public Order(Double totalPrice, Product[] products, Customer customer) {
    this.orderId = String.format("%d", ++maxId);
    this.date = LocalDateTime.now();

    this.totalPrice = totalPrice;
    this.products = products;
    this.customer = customer;
  }

  // Getters & Setters
  public String getOrderId() {
    return orderId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public Product[] getProducts() {
    return products;
  }

  public Customer getCustomer() {
    return customer;
  }

  // Methods
  @java.lang.Override
  public java.lang.String toString() {
    return "Order{" +
        "orderId='" + orderId + '\'' +
        ", date=" + date +
        ", totalPrice=" + totalPrice +
        ", maxId=" + maxId +
        ", products=" + java.util.Arrays.toString(products) +
        ", customer=" + customer +
        '}';
  }
}
