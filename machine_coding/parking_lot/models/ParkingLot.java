package machine_coding.parking_lot.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<Floor> floors;

    private List<Gate> gates;



    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
