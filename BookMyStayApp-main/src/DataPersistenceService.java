import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DataPersistenceService - Handles saving and restoring system state
 * to/from a file to ensure data survives application restarts.
 * UC12: Data Persistence & System Recovery
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class DataPersistenceService {

    private static final String DATA_FILE = "bookings_data.txt";

    /**
     * Saves the list of reservation confirmations to a persistent file.
     * Each booking is serialized as a line of text.
     *
     * @param bookings list of reservations to persist
     */
    public void saveBookings(List<String> bookings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (String booking : bookings) {
                writer.write(booking);
                writer.newLine();
            }
            System.out.println("[SAVE] " + bookings.size() + " booking(s) saved to " + DATA_FILE);
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to save bookings: " + e.getMessage());
        }
    }

    /**
     * Restores booking records from persistent storage.
     * Called on system startup to recover previous state.
     *
     * @return list of recovered booking records
     */
    public List<String> restoreBookings() {
        List<String> restored = new ArrayList<>();
        File file = new File(DATA_FILE);

        if (!file.exists()) {
            System.out.println("[RESTORE] No data file found. Starting with empty state.");
            return restored;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    restored.add(line);
                }
            }
            System.out.println("[RESTORE] " + restored.size() + " booking(s) restored from " + DATA_FILE);
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to restore bookings: " + e.getMessage());
        }
        return restored;
    }

    /**
     * Checks if a persistent data file exists.
     *
     * @return true if data file is present
     */
    public boolean hasPersistedData() {
        return new File(DATA_FILE).exists();
    }

    /**
     * Clears the persistent data file (used for reset/cleanup).
     */
    public void clearPersistedData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            file.delete();
            System.out.println("[CLEAR] Persisted data cleared.");
        }
    }

    /**
     * Main method to demonstrate data persistence and system recovery.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Data Persistence & System Recovery ===");

        DataPersistenceService service = new DataPersistenceService();

        // Simulate saving bookings before shutdown
        System.out.println("\n--- PHASE 1: Saving state before shutdown ---");
        List<String> bookings = new ArrayList<>();
        bookings.add("CONF#1001 | Guest: Alice | Room: 101 (SINGLE) | Cost: Rs.3000.0 | Status: CONFIRMED");
        bookings.add("CONF#1002 | Guest: Bob   | Room: 301 (SUITE)  | Cost: Rs.15000.0 | Status: CONFIRMED");
        bookings.add("CONF#1003 | Guest: Carol | Room: 201 (DOUBLE) | Cost: Rs.7500.0 | Status: CONFIRMED");
        service.saveBookings(bookings);

        // Simulate system restart and recovery
        System.out.println("\n--- PHASE 2: System restart - restoring state ---");
        System.out.println("Has persisted data: " + service.hasPersistedData());
        List<String> restored = service.restoreBookings();

        System.out.println("\nRestored Bookings:");
        for (String b : restored) {
            System.out.println("  " + b);
        }

        // Cleanup
        System.out.println("\n--- PHASE 3: Cleanup ---");
        service.clearPersistedData();
        System.out.println("Has persisted data after clear: " + service.hasPersistedData());

        System.out.println("\nData persistence demonstration complete.");
    }
}
