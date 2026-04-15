import java.util.HashMap;
import java.util.Map;

/**
 * BookingCancellation - Handles safe cancellation of confirmed bookings
 * with inventory rollback to restore system state.
 * UC10: Booking Cancellation & Inventory Rollback
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class BookingCancellation {

    // Tracks which confirmation IDs are currently active
    private Map<Integer, ReservationConfirmation> activeBookings;
    // Tracks which room was assigned to each confirmation
    private Map<Integer, Room> bookingRoomMap;

    /**
     * Constructor initializes cancellation service.
     */
    public BookingCancellation() {
        this.activeBookings = new HashMap<>();
        this.bookingRoomMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking for tracking.
     *
     * @param confirmation the confirmed reservation
     * @param room         the room assigned to this booking
     */
    public void registerBooking(ReservationConfirmation confirmation, Room room) {
        activeBookings.put(confirmation.getConfirmationId(), confirmation);
        bookingRoomMap.put(confirmation.getConfirmationId(), room);
        System.out.println("Booking registered: Confirmation #" + confirmation.getConfirmationId());
    }

    /**
     * Cancels an existing booking and rolls back inventory.
     * Ensures the room is marked available again.
     *
     * @param confirmationId the ID of the booking to cancel
     * @return true if cancelled successfully, false if not found
     */
    public boolean cancelBooking(int confirmationId) {
        if (!activeBookings.containsKey(confirmationId)) {
            System.out.println("[ERROR] Booking #" + confirmationId + " not found or already cancelled.");
            return false;
        }

        // Rollback: restore room availability
        Room room = bookingRoomMap.get(confirmationId);
        room.setAvailable(true);

        // Remove from active bookings
        activeBookings.remove(confirmationId);
        bookingRoomMap.remove(confirmationId);

        System.out.println("[SUCCESS] Booking #" + confirmationId + " cancelled.");
        System.out.println("          Room " + room.getRoomNumber() + " (" + room.getRoomType() + ") is now available again.");
        return true;
    }

    /**
     * Returns the count of active (non-cancelled) bookings.
     *
     * @return number of active bookings
     */
    public int getActiveBookingCount() {
        return activeBookings.size();
    }

    /**
     * Main method to demonstrate booking cancellation and rollback.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Booking Cancellation & Inventory Rollback ===");

        // Create and confirm a booking
        Room room = new Room(201, "DOUBLE", 2500.0);
        BookingRequest request = new BookingRequest("Pratikesh", "DOUBLE", 3, "2026-04-10", "2026-04-13");
        ReservationConfirmation confirmation = new ReservationConfirmation(request, room);

        System.out.println("Room available after booking: " + room.isAvailable()); // false

        // Register and cancel
        BookingCancellation service = new BookingCancellation();
        service.registerBooking(confirmation, room);
        System.out.println("Active bookings: " + service.getActiveBookingCount());

        // Cancel the booking - inventory should rollback
        service.cancelBooking(confirmation.getConfirmationId());
        System.out.println("Room available after cancellation: " + room.isAvailable()); // true
        System.out.println("Active bookings after cancel: " + service.getActiveBookingCount());

        // Attempt to cancel again - should fail gracefully
        service.cancelBooking(confirmation.getConfirmationId());
    }
}
