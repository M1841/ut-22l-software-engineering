package isp.lab5.exercise4;

import java.util.Scanner;

public class ConsoleInterface {
    private static UserApp userApp;
    private static OrganizerApp organizerApp;
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        int balance = 15;
        boolean exit_1 = false;

        while (!exit_1) {
            System.out.println("1. Log in as User");
            System.out.println("2. Log in as Organizer");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int loginOption = scanner.nextInt();

            switch (loginOption) {
                case 1 -> userApp = new UserApp();
                case 2 -> organizerApp = new OrganizerApp();
                case 0 -> exit_1 = true;
                default -> System.out.println("Invalid option. Please try again.");
            }

            boolean exit_2 = false;

            while (!exit_1 && !exit_2) {
                System.out.println("1. Buy ticket");
                System.out.println("2. View ticket");
                System.out.println("3. Check-in");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        if (loginOption == 1) {
                            balance = userApp.buyTicket(balance);
                        } else {
                            System.out.println("You don't need a ticket. Organizers" +
                                    " participate for free");
                        }
                    }
                    case 2 -> {
                        if (loginOption == 1) {
                            userApp.viewTicket();
                        } else {
                            System.out.println("You don't have a ticket. Organizers" +
                                    " participate for free");
                        }
                    }
                    case 3 -> {
                        if (loginOption == 1) {
                            System.out.println("Wait for an organizer to come check" +
                                    " you in");
                        } else {
                            System.out.print("Ticket: ");
                            String ticket = scanner.next();

                            organizerApp.checkin(ticket);
                        }
                    }
                    case 0 -> exit_2 = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}