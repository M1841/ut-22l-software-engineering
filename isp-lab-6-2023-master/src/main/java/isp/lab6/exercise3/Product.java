package isp.lab6.exercise3;

import java.util.Objects;

public class Product {
  // Attributes
  public String name;
  public double price;

  // Constructors
  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  // Methods
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }
}
