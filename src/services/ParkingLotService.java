package services;

import models.Gate;
import models.ParkingSpot;
import models.Vehicle;
import repositories.ParkingLotRepository;
import strategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLotService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    public ParkingLotService(SpotAssignmentStrategy spotAssignmentStrategy,
                             ParkingLotRepository parkingLotRepository
                             ){
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle, Gate gate){
        List<ParkingSpot> parkingSpotList = parkingLotRepository.getAllParkingSpot();
        return spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(),gate, parkingSpotList);
    }
}
