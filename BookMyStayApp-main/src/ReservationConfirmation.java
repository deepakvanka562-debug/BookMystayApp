/**
 * ReservationConfirmation - Generates a booking confirmation.
 * UC6: Reservation Confirmation & Summary
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class ReservationConfirmation {

    private static int confirmationCounter = 1000;

    private int confirmationId;
    private BookingRequest bookingRequest;
    private Room assignedRoom;
    private double totalCost;
    private String status;

    /**
     * Constructor to create a reservation confirmation.
     *
     * @param bookingRequest the guest's booking request
     * @param assignedRoom   the room assigned to the guest
     */
    public ReservationConfirmation(BookingRequest bookingRequest, Room assignedRoom) {
        this.confirmationId = ++confirmationCounter;
        this.bookingRequest = bookingRequest;
        this.assignedRoom = assignedRoom;
        this.totalCost = assignedRoom.getPricePerNight() * bookingRequest.getNumberOfNights();
        this.status = "CONFIRMED";
        assignedRoom.setAvailable(false);
    }

    public int getConfirmationId() { return confirmationId; }
    public String getStatus() { return status; }
    public double getTotalCost() { return totalCost; }

    /**
     * Displays the full reservation confirmation summary.
     */
    public void displayConfirmation() {
        System.out.println("========================================");
        System.out.println("       RESERVATION CONFIRMATION         ");
        System.out.println("========================================");
        System.out.println("Confirmation ID : " + confirmationId);
        System.out.println("Status          : " + status);
        System.out.println("Guest Name      : " + bookingRequest.getGuestName());
        System.out.println("Room Number     : " + assignedRoom.getRoomNumber());
        System.out.println("Room Type       : " + assignedRoom.getRoomType());
        System.out.println("Check-In        : " + bookingRequest.getCheckInDate());
        System.out.println("Check-Out       : " + bookingRequest.getCheckOutDate());
        System.out.println("Nights          : " + bookingRequest.getNumberOfNights());
        System.out.println("Price/Night     : Rs." + assignedRoom.getPricePerNight());
        System.out.println("Total Cost      : Rs." + totalCost);
        System.out.println("========================================");
    }

    /**
     * Main method to demonstrate reservation confirmation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Reservation Confirmation ===");
        BookingRequest request = new BookingRequest(
            "Pratikesh", "DOUBLE", 3, "2026-04-10", "2026-04-13"
        );
        Room room = new Room(201, "DOUBLE", 2500.0);
        ReservationConfirmation confirmation = new ReservationConfirmation(request, room);
        confirmation.displayConfirmation();
    }
}
