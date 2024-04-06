package isp.lab6.exercise3;

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
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Product product = (Product) obj;
    return name.equals(product.name) && price == product.price;
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    long temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
