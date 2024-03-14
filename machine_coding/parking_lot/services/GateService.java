package machine_coding.parking_lot.services;

import machine_coding.parking_lot.models.Gate;
import machine_coding.parking_lot.repositories.GateRepository;

public class GateService {

    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGateById(int gateId){
        return gateRepository.getGateById(gateId);
    }
}
