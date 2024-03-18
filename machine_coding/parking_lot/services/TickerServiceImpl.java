package machine_coding.parking_lot.services;

import machine_coding.parking_lot.models.*;
import machine_coding.parking_lot.repositories.GateRepository;
import machine_coding.parking_lot.repositories.ParkingLotRepository;
import machine_coding.parking_lot.repositories.TicketRepository;
import machine_coding.parking_lot.repositories.VehicleRepository;
import machine_coding.parking_lot.strategies.spot_assignment.AssignSpotStrategy;

import java.util.Date;

public class TickerServiceImpl implements TicketService{

    private GateService gateService;
    private VehicleRepository vehicleRepository;
    private AssignSpotStrategy assignSpotStrategy;
    private ParkingLotRepository parkingLotRepository;

    private TicketRepository ticketRepository;

    public TickerServiceImpl(GateService gateService, VehicleRepository vehicleRepository, AssignSpotStrategy assignSpotStrategy, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateService = gateService;
        this.vehicleRepository = vehicleRepository;
        this.assignSpotStrategy = assignSpotStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateTicket(int gateId, String vehicleNumber, String vehicleType) throws Exception {

        /*
        1. Using gate id, get the date object
        2. Do a createIfNotExists on the vehicle object
        3. Using strategy pattern, figure out an empty spot or throw an error
        4. create a ticket object and store it in db
         */
        Gate gate = gateService.getGateById(gateId);
        VehicleType type = VehicleType.getTypeFromStr(vehicleType);
        Vehicle vehicle = vehicleRepository.createIfNotExists(vehicleNumber, type);
        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGateId(gateId);
        if (parkingLot == null) {
            throw new Exception("Invalid gate id");
        }

        Spot spot = assignSpotStrategy.assignSpot(type, parkingLot);
        Ticket ticket = new Ticket();
        ticket.setAssignedSpot(spot);
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        return ticketRepository.insertTicket(ticket);
    }

    @Override
    public Ticket getTicketById(int ticketId) {
        return ticketRepository.getTicketById(ticketId);
    }
}
