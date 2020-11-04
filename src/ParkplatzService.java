import java.util.List;
import java.util.stream.Collectors;

public class ParkplatzService {

    private final List<ParkingLot> parkplatzList;

    public ParkplatzService(List<ParkingLot> parkplatzList) {
        this.parkplatzList = parkplatzList.stream().map(ParkingLot::copy).collect(Collectors.toList());
    }

    public List<ParkingLot> listEmptyParkplatz() {
        return parkplatzList.stream().filter(pl -> pl.getFreePlacesCount() > 0).collect(Collectors.toList());
    }

    public void createParkingLot(ParkingLot parkingLot) {
        parkplatzList.add(parkingLot);
    }

    public List<ParkingLot> listAllParkplatz() {
        return parkplatzList;
    }

    public void carEntersParkingLot(String parkingLotName) {
        parkplatzList.stream()
                .filter(parkingLot -> parkingLot.getName().equals(parkingLotName))
                .findFirst()
                .ifPresent(ParkingLot::decreaseFreePlaces);
    }

    public void carLeavesParkingLot(String parkingLotName) {
        parkplatzList.stream()
                .filter(parkingLot -> parkingLot.getName().equals(parkingLotName))
                .findFirst()
                .ifPresent(ParkingLot::increaseFreePlaces);
    }
}
