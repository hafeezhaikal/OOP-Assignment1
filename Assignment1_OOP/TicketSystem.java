import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TicketSystem class: represents one event ticket booking.
// All attributes are private (encapsulation) and accessed through getters/setters.

public class TicketSystem {


   private String ticketID;
   private String eventName;
   private String customerName;
   private String eventDate;
   private int seatNumber;
   private double ticketPrice;
   private int quantity;
   private boolean isBooked;
   private LocalDateTime dateTime;


    // 1. Default constructor: sets starting values
    public TicketSystem() {
        this.ticketID = "N/A";
        this.eventName = "Not set";
        this.customerName = "Not set";
        this.eventDate = "Not set";
        this.seatNumber = 0;
        this.ticketPrice = 0.0;
        this.quantity = 0;
        this.isBooked = false;
        this.dateTime = LocalDateTime.now();
    }

    // 2. Parameterized constructor: sets all attributes from the values given
    public TicketSystem(String eventName, String customerName, String eventDate, int seatNumber, double ticketPrice, int quantity) {
        this.eventName = eventName;
        this.customerName = customerName;
        this.eventDate = eventDate;
        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
        this.quantity = quantity;
        this.isBooked = false;
        this.dateTime = LocalDateTime.now();
        this.ticketID = "N/A";
    }

    // Getters: return the value of each attribute
    public String getTicketID() { return ticketID; }
    public String getEventName() { return eventName; }
    public String getCustomerName() { return customerName; }
    public String getEventDate() { return eventDate; }
    public int getSeatNumber() { return seatNumber; }
    public double getTicketPrice() { return ticketPrice; }
    public int getQuantity() { return quantity; }
    public boolean isBooked() { return isBooked; }

    // Setters: change the value of each attribute
    public void setTicketID(String ticketID) { this.ticketID = ticketID; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setEventDate(String eventDate) { this.eventDate = eventDate; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setBooked(boolean booked) { this.isBooked = booked; }

    // Additional method 1: calculate total price (uses ticketPrice and quantity)
    public double calculateTotal() {
        return ticketPrice * quantity;
    }

    // Additional method 2: book a ticket for a customer
    // Returns true if the name is valid, otherwise false
    public boolean bookTicket(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;                       // invalid name, not booked
        }
        this.customerName = name.trim();
        this.isBooked = true;
        this.dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        this.ticketID = "TCK-" + dateTime.format(formatter) + "-" + seatNumber;
        return true;
    }

    // Additional method 3: cancel a booking (status check, then reset)
    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            customerName = "Not set";
            ticketID = "N/A";
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("No booking to cancel.");
        }
    }

}