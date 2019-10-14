package model.value_objects;

public class RoadNode {

    private  int id;
    private  double longitude;
    private double latitude;

    public RoadNode(int id, double longitude, double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
