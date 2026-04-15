import java.util.ArrayList;
import java.util.List;

/**
 * RoomInventory - Centralized management of all hotel rooms.
 * UC3: Centralized Room Inventory
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class RoomInventory {

    private List<Room> rooms;

    /**
     * Constructor initializes the room inventory with default rooms.
     */
    public RoomInventory() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    /**
     * Populates the inventory with predefined rooms.
     */
    private void initializeRooms() {
        rooms.add(new Room(101, "SINGLE", 1500.0));
        rooms.add(new Room(102, "SINGLE", 1500.0));
        rooms.add(new Room(201, "DOUBLE", 2500.0));
        rooms.add(new Room(202, "DOUBLE", 2500.0));
        rooms.add(new Room(301, "SUITE", 5000.0));
        rooms.add(new Room(302, "SUITE", 5000.0));
    }

    /**
     * Returns all rooms in the inventory.
     *
     * @return list of all rooms
     */
    public List<Room> getAllRooms() {
        return rooms;
    }

    /**
     * Displays the full room inventory.
     */
    public void displayInventory() {
        System.out.println("=== BookMyStay - Room Inventory ===");
        System.out.println("Total Rooms: " + rooms.size());
        System.out.println("----------------------------------");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    /**
     * Main method to demonstrate the room inventory.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.displayInventory();
    }
}
