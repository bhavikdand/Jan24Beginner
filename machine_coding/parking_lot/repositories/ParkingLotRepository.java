package machine_coding.parking_lot.repositories;

import machine_coding.parking_lot.models.Gate;
import machine_coding.parking_lot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Integer, ParkingLot> map;

    public ParkingLotRepository(Map<Integer, ParkingLot> map) {
        this.map = map;
    }

    public ParkingLotRepository(){
        this.map = new HashMap<>();
    }

    public ParkingLot getParkingLotByGateId(int gateId){
        for (Map.Entry<Integer, ParkingLot> entry : map.entrySet()) {
            ParkingLot parkingLot = entry.getValue();
            for (Gate gate : parkingLot.getGates()) {
                if(gate.getId() == gateId){
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
