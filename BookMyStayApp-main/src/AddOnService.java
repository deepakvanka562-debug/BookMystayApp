import java.util.ArrayList;
import java.util.List;

/**
 * AddOnService - Manages add-on services for hotel guests.
 * UC7: Add-On Service Selection
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class AddOnService {

    public enum ServiceType {
        BREAKFAST(500.0, "Breakfast"),
        AIRPORT_PICKUP(800.0, "Airport Pickup"),
        SPA(1200.0, "Spa Treatment"),
        LAUNDRY(300.0, "Laundry Service"),
        ROOM_SERVICE(400.0, "Room Service");

        private final double price;
        private final String description;

        ServiceType(double price, String description) {
            this.price = price;
            this.description = description;
        }

        public double getPrice() { return price; }
        public String getDescription() { return description; }
    }

    private List<ServiceType> selectedServices;

    /**
     * Constructor initializes an empty list of selected services.
     */
    public AddOnService() {
        this.selectedServices = new ArrayList<>();
    }

    /**
     * Adds a service to the selection.
     *
     * @param service the service to add
     */
    public void addService(ServiceType service) {
        selectedServices.add(service);
        System.out.println("Added: " + service.getDescription() + " (Rs." + service.getPrice() + ")");
    }

    /**
     * Calculates total cost of all selected add-on services.
     *
     * @return total cost of services
     */
    public double getTotalServiceCost() {
        double total = 0;
        for (ServiceType service : selectedServices) {
            total += service.getPrice();
        }
        return total;
    }

    /**
     * Displays all selected services.
     */
    public void displaySelectedServices() {
        System.out.println("=== Selected Add-On Services ===");
        if (selectedServices.isEmpty()) {
            System.out.println("No add-on services selected.");
        } else {
            for (ServiceType service : selectedServices) {
                System.out.println("- " + service.getDescription() + ": Rs." + service.getPrice());
            }
            System.out.println("Total Service Cost: Rs." + getTotalServiceCost());
        }
    }

    /**
     * Main method to demonstrate add-on service selection.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Add-On Services ===");
        System.out.println("Available Services:");
        for (ServiceType service : ServiceType.values()) {
            System.out.println("  " + service.getDescription() + " - Rs." + service.getPrice());
        }
        System.out.println();

        AddOnService guestServices = new AddOnService();
        guestServices.addService(ServiceType.BREAKFAST);
        guestServices.addService(ServiceType.SPA);
        guestServices.addService(ServiceType.AIRPORT_PICKUP);
        System.out.println();
        guestServices.displaySelectedServices();
    }
}
