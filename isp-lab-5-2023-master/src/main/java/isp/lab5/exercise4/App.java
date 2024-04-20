package isp.lab5.exercise4;

import java.util.HashSet;
import java.util.Set;

public abstract class App implements TicketManager{
  // Attributes
  protected static Set<String> tickets = new HashSet<>();

  // Methods
  public abstract String generateTicket();
  public abstract TicketValidity validateTicket(String ticket);
}

