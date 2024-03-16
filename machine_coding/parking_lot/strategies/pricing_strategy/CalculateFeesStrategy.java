package machine_coding.parking_lot.strategies.pricing_strategy;

import machine_coding.parking_lot.models.VehicleType;

import java.util.Date;

public interface CalculateFeesStrategy {

    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType);
}
