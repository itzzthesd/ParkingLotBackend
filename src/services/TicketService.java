package services;

import exceptions.NoParkingSpotFoundException;
import models.*;
import repositories.TicketRepository;
import strategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSpotService parkingSpotService;

    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotService parkingLotService;
    private TicketRepository ticketRepository;

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotFoundException {

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateId);

        // assign a parkiong spot using parking lot service
        ParkingSpot parkingSpot = parkingLotService.getParkingSpot(vehicle, gate);
        // make the spot as occupied
        if(parkingSpot == null){
            throw new NoParkingSpotFoundException("No parking spot available.!!");
        }
        parkingSpot = parkingSpotService.assignParkingSpot(parkingSpot);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());

        ticketRepository.save(ticket);
        return null;
    }
}
