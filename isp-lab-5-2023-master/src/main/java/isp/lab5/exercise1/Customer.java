package isp.lab5.exercise1;

public class Customer {
  // Attributes
  private final String customerId;
  private final String name;
  private final String phone;
  private int maxId = 0;
  final Address address;

  // Constructors
  public Customer(String name, String phone, Address address) {
    this.customerId = String.format("%d", ++maxId);
    this.name = name;
    this.phone = phone;
    this.address = address;
  }

  // Getters & Setters
  public String getCustomerId() {
    return customerId;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public Address getAddress() {
    return address;
  }

  // Methods
  @java.lang.Override
  public java.lang.String toString() {
    return "Customer{" +
            "customerId='" + customerId + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", maxId=" + maxId +
            ", address=" + address +
            '}';
  }
}
