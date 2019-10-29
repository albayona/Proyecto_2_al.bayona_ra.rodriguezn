package model.logic;


import javafx.util.Pair;
import model.data_structures.*;
import model.value_objects.GeoCoordinate;
import model.value_objects.RoadNode;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;

/**
 * Definicion del modelo del mundo
 */
public class MVCModel {

    private DoublyLinkedList<TravelArea> areasData;
    private DoublyLinkedList<RoadNode> roadNodesData;
    private DoublyLinkedList<TravelTime> travelTimesByDay1;
    private DoublyLinkedList<TravelTime> travelTimesByDay2;
    private DoublyLinkedList<TravelTime> travelTimesByMonth1;

    private  ARequirementsManager AManager;
    private  CRequirementsManager CManager;
    private  BRequirementsManager BManager;


    public MVCModel() {
        areasData = new DoublyLinkedList<>();
        roadNodesData = new DoublyLinkedList<>();
        travelTimesByDay1 = new DoublyLinkedList<>();
        travelTimesByDay2 = new DoublyLinkedList<>();
        travelTimesByMonth1 = new DoublyLinkedList<>();

        AManager = new ARequirementsManager();
        BManager = new BRequirementsManager();
        CManager = new CRequirementsManager();


    }

    public DoublyLinkedList<TravelArea> areasData() {
        return areasData;
    }

    public DoublyLinkedList<RoadNode> roadNodesData() {
        return roadNodesData;
    }

    public DoublyLinkedList<TravelTime> travelTimesByDay(int trimester) {

        if (trimester == 1) return travelTimesByDay1;
        else if(trimester == 2) return travelTimesByDay2;

        return null;
    }
    public DoublyLinkedList<TravelTime> travelTimesByMonth(int trimester) {

        if (trimester == 1) return travelTimesByMonth1;

        return null;
    }

    public void loadData() {

        DataLoader d = new DataLoader();

        d.loadTravelAreas(areasData);
        d.loadRoadNodes(roadNodesData);
        d.loadTravelTimesByDay(travelTimesByDay1, 1);
        d.loadTravelTimesByDay(travelTimesByDay2, 2);
        d.loadTravelTimesByMonth(travelTimesByMonth1,1);


    }

    public void loadRequirementsData(){
        AManager.loadA1Data(areasData);
        AManager.loadA2Data(areasData);
        CManager.loadC3Data(areasData);
        BManager.loadB2Data(roadNodesData);
        AManager.loadA3Data(travelTimesByMonth1);
        CManager.loadC4Data(travelTimesByDay1, travelTimesByDay2);



    }

    public ARequirementsManager getAManager() {
        return AManager;
    }
    public BRequirementsManager getBManager() {
        return BManager;
    }

    public CRequirementsManager getCManager() {
        return CManager;
    }



    public DoublyLinkedList<TravelArea>[] A1(int num){
        return AManager.A1(num);
    }

    public DoublyLinkedList<Pair<GeoCoordinate, String>> A2(double latitute, double longitute){
        return AManager.A2(latitute, longitute);
    }

    public DoublyLinkedList<TravelTime> A3(double lo, double hi){
        return AManager.A3(lo, hi);
    }


    public Queue B1(int num) {
    	return null;
    }


    public DoublyLinkedList<RoadNode> B2(double latitute, double longitute){
        return BManager.B2( latitute,  longitute);
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

    public TravelArea[] C3(int num){

        return CManager.C3(num);
    }

    public String C4(){

        return CManager.C4();
    }






}