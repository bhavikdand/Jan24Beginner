package machine_coding.parking_lot.models;

public class Slab extends BaseModel{

    private VehicleType vehicleType;
    private int startHour;
    private int endHour;
    private double pricePerHour;

    public Slab(int id, VehicleType vehicleType, int startHour, int endHour, double pricePerHour) {
        setId(id);
        this.vehicleType = vehicleType;
        this.startHour = startHour;
        this.endHour = endHour;
        this.pricePerHour = pricePerHour;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
