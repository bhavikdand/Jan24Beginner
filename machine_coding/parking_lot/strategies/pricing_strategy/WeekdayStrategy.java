package machine_coding.parking_lot.strategies.pricing_strategy;

import machine_coding.parking_lot.models.VehicleType;
import machine_coding.parking_lot.utils.DateTimeUtils;

import java.util.Date;

public class WeekdayStrategy implements CalculateFeesStrategy{
    @Override
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType) {
        return DateTimeUtils.calcHours(entryTime, exitTime) * 10;
    }
}
