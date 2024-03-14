package machine_coding.parking_lot.models;

import java.util.List;

public class Section extends BaseModel{
    private String name;
    private List<Spot> spots;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }
}
