package CodeClause_Internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int availableSeats;
    private double fare;
    public Flight(String flightNumber, String source, String destination, int availableSeats, double fare) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public double getFare() {
        return fare;
    }
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
    public boolean isAvailable() {
        return availableSeats > 0;
    }
    @Override
    public String toString() {
        return "Flight: " + flightNumber +
                ", Source: " + source +
                ", Destination: " + destination +
                ", Available Seats: " + availableSeats +
                ", Fare: $" + fare;
    }
}
class Reservation {
    private String passengerName;
    private Flight flight;
    public Reservation(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public Flight getFlight() {
        return flight;
    }
    @Override
    public String toString() {
        return "Passenger: " + passengerName + ", " + flight;
    }
}
public class AirlineReservationSystem {
    private List<Flight> flights;
    private List<Reservation> reservations;
    public AirlineReservationSystem() {
        flights = new ArrayList<>();
        reservations = new ArrayList<>();
    }
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
    public void displayAvailableFlights() {
        for (Flight flight : flights) {
            if (flight.isAvailable()) {
                System.out.println(flight);
            }
        }
    }
    public void bookFlight(String passengerName, String flightNumber) {
        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber) && flight.isAvailable()) {
                selectedFlight = flight;
                break;
            }
        }
        if (selectedFlight != null) {
            Reservation reservation = new Reservation(passengerName, selectedFlight);
            reservations.add(reservation);
            selectedFlight.bookSeat();
            System.out.println("Reservation successful: " + reservation);
        } else {
            System.out.println("Flight not found or no available seats.");
        }
    }
    public static void main(String[] args) {
        AirlineReservationSystem airlineSystem = new AirlineReservationSystem();
        // Add some sample flights
        airlineSystem.addFlight(new Flight("AA101", "New York", "Los Angeles", 100, 250.0));
        airlineSystem.addFlight(new Flight("UA202", "Chicago", "San Francisco", 120, 300.0));
        airlineSystem.addFlight(new Flight("DL303", "Dallas", "Miami", 80, 200.0));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAirline Reservation System Menu:");
            System.out.println("1. Display Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    airlineSystem.displayAvailableFlights();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter the flight number: ");
                    String flightNumber = scanner.nextLine();
                    airlineSystem.bookFlight(passengerName, flightNumber);
                    break;
                case 3:
                    System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}





