package isp.lab5.exercise4;

import java.util.Random;

public class UserApp extends App {
  // Attributes
  private String ticket;

  // Getters & Setters
  public String getTicket() {
    return ticket;
  }

  // Methods
  @Override
  public String generateTicket() {
    Random random = new Random();
    String ticket = String.valueOf(random.nextLong(1000000000, Long.MAX_VALUE));
    tickets.add(ticket);
    return ticket;
  }

  @Override
  public TicketValidity validateTicket(String ticket) {
    System.out.println("Regular users cannot validate tickets");
    return null;
  }

  public int buyTicket(int balance) {
    if (ticket != null) {
      System.out.println("You already have a ticket");
      return balance;
    }

    if (balance < 10) {
      System.out.println("Insufficient funds");
    } else {
      ticket = generateTicket();
      balance -= 10;
      System.out.println("Ticket bought successfully");
    }

    return balance;
  }

  public void viewTicket() {
    if (ticket == null) {
      System.out.println("You don't have a ticket");
    } else {
      System.out.println("Ticket: " + ticket);
    }
  }
}
