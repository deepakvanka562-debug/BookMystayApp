/**
 * Room - Represents a hotel room with basic attributes.
 * UC2: Basic Room Types & Static Attributes
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class Room {

    // Static constant for total number of rooms
    public static final int TOTAL_ROOMS = 10;

    // Room attributes
    private int roomNumber;
    private String roomType;   // SINGLE, DOUBLE, SUITE
    private double pricePerNight;
    private boolean isAvailable;

    /**
     * Constructor to initialize a Room.
     *
     * @param roomNumber    unique room number
     * @param roomType      type of room (SINGLE, DOUBLE, SUITE)
     * @param pricePerNight price per night
     */
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return "Room [" + roomNumber + "] Type: " + roomType +
               " | Price: Rs." + pricePerNight + "/night" +
               " | Available: " + (isAvailable ? "Yes" : "No");
    }

    /**
     * Main method to demonstrate Room types.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Room Types ===");
        System.out.println("Total Rooms: " + TOTAL_ROOMS);
        System.out.println();

        Room single = new Room(101, "SINGLE", 1500.0);
        Room doublRoom = new Room(201, "DOUBLE", 2500.0);
        Room suite = new Room(301, "SUITE", 5000.0);

        System.out.println(single);
        System.out.println(doublRoom);
        System.out.println(suite);
    }
}
