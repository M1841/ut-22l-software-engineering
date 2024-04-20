package isp.lab5.exercise4;

public class OrganizerApp extends App {
  // Methods
  @Override
  public String generateTicket() {
    System.out.println("Organizers participate for free");
    return null;
  }

  @Override
  public TicketValidity validateTicket(String ticket) {
    TicketValidity validity = tickets.contains(ticket) ? TicketValidity.VALID :
            TicketValidity.INVALID;
    tickets.remove(ticket);
    return validity;
  }

  public void checkin(String ticket) {
    if (validateTicket(ticket) == TicketValidity.VALID) {
      System.out.println("Ticket is valid");
    } else {
      System.out.println("Ticket is invalid");
    }
  }
}
