package model.logic;

import java.util.Comparator;
import java.util.Iterator;

import javafx.util.Pair;
import model.data_structures.DoublyLinkedList;
import model.data_structures.HashTable;
import model.data_structures.MaxHeap;
import model.data_structures.RedBlackTree;
import model.value_objects.GeoCoordinate;
import model.value_objects.RoadNode;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;

public class BRequirementsManager {
	private  MaxHeap<DoublyLinkedList<TravelArea>> B1Heap;
    private HashTable<String, DoublyLinkedList<RoadNode>> B2Table;
    private   RedBlackTree<Double, TravelTime> B3Tree;
    
    //TODO loads
    
    public  void loadB3Data(DoublyLinkedList<TravelTime> travelTimesByMonth1){

        B3Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimesByMonth1) {

            B3Tree.put(temp.getMeanTime(), temp);
        }
    }
    
    public void loadB2Data(DoublyLinkedList<RoadNode> roadNodesData){
        B2Table = new HashTable<>(101);

        for (RoadNode temp: roadNodesData) {

            if (B2Table.contains(keyOf(temp))){

                DoublyLinkedList<RoadNode> val = B2Table.get(keyOf(temp));
                val.addLast(temp);

                B2Table.put(keyOf(temp), val);

            }
            else {
                DoublyLinkedList<RoadNode> val = new DoublyLinkedList<>();

                val.addLast(temp);
                B2Table.put(keyOf(temp), val);
            }
        }
    }
    
    public void loadB1Data(DoublyLinkedList<TravelArea> areasData){

        HashTable<String, DoublyLinkedList<TravelArea>> A1Table = new HashTable<>(31);
        B1Heap = new MaxHeap(10, new NumAreasComparator());

        for (TravelArea temp: areasData) {

            if (A1Table.contains(keyOf(temp))){

                DoublyLinkedList<TravelArea> val = A1Table.get(keyOf(temp));
                val.addLast(temp);

                A1Table.put(keyOf(temp), val);

            }
            else {
                DoublyLinkedList<TravelArea> val = new DoublyLinkedList<>();

                val.addLast(temp);
                A1Table.put(keyOf(temp), val);
            }
        }

        for (Iterator<String> it = A1Table.keysIterator(); it.hasNext(); ) {
            String key = it.next();

            DoublyLinkedList<TravelArea> temp = A1Table.get(key);

            B1Heap.add(temp);
        }

        A1Table = null;
    }
    
    //TODO metodos
    
    

    
    
    public DoublyLinkedList<RoadNode> B2(double latitute, double longitute) {
        return B2Table.get(Math.floor(latitute*100) + "-"  + Math.floor(longitute*100));
    }

    private String keyOf(RoadNode n){
        return  Math.floor(n.getLatitude()*100) + "-"  + Math.floor(n.getLongitude()*100);
    }
    
    //TODO adicionales
    private class NumAreasComparator implements Comparator<DoublyLinkedList<TravelArea>> {

        public int compare(DoublyLinkedList<TravelArea> o1, DoublyLinkedList<TravelArea> o2) {

            if (o1.size() < o2.size()) return -1;
            if (o1.size() > o2.size()) return 1;
            else return 0;
        }
    }
}
