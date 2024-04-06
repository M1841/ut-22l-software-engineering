package isp.lab5.exercise4;

public class Exercise4 {
  public static void main(String[] args) {
    TicketManager ticketManager = new TicketManager();

    UserApp userApp = new UserApp();
    int balance = 15;

    balance = userApp.buyTicket(ticketManager, balance);
    userApp.viewTicket();

    OrganizerApp.checkin(ticketManager, userApp.getTicket());
  }
}
