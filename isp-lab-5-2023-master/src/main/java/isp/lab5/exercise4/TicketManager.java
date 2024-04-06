package isp.lab5.exercise4;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TicketManager {
  // Attributes
  private Set<String> tickets = new HashSet<>();

  // Methods
  public String generateTicket() {
    Random random = new Random();
    String ticket = String.valueOf(random.nextLong());
    tickets.add(ticket);
    return ticket;
  }

  public boolean validateTicket(String ticket) {
    boolean isValid = tickets.contains(ticket);
    tickets.remove(ticket);
    return isValid;
  }
}
