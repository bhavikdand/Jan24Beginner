package machine_coding.parking_lot;

import machine_coding.parking_lot.controllers.TicketController;
import machine_coding.parking_lot.dtos.GenerateTicketRequestDto;
import machine_coding.parking_lot.dtos.GenerateTicketResponseDto;
import machine_coding.parking_lot.models.*;
import machine_coding.parking_lot.repositories.GateRepository;
import machine_coding.parking_lot.repositories.ParkingLotRepository;
import machine_coding.parking_lot.repositories.TicketRepository;
import machine_coding.parking_lot.repositories.VehicleRepository;
import machine_coding.parking_lot.services.GateService;
import machine_coding.parking_lot.services.TickerServiceImpl;
import machine_coding.parking_lot.services.TicketService;
import machine_coding.parking_lot.strategies.spot_assignment.AssignSpotStrategy;
import machine_coding.parking_lot.strategies.spot_assignment.NearestFirstSpotAssignmentStrategy;

import java.util.*;

public class ParkingLotRunner {

    public static void main(String[] args) {

        Gate gate1 = new Gate();
        gate1.setGateType(GateType.ENTRY);
        gate1.setName("1A");
        gate1.setOperator(new Operator());
        gate1.setId(1);

        Gate gate2 = new Gate();
        gate2.setId(2);
        gate2.setOperator(new Operator());
        gate2.setName("4Z");
        gate2.setGateType(GateType.EXIT);

        Map<Integer, Gate> gateMap = new HashMap<Integer, Gate>(){{
            put(1, gate1);
            put(2, gate2);
        }};

        List<Spot> spots = Arrays.asList(new Spot("1A", SpotStatus.UNOCCUPIED, VehicleType.CAR)
                //, new Spot("1B", SpotStatus.UNOCCUPIED, VehicleType.CAR)
                );
        List<Section> sections = new ArrayList<>();
        Section section = new Section();
        section.setName("AA");
        section.setId(1);
        section.setSpots(spots);
        sections.add(section);

        List<Floor> floors = new ArrayList<>();
        Floor floor = new Floor();
        floor.setFloorNum(1);
        floor.setFloorStatus(FloorStatus.OPERATIONAL);
        floor.setSections(sections);
        floor.setId(1);
        floors.add(floor);

        List<Gate> gates = Arrays.asList(gate1, gate2);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setFloors(floors);
        parkingLot.setGates(gates);
        parkingLot.setId(1);

        Map<Integer, ParkingLot> parkingLotMap = new HashMap<Integer, ParkingLot>(){{
            put(1, parkingLot);
        }};


        GateRepository gateRepository = new GateRepository(gateMap);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLotMap);
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        GateService gateService = new GateService(gateRepository);
        AssignSpotStrategy assignSpotStrategy  = new NearestFirstSpotAssignmentStrategy();
        TicketService ticketService = new TickerServiceImpl(gateService, vehicleRepository, assignSpotStrategy, parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        // Create objects of generateticketrequestdto and call generateTicket method;
        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(1);
        requestDto.setVehicleType(VehicleType.CAR.toString());
        requestDto.setVehicleNumber("KA 05 1234");

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        System.out.println(responseDto);


        requestDto.setVehicleNumber("KA 05 6789");
        responseDto = ticketController.generateTicket(requestDto);
        System.out.println(responseDto);

    }
}
