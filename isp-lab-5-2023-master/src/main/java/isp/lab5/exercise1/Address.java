package isp.lab5.exercise1;

public class Address {
  // Attributes
  private final String street;
  private final String city;

  // Constructors
  public Address(String street, String city) {
    this.street = street;
    this.city = city;
  }

  // Getters & Setters
  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  // Methods
  @java.lang.Override
  public java.lang.String toString() {
    return "Address{" +
            "street='" + street + '\'' +
            ", city='" + city + '\'' +
            '}';
  }
}
