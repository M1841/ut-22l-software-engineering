package isp.lab6.exercise3;

import java.util.Objects;
import java.util.Set;

public class LoginSystem {
  // Attributes
  private Set<User> users;
  private OnlineStore store;

  // Getters & Setters
  public Set<User> getUsers() {
    return users;
  }

  public OnlineStore getStore() {
    return store;
  }

  // Constructors
  public LoginSystem(Set<User> users, OnlineStore store) {
    this.users = users;
    this.store = store;
  }

  // Methods
  public void register(String username, String password) {
    users.add(new User(username, password));
  }

  public boolean login(String username, String password) {
    for (User user : users) {
      if (Objects.equals(user.getUsername(), username) && Objects.equals(user.getPassword(), password)) {
        store.addSession(username);
        return true;
      }
    }
    return false;
  }

  public boolean logout(String username) {
    store.removeSession(username);
    return true;
  }
}
