package strategy;

import models.Gate;
import models.ParkingSpot;
import models.ParkingSpotStatus;
import models.VehicleType;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType type, Gate gate, List<ParkingSpot> parkingSpotList) {
        for(ParkingSpot spot: parkingSpotList){
            if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) &&
            spot.getVehicleTypes().contains(type)){
                return spot;
            }
        }
        return null;
    }
}
