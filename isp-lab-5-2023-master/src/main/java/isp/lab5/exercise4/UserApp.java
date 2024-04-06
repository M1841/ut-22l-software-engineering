package isp.lab5.exercise4;

public class UserApp {
  // Attributes
  private String ticket;

  // Getters & Setters
  public String getTicket() {
    return ticket;
  }

  // Methods
  public int buyTicket(TicketManager ticketManager, int balance) {
    if (ticket != null) {
      System.out.println("You already have a ticket");
      return balance;
    }

    if (balance < 10) {
      System.out.println("Insufficient funds");
    } else {
      ticket = ticketManager.generateTicket();
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
