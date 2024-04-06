package isp.lab5.exercise1;

public class Product {
  // Attributes
  private final String productId;
  private final String name;
  private final double price;

  private final ProductCategory productCategory;
  private static int maxId = 0;

  // Constructors
  public Product(String name, double price, ProductCategory productCategory) {
    this.productId = String.format("%d", ++maxId);
    this.name = name;
    this.price = price;
    this.productCategory = productCategory;
  }

  // Getters & Setters
  public String getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public ProductCategory getProductCategory() {
    return productCategory;
  }

  public static int getMaxId() {
    return maxId;
  }

  public static void setMaxId(int maxId) {
    Product.maxId = maxId;
  }

  // Methods
  @java.lang.Override
  public java.lang.String toString() {
    return "Product{" +
        "productId='" + productId + '\'' +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", productCategory=" + productCategory +
        '}';
  }
}
