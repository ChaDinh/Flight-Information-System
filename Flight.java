public class Flight {
    // instance variables to store flight details
    private String airline_name;
    private String flight_number;
    private String flight_origin;
    private String flight_destination;
    private int flight_duration;
    private double airfare;
    private String departure_time;
    private String arrival_time;
    private double fight_distance;
    private int seats_available;
    //constructor of flight class
    public Flight(String airline_name, String flight_number, String flight_origin, String flight_destination, int flight_duration, double airfare, String departure_time, String arrival_time, double fight_distance, int seats_available) {
        this.airline_name = airline_name; //set airline name
        this.flight_number = flight_number; //set flight number
        this.flight_origin = flight_origin; //set ...
        this.flight_destination = flight_destination;
        this.flight_duration = flight_duration;
        this.airfare = airfare;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.fight_distance = fight_distance;
        this.seats_available = seats_available;
    }
    // getter and setter method
    public String getAirline_name() { //getter
        return airline_name;
    }
    public void setAirline_name(String airline_name) {  //setter
        this.airline_name = airline_name;
    }
    public String getFlight_number() {
        return flight_number;
    }
    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }
    public String getFlight_origin() {
        return flight_origin;
    }
    public void setFlight_origin(String flight_origin) {
        this.flight_origin = flight_origin;
    }
    public String getFlight_destination() {
        return flight_destination;
    }
    public void setFlight_destination(String flight_destination) {
        this.flight_destination = flight_destination;
    }
    public int getFlight_duration() {
        return flight_duration;
    }
    public void setFlight_duration(int flight_duration) {
        this.flight_duration = flight_duration;
    }
    public double getAirfare() {
        return airfare;
    }
    public void setAirfare(double airfare) {
        this.airfare = airfare;
    }
    public String getDeparture_time() {
        return departure_time;
    }
    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }
    public String getArrival_time() {
        return arrival_time;
    }
    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }
    public double getFight_distance() {
        return fight_distance;
    }
    public void setFight_distance(double fight_distance) {
        this.fight_distance = fight_distance;
    }
    public int getSeats_available() {
        return seats_available;
    }
    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available;
    }
    //toString method to return a string representation of the Flight object
    public String toString() {
        return "Flight {Airline Name = " + airline_name + ", Flight Number = " + flight_number + ", Origin City = " + flight_origin + ", Destination City = " + flight_destination + ", Airfare = " + airfare + ", Departure Time = " + departure_time + ", Arrival Time = " + arrival_time + ", Distance = " + fight_distance + ", Duration = " + flight_duration + ", Seats Available = " + seats_available + "}";
    }
}
