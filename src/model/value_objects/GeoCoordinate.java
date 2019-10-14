package model.value_objects;


public class GeoCoordinate {

    private double latitude;
    private double longitude;

    public GeoCoordinate(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    public String toString() {
        return "Latitud: " + latitude + " | Longitud: " + longitude;
    }


}
