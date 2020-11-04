import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkplatzServiceTest {

    public static final String PARKING_LOT_NAME = "My parking lot";
    public static final ParkingLot PARKING_LOT_WITH_EMPTY_SPACES =
            new ParkingLot(PARKING_LOT_NAME, 49.45d, 11.08d, 1500, 160, 150);
    public static final ParkingLot PARKING_LOT_WITHOUT_EMPTY_SPACES =
            new ParkingLot("My parking lot strikes back", 49.12d, 112.08d, 150, 16, 0);
    public static final List<ParkingLot> INITIAL_PARKPLATZ_LIST = List.of(
            PARKING_LOT_WITH_EMPTY_SPACES,
            PARKING_LOT_WITHOUT_EMPTY_SPACES
    );

    @Test
    void testListOfParkplatzWithEmptySpaces() {
        ParkplatzService service = new ParkplatzService(INITIAL_PARKPLATZ_LIST);
        assertEquals(List.of(PARKING_LOT_WITH_EMPTY_SPACES), service.listEmptyParkplatz());
    }

    @Test
    void testCreateParkingLot() {
        ParkplatzService service = new ParkplatzService(INITIAL_PARKPLATZ_LIST);
        ParkingLot newParkingLot = new ParkingLot("JA Parking Lot", 2.123d, 43.1d, 1, 12341, 1234);
        service.createParkingLot(newParkingLot);
        List<ParkingLot> expected = new ArrayList<>(INITIAL_PARKPLATZ_LIST);
        expected.add(newParkingLot);
        assertEquals(expected, service.listAllParkplatz());
    }

    @Test
    void testListAllParkingLots() {
        ParkplatzService service = new ParkplatzService(INITIAL_PARKPLATZ_LIST);
        assertEquals(INITIAL_PARKPLATZ_LIST, service.listAllParkplatz());
    }

    @Test
    void testCarEntersParkingLot() {
        ParkplatzService service = new ParkplatzService(INITIAL_PARKPLATZ_LIST);
        service.carEntersParkingLot(PARKING_LOT_NAME);
        assertEquals(149, service.listAllParkplatz().get(0).getFreePlacesCount());
    }

    @Test
    void testCarLeavesParkingLot() {
        ParkplatzService service = new ParkplatzService(INITIAL_PARKPLATZ_LIST);
        service.carLeavesParkingLot(PARKING_LOT_NAME);
        assertEquals(151, service.listAllParkplatz().get(0).getFreePlacesCount());
    }
}
