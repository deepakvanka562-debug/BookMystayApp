/**
 * BookingRequest - Represents a guest's booking request.
 * UC5: Booking Request
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class BookingRequest {

    private String guestName;
    private String roomType;
    private int numberOfNights;
    private String checkInDate;
    private String checkOutDate;

    /**
     * Constructor to create a booking request.
     *
     * @param guestName      name of the guest
     * @param roomType       type of room requested
     * @param numberOfNights number of nights
     * @param checkInDate    check-in date
     * @param checkOutDate   check-out date
     */
    public BookingRequest(String guestName, String roomType,
                          int numberOfNights, String checkInDate, String checkOutDate) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public int getNumberOfNights() { return numberOfNights; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }

    /**
     * Displays the booking request details.
     */
    public void displayRequest() {
        System.out.println("=== Booking Request ===");
        System.out.println("Guest Name   : " + guestName);
        System.out.println("Room Type    : " + roomType);
        System.out.println("Check-In     : " + checkInDate);
        System.out.println("Check-Out    : " + checkOutDate);
        System.out.println("Nights       : " + numberOfNights);
    }

    /**
     * Main method to demonstrate a booking request.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        BookingRequest request = new BookingRequest(
            "Pratikesh", "DOUBLE", 3, "2026-04-10", "2026-04-13"
        );
        System.out.println("=== BookMyStay - Booking Request ===");
        request.displayRequest();
        System.out.println("Request submitted successfully!");
    }
}
