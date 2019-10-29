package model.value_objects;

public class TravelArea {

   private  String name;
   private  double perimeter;
   private  double area;
   private int ID;
   private GeoCoordinate[] frontier;
   private double maxLatitud;
   private double maxLongitud;


    public TravelArea(String name, double perimeter, double area, int ID, GeoCoordinate[] frontier) {
        this.name = name;
        this.perimeter = perimeter;
        this.area = area;
        this.ID = ID;
        this.frontier = frontier;
        maxLongitud = frontier[0].getLongitude();
        
        double max = frontier[0].getLatitude();
        for(int i=1;i<frontier.length;i++){
        	if(max < frontier[i].getLatitude() ){
        		max = frontier[i].getLatitude();
        		maxLongitud = frontier[i].getLongitude();
        	}
        }
        maxLatitud = max;
    }

    public String getName() {
        return name;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public int getID() {
        return ID;
    }

    public GeoCoordinate[] getFrontier() {
        return frontier;
    }
    
    public double getMaxLatitude(){
    	return maxLatitud;
    }
    
    public double getMaxLongitud(){
    	return maxLongitud;
    }
}
