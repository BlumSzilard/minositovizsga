package flights;

public class Flight {
    private String airline;
    private String departure;
    private String arrival;
    private int numberOfPassengers;

    public Flight(String airline, String departure, String arrival, int numberOfPassengers) {
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getAirline() {
        return airline;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
