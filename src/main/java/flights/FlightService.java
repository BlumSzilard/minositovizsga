package flights;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
    private List<Flight> flights = new ArrayList<>();

    public FlightService(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            lines.remove(0);
            for (String line : lines) {
                String[] parts = line.split(";");
                String airline = parts[0];
                String[] departureAndArrival = parts[1].split("-");
                String departure = departureAndArrival[0];
                String arrival = departureAndArrival[1];
                String numberOfPassengers = parts[2];
                flights.add(new Flight(airline, departure, arrival, Integer.parseInt(numberOfPassengers)));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public int sumOfPassengersByAirline(String airline) {
        int sum = 0;
        for (Flight flight : flights) {
            if (flight.getAirline().equals(airline)) {
                sum += flight.getNumberOfPassengers();
            }
        }
        return sum;
    }
}
