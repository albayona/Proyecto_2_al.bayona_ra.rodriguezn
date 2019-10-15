package model.logic;


import model.data_structures.DoublyLinkedList;
import model.data_structures.Queue;
import model.value_objects.RoadNode;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;

/**
 * Definicion del modelo del mundo
 */
public class MVCModel {

    private DoublyLinkedList<TravelArea> areasData;
    private DoublyLinkedList<RoadNode> roadNodesData;
    private DoublyLinkedList<TravelTime> travelTimesData;


    public MVCModel() {
        areasData = new DoublyLinkedList<>();
        roadNodesData = new DoublyLinkedList<>();
        travelTimesData = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<TravelArea> areasData() {
        return areasData;
    }

    public DoublyLinkedList<RoadNode> roadNodesData() {
        return roadNodesData;
    }

    public DoublyLinkedList<TravelTime> travelTimesData() {
        return travelTimesData;
    }

    public void loadData(int trimester) {

        DataLoader d = new DataLoader();

        d.loadTravelAreas(areasData);
        d.loadRoadNodes(roadNodesData);
        d.loadTravelTimes(travelTimesData, trimester);
    }

    public static void main(String[] args)
    {
        MVCModel model = new MVCModel();
        model.loadData(2);
        model.areasData();


    }
    
    public Queue A1(int num) {
    	return null;
    }
    
    public Queue A2(double latitud, double longitud) {
    	return null;
    }

    public Queue A3(double latitud, double longitud,int num) {
    	return null;
    }

    public Queue B1(int num) {
    	return null;
    }


    public Queue B2(double latitud, double longitud) {
    	return null;
    }


    public Queue B3(double latitud, double longitud, int num) {
    	return null;
    }


    public Queue C1(int id,int hour) {
    	return null;
    }

    public Queue C2(int id,int hourIni,int hourFin) {
    	return null;
    }

    public Queue C3(int num) {
    	return null;
    }

    public int[] C4() {
    	int[] ans = null;
    	return ans;
    }


}