package isp.lab7.safehome;

public class Tenant {
  // Attributes
  private String name;

  // Getters & Setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Constructors
  public Tenant(String name) {
    this.name = name;
  }
}
