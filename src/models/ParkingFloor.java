package models;

import java.util.List;

public class ParkingFloor extends BaseEntity{
    private int number;
    private List<ParkingSpot> parkingSpots;

    private ParkingfloorStatus parkingfloorStatus;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingfloorStatus getParkingfloorStatus() {
        return parkingfloorStatus;
    }

    public void setParkingfloorStatus(ParkingfloorStatus parkingfloorStatus) {
        this.parkingfloorStatus = parkingfloorStatus;
    }
}
