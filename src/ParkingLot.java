import java.util.Objects;

public class ParkingLot {
    private final String name;
    private final double latitude;
    private final double longitude;
    private final int pricePerHour;
    private final int totalPlacesCount;
    private int freePlacesCount;

    public ParkingLot(String name, double latitude, double longitude, int pricePerHour, int totalPlacesCount,
                      int freePlacesCount) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pricePerHour = pricePerHour;
        this.totalPlacesCount = totalPlacesCount;
        this.freePlacesCount = freePlacesCount;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public int getTotalPlacesCount() {
        return totalPlacesCount;
    }

    public int getFreePlacesCount() {
        return freePlacesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
