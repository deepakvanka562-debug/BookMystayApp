import java.util.ArrayList;
import java.util.List;

/**
 * BookingHistory - Stores and reports all reservations.
 * UC8: Booking History & Reporting
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class BookingHistory {

    private List<ReservationConfirmation> bookings;

    /**
     * Constructor initializes an empty booking history.
     */
    public BookingHistory() {
        this.bookings = new ArrayList<>();
    }

    /**
     * Adds a reservation to the history.
     *
     * @param confirmation the confirmed reservation to record
     */
    public void addBooking(ReservationConfirmation confirmation) {
        bookings.add(confirmation);
    }

    /**
     * Returns total number of bookings.
     *
     * @return count of all bookings
     */
    public int getTotalBookings() {
        return bookings.size();
    }

    /**
     * Calculates total revenue from all bookings.
     *
     * @return total revenue
     */
    public double getTotalRevenue() {
        double total = 0;
        for (ReservationConfirmation booking : bookings) {
            total += booking.getTotalCost();
        }
        return total;
    }

    /**
     * Displays a full report of all bookings.
     */
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("       BOOKING HISTORY REPORT         ");
        System.out.println("======================================");
        System.out.println("Total Bookings : " + getTotalBookings());
        System.out.println("Total Revenue  : Rs." + getTotalRevenue());
        System.out.println("--------------------------------------");
        System.out.println("Booking IDs: ");
        for (ReservationConfirmation booking : bookings) {
            System.out.println("  - Confirmation #" + booking.getConfirmationId() +
                               " | Status: " + booking.getStatus() +
                               " | Cost: Rs." + booking.getTotalCost());
        }
        System.out.println("======================================");
    }

    /**
     * Main method to demonstrate booking history and reporting.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Booking History ===");
        BookingHistory history = new BookingHistory();

        BookingRequest req1 = new BookingRequest("Alice", "SINGLE", 2, "2026-04-10", "2026-04-12");
        Room room1 = new Room(101, "SINGLE", 1500.0);
        ReservationConfirmation conf1 = new ReservationConfirmation(req1, room1);
        history.addBooking(conf1);

        BookingRequest req2 = new BookingRequest("Bob", "SUITE", 3, "2026-04-11", "2026-04-14");
        Room room2 = new Room(301, "SUITE", 5000.0);
        ReservationConfirmation conf2 = new ReservationConfirmation(req2, room2);
        history.addBooking(conf2);

        history.generateReport();
    }
}
