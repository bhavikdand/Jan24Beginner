package machine_coding.parking_lot.repositories;

import machine_coding.parking_lot.models.Slab;
import machine_coding.parking_lot.models.VehicleType;

import java.util.*;

public class SlabRepository {
    private Map<Integer, Slab> map;

    public SlabRepository(Map<Integer, Slab> map) {
        this.map = map;
    }

    public SlabRepository() {
        this.map = new HashMap<>();
    }

    public List<Slab> getSlabsByVehicleType(VehicleType vehicleType){
        List<Slab> slabs = new ArrayList<>();
        for (Map.Entry<Integer, Slab> entry : this.map.entrySet()) {
            Slab slab = entry.getValue();
            if(slab.getVehicleType().equals(vehicleType)){
                slabs.add(slab);
            }
        }
        slabs.sort((o1, o2) -> o1.getStartHour() - o2.getStartHour());
        return slabs;
    }
}
