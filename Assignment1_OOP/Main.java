import java.util.Scanner;

// Main class: lets the user book tickets using the TicketSystem object
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TicketSystem ticket = new TicketSystem();      // default constructor

            System.out.println("Ticketing System");
            System.out.println("================");
            System.out.println("Choose event:\n1. F1\n2. F2");

            // Looping + selection: repeat until the user enters 1 or 2
            int choice;
            do {
                System.out.print("Enter number event: ");
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Try again...");
                }
            } while (choice != 1 && choice != 2);

            // Selection (switch): set event details using setters
               switch (choice) {
                case 1:
                    ticket.setEventName("F1");
                    ticket.setEventDate("10/10/2026");
                    ticket.setTicketPrice(2100);
                    break;
                case 2:
                    ticket.setEventName("F2");
                    ticket.setEventDate("11/11/2026");
                    ticket.setTicketPrice(1200);
                    break;
            }

            // Looping: repeat until the quantity is at least 1
            int qty;
            do {
                System.out.print("How many tickets? ");
                qty = scanner.nextInt();
                if (qty < 1) {
                    System.out.println("Quantity must be at least 1.");
                }
            } while (qty < 1);
            ticket.setQuantity(qty);
            scanner.nextLine();                            // clear the Enter key

            System.out.println("\nEvent: " + ticket.getEventName()
                    + " on " + ticket.getEventDate());

            // Looping (for): book one ticket at a time
            for (int i = 1; i <= ticket.getQuantity(); i++) {

                ticket.setSeatNumber(i);                   // seat number for this ticket

                boolean success;
                // Loop: keep asking until a valid (non-empty) name is entered
                do {
                    System.out.print("\nTicket " + i + " of " + ticket.getQuantity()
                            + " - enter name: ");
                    String name = scanner.nextLine();
                    success = ticket.bookTicket(name);     // additional method 2
                    // If the name was rejected, tell the user to try again
                    if (!success) {
                        System.out.println("Name cannot be empty. Try again...");
                    }
                } while (!success);

                // Selection (if): check the booking status
                if (ticket.isBooked()) {
                    System.out.println("Ticket ID : " + ticket.getTicketID());
                    System.out.println("Name      : " + ticket.getCustomerName());
                    System.out.println("Seat      : " + ticket.getSeatNumber());
                    System.out.println("Price     : RM" + ticket.getTicketPrice());
                }
            }

            // Additional method 1: total price
            System.out.println("\nTotal you pay is RM" + ticket.calculateTotal());

            // Additional method 3: cancel the last booking if the user wants
            System.out.print("Cancel the last booking? (y/n): ");
            String answer = scanner.nextLine();
            // If the user typed y, cancel the booking
            if (answer.equalsIgnoreCase("y")) {
                ticket.cancelBooking();
            }

            // Demo of the parameterized constructor (fixed example data, not user input)
            System.out.println("\n--- Parameterized constructor demo ---");
            TicketSystem sample = new TicketSystem("F1", "Ali", "10/10/2026", 1, 2100, 2);
            System.out.println("Event    : " + sample.getEventName() + " on " + sample.getEventDate());
            System.out.println("Customer : " + sample.getCustomerName());
            System.out.println("Seat     : " + sample.getSeatNumber());
            System.out.println("Quantity : " + sample.getQuantity());
            System.out.println("Total    : RM" + sample.calculateTotal());

            System.out.println("Thank you..");
        }
    }
}