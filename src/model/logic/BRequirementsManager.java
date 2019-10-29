package model.logic;

import java.util.Comparator;
import java.util.Iterator;

import model.data_structures.DoublyLinkedList;
import model.data_structures.HashTable;
import model.data_structures.MaxHeap;
import model.data_structures.RedBlackTree;
import model.value_objects.RoadNode;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;

public class BRequirementsManager {
	private  MaxHeap<TravelArea> B1Heap;
    private HashTable<String, DoublyLinkedList<RoadNode>> B2Table;
    private   RedBlackTree<Double, TravelTime> B3Tree;
    
    //TODO loads

    public void loadB1Data(DoublyLinkedList<TravelArea> areasData){
        B1Heap = new MaxHeap(10, new NumAreasComparator());
        
        for(TravelArea temp: areasData){
        	B1Heap.add(temp);
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
    
    public  void loadB3Data(DoublyLinkedList<TravelTime> travelTimesByMonth1){

        B3Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimesByMonth1) {

            B3Tree.put(temp.getStandardDeviation(), temp);
        }
    }
    
    
    //TODO metodos
    
    public TravelArea[] B1(int num) {
    	 TravelArea[] ans = new TravelArea[num];
    	 
    	 for(int i=0; i< num;i++){
    		 ans[i] = B1Heap.max();
    	 }
    	 
    	 return ans;
    }
    
    public DoublyLinkedList<RoadNode> B2(double latitute, double longitute) {
        return B2Table.get(Math.floor(latitute*100) + "-"  + Math.floor(longitute*100));
    }

    public DoublyLinkedList<TravelTime> B3(double inf, double sup) {
        DoublyLinkedList<TravelTime> ans = new DoublyLinkedList<>();
        
        Iterator<TravelTime> iter = B3Tree.valuesInRange(inf, sup);
        
        for (Iterator<TravelTime> it = iter; it.hasNext(); ) {

            TravelTime temp = it.next();

            ans.addLast(temp);
        }
        
        ans.mergeSort(new TravelDestineComparator());
        ans.mergeSort(new TravelSourceComparator());
        
        return ans;
    }
    
    
    
    //TODO adicionales
    private class NumAreasComparator implements Comparator<TravelArea> {

        public int compare(TravelArea o1, TravelArea o2) {

            if (o1.getMaxLatitude() < o2.getMaxLatitude()) return -1;
            if (o1.getMaxLatitude() > o2.getMaxLatitude()) return 1;
            else return 0;
        }
    }
    
    private class TravelSourceComparator implements Comparator<TravelTime> {

        public int compare(TravelTime o1, TravelTime o2) {

            if (o1.getIdSource() < o2.getIdSource()) return -1;
            if (o1.getIdSource() > o2.getIdSource()) return 1;
            else return 0;
        }
    }

    private class TravelDestineComparator implements Comparator<TravelTime> {

        public int compare(TravelTime o1, TravelTime o2) {

            if (o1.getIdDestine() < o2.getIdDestine()) return -1;
            if (o1.getIdDestine() > o2.getIdDestine()) return 1;
            else return 0;
        }
    }

    private String keyOf(RoadNode n){
        return  Math.floor(n.getLatitude()*100) + "-"  + Math.floor(n.getLongitude()*100);
    }
}
