/**
 * InputValidator - Provides structured validation and error handling.
 * UC9: Error Handling & Validation
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class InputValidator {

    /**
     * Validates that a guest name is not null or empty.
     *
     * @param name the guest name to validate
     * @throws IllegalArgumentException if name is null or empty
     */
    public static void validateGuestName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Guest name cannot be null or empty.");
        }
    }

    /**
     * Validates that number of nights is a positive integer.
     *
     * @param nights number of nights
     * @throws IllegalArgumentException if nights <= 0
     */
    public static void validateNumberOfNights(int nights) {
        if (nights <= 0) {
            throw new IllegalArgumentException("Number of nights must be greater than zero.");
        }
    }

    /**
     * Validates that a room type is one of the allowed types.
     *
     * @param roomType the room type to validate
     * @throws IllegalArgumentException if room type is invalid
     */
    public static void validateRoomType(String roomType) {
        if (roomType == null) {
            throw new IllegalArgumentException("Room type cannot be null.");
        }
        String type = roomType.toUpperCase();
        if (!type.equals("SINGLE") && !type.equals("DOUBLE") && !type.equals("SUITE")) {
            throw new IllegalArgumentException(
                "Invalid room type: '" + roomType + "'. Allowed types: SINGLE, DOUBLE, SUITE"
            );
        }
    }

    /**
     * Validates that price is non-negative.
     *
     * @param price the price to validate
     * @throws IllegalArgumentException if price < 0
     */
    public static void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }

    /**
     * Validates a BookingRequest object.
     *
     * @param request the booking request to validate
     */
    public static void validateBookingRequest(BookingRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Booking request cannot be null.");
        }
        validateGuestName(request.getGuestName());
        validateRoomType(request.getRoomType());
        validateNumberOfNights(request.getNumberOfNights());
    }

    /**
     * Main method to demonstrate error handling and validation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== BookMyStay - Error Handling & Validation ===");

        // Test valid input
        try {
            validateGuestName("Pratikesh");
            validateRoomType("DOUBLE");
            validateNumberOfNights(3);
            System.out.println("[PASS] All validations passed for valid input.");
        } catch (IllegalArgumentException e) {
            System.out.println("[FAIL] " + e.getMessage());
        }

        // Test invalid guest name
        try {
            validateGuestName("");
            System.out.println("[FAIL] Should have thrown exception for empty name.");
        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Caught invalid guest name: " + e.getMessage());
        }

        // Test invalid room type
        try {
            validateRoomType("PENTHOUSE");
            System.out.println("[FAIL] Should have thrown exception for invalid room type.");
        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Caught invalid room type: " + e.getMessage());
        }

        // Test invalid nights
        try {
            validateNumberOfNights(-1);
            System.out.println("[FAIL] Should have thrown exception for negative nights.");
        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Caught invalid nights: " + e.getMessage());
        }

        System.out.println("\nValidation tests completed.");
    }
}
