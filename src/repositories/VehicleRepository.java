package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    // we can have a map as a database to retrieve data
    Map<String, Vehicle> vehicleStore;
    public VehicleRepository(){
        this.vehicleStore = new HashMap<>();
    }

    public Vehicle addVehicle(Vehicle vehicle){
        vehicleStore.put(vehicle.getNumber(), vehicle);
        return vehicle;
    }

    public Vehicle getVehicle(String number){
        return vehicleStore.get(number);
    }
}
