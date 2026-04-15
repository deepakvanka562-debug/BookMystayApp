import java.util.LinkedList;
import java.util.Queue;

/**
 * ConcurrentBookingSimulator - Demonstrates concurrent booking requests
 * using Java threads and synchronization to avoid race conditions.
 * UC11: Concurrent Booking Simulation
 *
 * @author Devarasetty-Pratikesh
 * @version 1.0
 */
public class ConcurrentBookingSimulator {

    /**
     * SharedBookingQueue - A thread-safe queue for booking requests.
     * Uses synchronized methods to prevent concurrent access issues.
     */
    static class SharedBookingQueue {
        private final Queue<String> requestQueue = new LinkedList<>();
        private int processedCount = 0;

        /**
         * Adds a booking request to the shared queue (thread-safe).
         *
         * @param guestName name of the guest
         */
        public synchronized void addRequest(String guestName) {
            requestQueue.offer(guestName);
            System.out.println("[QUEUED]    Guest: " + guestName +
                               " | Thread: " + Thread.currentThread().getName());
        }

        /**
         * Processes the next request in the queue (thread-safe).
         */
        public synchronized void processNext() {
            if (!requestQueue.isEmpty()) {
                String guest = requestQueue.poll();
                processedCount++;
                System.out.println("[PROCESSED] Guest: " + guest +
                                   " | Thread: " + Thread.currentThread().getName() +
                                   " | Total Processed: " + processedCount);
            }
        }

        public synchronized int getProcessedCount() { return processedCount; }
        public synchronized int getQueueSize() { return requestQueue.size(); }
    }

    /**
     * GuestThread - Simulates a guest submitting a booking request.
     */
    static class GuestThread extends Thread {
        private final SharedBookingQueue queue;
        private final String guestName;

        public GuestThread(SharedBookingQueue queue, String guestName) {
            super("GuestThread-" + guestName);
            this.queue = queue;
            this.guestName = guestName;
        }

        @Override
        public void run() {
            queue.addRequest(guestName);
        }
    }

    /**
     * ProcessorThread - Simulates the booking processor consuming requests.
     */
    static class ProcessorThread extends Thread {
        private final SharedBookingQueue queue;
        private final int requestsToProcess;

        public ProcessorThread(SharedBookingQueue queue, int count) {
            super("ProcessorThread");
            this.queue = queue;
            this.requestsToProcess = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < requestsToProcess; i++) {
                queue.processNext();
                try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        }
    }

    /**
     * Main method to demonstrate concurrent booking simulation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== BookMyStay - Concurrent Booking Simulation ===");
        System.out.println("Simulating 5 guests booking simultaneously...");
        System.out.println();

        SharedBookingQueue sharedQueue = new SharedBookingQueue();

        // Create 5 guest threads to simulate concurrent bookings
        String[] guests = {"Alice", "Bob", "Charlie", "Diana", "Evan"};
        Thread[] guestThreads = new Thread[guests.length];
        for (int i = 0; i < guests.length; i++) {
            guestThreads[i] = new GuestThread(sharedQueue, guests[i]);
        }

        // Start all guest threads simultaneously
        for (Thread t : guestThreads) t.start();

        // Wait for all guests to submit requests
        for (Thread t : guestThreads) t.join();

        System.out.println();
        System.out.println("Queue size after submissions: " + sharedQueue.getQueueSize());
        System.out.println();

        // Process all requests with the processor thread
        ProcessorThread processor = new ProcessorThread(sharedQueue, guests.length);
        processor.start();
        processor.join();

        System.out.println();
        System.out.println("=== Simulation Complete ===");
        System.out.println("Total processed: " + sharedQueue.getProcessedCount());
        System.out.println("Remaining in queue: " + sharedQueue.getQueueSize());
    }
}
