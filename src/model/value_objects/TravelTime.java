package model.value_objects;

public class TravelTime {

    private int idSource;

    private int idDestine;

    private int hour;

    private double meanTime;

    private double standardDeviation;


    public TravelTime(int idSource, int idDestine, int hour, double meanTime, double standardDeviation) {
        this.idSource = idSource;
        this.idDestine = idDestine;
        this.hour = hour;
        this.meanTime = meanTime;
        this.standardDeviation = standardDeviation;
    }

    public int getIdSource() {
        return idSource;
    }

    public int getIdDestine() {
        return idDestine;
    }

    public int getHour() {
        return hour;
    }

    public double getMeanTime() {
        return meanTime;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public String toString(){

        return "" + meanTime;
    }
}