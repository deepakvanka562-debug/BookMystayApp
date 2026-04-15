import java.util.ArrayList;
import java.util.List;

/**
 * RoomSearch - Handles room search and availability checking.
 * UC4: Room Search & Availability
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class RoomSearch {

    private RoomInventory inventory;

    /**
     * Constructor to initialize RoomSearch with an inventory.
     *
     * @param inventory the room inventory to search
     */
    public RoomSearch(RoomInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Searches for available rooms by room type.
     *
     * @param roomType the type of room to search for
     * @return list of available rooms matching the type
     */
    public List<Room> searchAvailableRooms(String roomType) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : inventory.getAllRooms()) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * Returns all available rooms regardless of type.
     *
     * @return list of all available rooms
     */
    public List<Room> getAllAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : inventory.getAllRooms()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * Displays search results for a given room type.
     *
     * @param roomType the type to search
     */
    public void displaySearchResults(String roomType) {
        System.out.println("=== Search Results for: " + roomType + " ===");
        List<Room> results = searchAvailableRooms(roomType);
        if (results.isEmpty()) {
            System.out.println("No available rooms found for type: " + roomType);
        } else {
            for (Room room : results) {
                System.out.println(room);
            }
        }
    }

    /**
     * Main method to demonstrate room search.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        RoomSearch search = new RoomSearch(inventory);

        System.out.println("=== BookMyStay - Room Search ===");
        search.displaySearchResults("SINGLE");
        System.out.println();
        search.displaySearchResults("SUITE");
        System.out.println();
        System.out.println("All Available Rooms:");
        for (Room room : search.getAllAvailableRooms()) {
            System.out.println(room);
        }
    }
}
