package isp.lab6.exercise3;

public class User {
  // Attributes
  private String username;
  private String password;

  // Getters & Setters
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // Constructors
  public User(String username, String password) {
    this.username = username;
    this.password = password;
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
    User user = (User) obj;
    return username.equals(user.username) && password.equals(user.password);
  }

  @Override
  public int hashCode() {
    int result = username.hashCode();
    result = 31 * result + password.hashCode();
    return result;
  }
}
