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
    private DoublyLinkedList<TravelTime> travelTimesData1;
    private DoublyLinkedList<TravelTime> travelTimesData2;


    public MVCModel() {
        areasData = new DoublyLinkedList<>();
        roadNodesData = new DoublyLinkedList<>();
        travelTimesData1 = new DoublyLinkedList<>();
        travelTimesData2 = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<TravelArea> areasData() {
        return areasData;
    }

    public DoublyLinkedList<RoadNode> roadNodesData() {
        return roadNodesData;
    }

    public DoublyLinkedList<TravelTime> travelTimesDataByTrimester(int trimester) {

        if (trimester == 1) return travelTimesData1;
        else if(trimester == 2) return travelTimesData2;

        return null;
    }

    public void loadData() {

        DataLoader d = new DataLoader();

        d.loadTravelAreas(areasData);
        d.loadRoadNodes(roadNodesData);
        d.loadTravelTimes(travelTimesData1, 1);
        d.loadTravelTimes(travelTimesData2, 2);
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