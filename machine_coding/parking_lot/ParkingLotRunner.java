package machine_coding.parking_lot;

import machine_coding.parking_lot.controllers.TicketController;
import machine_coding.parking_lot.models.Gate;
import machine_coding.parking_lot.models.GateType;
import machine_coding.parking_lot.models.Operator;
import machine_coding.parking_lot.repositories.GateRepository;
import machine_coding.parking_lot.repositories.ParkingLotRepository;
import machine_coding.parking_lot.repositories.TicketRepository;
import machine_coding.parking_lot.repositories.VehicleRepository;
import machine_coding.parking_lot.services.GateService;
import machine_coding.parking_lot.services.TickerServiceImpl;
import machine_coding.parking_lot.services.TicketService;
import machine_coding.parking_lot.strategies.spot_assignment.AssignSpotStrategy;
import machine_coding.parking_lot.strategies.spot_assignment.NearestFirstSpotAssignmentStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRunner {

    public static void main(String[] args) {

        Gate gate1 = new Gate();
        gate1.setGateType(GateType.ENTRY);
        gate1.setName("1A");
        gate1.setOperator(new Operator());
        gate1.setId(1);

        Map<Integer, Gate> gateMap = new HashMap<>(){{
            put(1, gate1);
        }};


        GateRepository gateRepository = new GateRepository(gateMap);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(); // Homework
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        GateService gateService = new GateService(gateRepository);
        AssignSpotStrategy assignSpotStrategy  = new NearestFirstSpotAssignmentStrategy();
        TicketService ticketService = new TickerServiceImpl(gateService, vehicleRepository, assignSpotStrategy, parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        // Create objects of generateticketrequestdto and call generateTicket method;



    }
}
