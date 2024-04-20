package isp.lab5.exercise4;

public interface TicketManager {
    // Methods
    String generateTicket();
    TicketValidity validateTicket(String ticket);
}
