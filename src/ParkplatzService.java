import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkplatzService {

    private final List<ParkingLot> parkplatzList;

    public ParkplatzService(List<ParkingLot> parkplatzList) {
        this.parkplatzList = new ArrayList<>(parkplatzList);
    }

    public List<ParkingLot> listEmptyParkplatz() {
        return parkplatzList.stream().filter(pl -> pl.getFreePlacesCount() > 0).collect(Collectors.toList());
    }

    public void createParkingLot(ParkingLot parkingLot) {
        parkplatzList.add(parkingLot);
    }
}
