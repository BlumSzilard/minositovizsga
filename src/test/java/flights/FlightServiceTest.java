package flights;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {

    @Test
    void testReadFromFile() {
        FlightService flightService = new FlightService(Path.of("src/test/resources/data.csv"));

        assertEquals(7, flightService.getFlights().size());
        assertEquals(List.of("Air France", "KLM", "KLM", "British Airways", "Air France", "Lufthansa", "KLM"),
                flightService.getFlights().stream().map(Flight::getAirline).toList());
    }

    @Test
    void testSumOfPassengers() {
        FlightService flightService = new FlightService(Path.of("src/test/resources/data.csv"));

        assertEquals(659, flightService.sumOfPassengersByAirline("KLM"));
    }
}
