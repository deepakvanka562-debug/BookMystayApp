# BookMyStayApp

A Java-based hotel room booking simulation application developed as part of the SRM STEP Program. The project follows a use-case-driven development approach, progressively building a full-featured booking system through 12 use cases.

## Project Overview

BookMyStayApp simulates a hotel room reservation system that handles room inventory management, booking requests, add-on services, error handling, concurrent bookings, booking cancellations, and data persistence. Each use case is developed on its own Git branch and merged into `main` via pull requests.


## Use Cases

| Branch | Use Case | Description |
|--------|----------|-------------|
| `uc1`  | UC1 - Application Entry & Welcome Message | Entry point with a welcome message |
| `uc2`  | UC2 - Basic Room Types & Static Attributes | Room class with type, price, availability |
| `uc3`  | UC3 - Centralized Room Inventory | Inventory management with default rooms |
| `uc4`  | UC4 - Room Search & Availability Check | Search rooms by type and check availability |
| `uc5`  | UC5 - Booking Request | Guest booking request with stay details |
| `uc6`  | UC6 - Reservation Confirmation & Summary | Booking confirmation with ID and cost |
| `uc7`  | UC7 - Add-On Service Selection | Add-on services like breakfast, spa, etc. |
| `uc8`  | UC8 - Booking History & Reporting | Track and display booking history |
| `uc9`  | UC9 - Error Handling & Validation | Input validation and error handling |
| `uc10` | UC10 - Booking Cancellation & Inventory Rollback | Cancel bookings and restore inventory |
| `uc11` | UC11 - Concurrent Booking Simulation | Thread-safe concurrent booking using synchronization |
| `uc12` | UC12 - Data Persistence & System Recovery | File-based persistence and state recovery on restart |


## Key Concepts Covered

- **Object-Oriented Programming** - Classes, objects, encapsulation, inheritance
- **Collections Framework** - ArrayList, HashMap for inventory and booking data
- **Multithreading** - Synchronization to prevent double-booking in concurrent requests
- **File I/O & Serialization** - Persist and restore application state across restarts
- **Exception Handling** - Robust error handling and input validation
- **GitFlow Workflow** - Feature branches, pull requests, and merges

