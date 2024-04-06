package isp.lab5.exercise4;

public class OrganizerApp {
  // Methods
  public static void checkin(TicketManager ticketManager, String ticket) {
    if (ticketManager.validateTicket(ticket)) {
      System.out.println("Ticket is valid");
    } else {
      System.out.println("Ticket is invalid");
    }
  }
}
