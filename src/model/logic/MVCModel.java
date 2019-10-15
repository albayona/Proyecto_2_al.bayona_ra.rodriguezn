package model.logic;


import model.data_structures.DoublyLinkedList;
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

}