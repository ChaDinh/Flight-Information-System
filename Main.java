import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of flights: ");
        int number_of_flights = scanner.nextInt();
        Flight[] flights = new Flight[number_of_flights];

        // input loop numbers of flights
        for (int i = 0; i < number_of_flights; i++) {
            System.out.println("Enter information for flight " + (i + 1) + ": ");
            String airline_name = getValidAirlineInput(scanner, "Airline name: ");
            String flight_number = getValidFlightNumber(scanner);
            String flight_origin = getValidAirportLocation(scanner, "Flight from: ");
            String flight_destination = getValidAirportLocation(scanner, "Flight to: ");
            int flight_duration = getValidIntInput(scanner, "Flight duration (Hours): ");
            double airfare = getValidDoubleInput(scanner, "Price of flight ($): ");
            String departure_time = getStringInput(scanner, "Departure time (HH:mm/dd-MM-yyyy): ");
            String arrival_time = getStringInput(scanner, "Arrival time (HH:mm/dd-MM-yyyy): ");
            double flight_distance = getValidDoubleInput(scanner, "Flight distance (KM): ");
            int seats_available = getValidIntInput(scanner, "Seats available : ");

            // flight object created with the provided information
            flights[i] = new Flight(airline_name, flight_number, flight_origin, flight_destination, flight_duration, airfare, departure_time, arrival_time, flight_distance, seats_available);
        }

        // flights pre-sort
        System.out.println("Flight list pre-sort: ");
        for (Flight flight : flights) {
            System.out.println(flight);
        }

        // sort flights
        Arrays.sort(flights, (f1, f2) -> f1.getFlight_number().compareTo(f2.getFlight_number()));

        // flights sorted
        System.out.println("Flight list after sorting: ");
        for (Flight flight : flights) {
            System.out.println(flight);
        }

        // create the GUI
        new Form1(flights);
    }
        //validate to get valid airline name
    private static String getValidAirlineInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.next();
            if (input.matches("^[A-Za-z0-9 ]+$")) { // allow letters, numbers, and spaces
                break;
            } else {
                System.out.println("Invalid input. Only letters and spaces are allowed.");
            }
        }
        return input;
    }
    //validate to get valid origin and destination
    private static String getValidAirportLocation(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.next();
            if (input.matches("^[A-Za-z0-9 ]+$")) { // allow letters, numbers, and spaces by regex
                break;
            } else {
                System.out.println("Invalid input. Only letters and spaces are allowed.");
            }
        }
        return input;
    }
    //get valid flight number
    private static String getValidFlightNumber(Scanner scanner) {
        String flight_number;
        while (true) {
            System.out.print("Flight number: ");
            flight_number = scanner.next();
            if (flight_number.matches("^[A-Z0-9]{5}$")) {
                break;
            } else {
                System.out.println("Invalid flight number. It should be 5 alphanumeric characters and capital letters.");
            }
        }
        return flight_number;
    }
    //all integer input validate at one
    private static int getValidIntInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) { // allow positive values
                    break;
                } else {
                    System.out.println("Value must be higher than 0 .");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear invalid input
            }
        }
        return value;
    }
    //all double input validate at one
    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) { // only for numbers higher than 0
                    break;
                } else {
                    System.out.println("Value must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }
    //get string input from console
    private static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
