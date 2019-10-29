package model.logic;

import model.data_structures.DoublyLinkedList;
import model.data_structures.HashTable;
import model.data_structures.MaxHeap;
import model.data_structures.RedBlackTree;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;

import java.util.Comparator;
import java.util.Iterator;

public class CRequirementsManager {

	private RedBlackTree<Integer, TravelTime> C1Tree;
	private RedBlackTree<Integer, TravelTime> C2Tree;
    private  MaxHeap<TravelArea> C3Heap;
    HashTable<Integer, Double> C4Table;
    //TODO load
    
    public  void loadC1Data(DoublyLinkedList<TravelTime> travelTimesByMonth1){

        C1Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimesByMonth1) {

            C1Tree.put(temp.getIdSource(), temp);
        }
    }
    
    public  void loadC2Data(DoublyLinkedList<TravelTime> travelTimesByMonth1){

        C2Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimesByMonth1) {

            C2Tree.put(temp.getIdDestine(), temp);
        }
    }

    public void loadC3Data(DoublyLinkedList<TravelArea> areasData){
        C3Heap = new MaxHeap<>(11, new NumNodesComparator());

        for (TravelArea temp: areasData) {
            C3Heap.add(temp);
        }
    }

    public void loadC4Data(DoublyLinkedList<TravelTime> travelTimesByDay1, DoublyLinkedList<TravelTime> travelTimesByDay2){

        C4Table = new HashTable<>(11);

        fillTable(C4Table, travelTimesByDay1);
        fillTable(C4Table, travelTimesByDay2);
    }
    
    //TODO metodos
    
    public DoublyLinkedList<TravelTime> C1(int orig, int hour){
        DoublyLinkedList<TravelTime> ans = new DoublyLinkedList<>();
        
        Iterator<TravelTime> iter = C1Tree.valuesInRange(orig-1, orig+1);
        
        for (Iterator<TravelTime> it = iter; it.hasNext(); ) {
            TravelTime temp = it.next();
            if(temp.getTimeIndicator() == hour){
            	ans.addLast(temp);
            }
        }
        
        return ans;
    }
    
    public DoublyLinkedList<TravelTime> C2(int dest, int inf,int sup){
        DoublyLinkedList<TravelTime> ans = new DoublyLinkedList<>();
        
        Iterator<TravelTime> iter = C1Tree.valuesInRange(dest, dest);
        
        for (Iterator<TravelTime> it = iter; it.hasNext(); ) {

            TravelTime temp = it.next();
            if(temp.getTimeIndicator()>=inf && temp.getTimeIndicator() <= sup){
            	ans.addLast(temp);
            }
        }
        
        return ans;
    }

    public TravelArea[] C3(int num) {

        TravelArea[] prioritized  = new TravelArea[num];

        for (int i = 0; i < num; i++) {
            prioritized[i] = C3Heap.max();
        }

        return prioritized;
    }

    private class NumNodesComparator implements Comparator<TravelArea> {

        public int compare(TravelArea o1, TravelArea o2) {

            if (o1.getFrontier().length < o2.getFrontier().length) return -1;
            if (o1.getFrontier().length > o2.getFrontier().length) return 1;
            else return 0;
        }
    }



    public String C4() {

        double expectedAmount = 1160*24*2;

        String line = "Porcentaje de datos faltantes por zona \n";

        for (int i = 1; i < 1161; i++) {

            Double actualAmount = C4Table.get(i);

            if (actualAmount != null) {

                double percentage = Math.round((actualAmount / expectedAmount) * 100);

                int missingPercentage = 100 - (int) percentage;

                line += (i + " | " + printPercentages(missingPercentage));
            }
            else {
                line+= (i + " | " + printPercentages(100));
            }

        }
        return  line;
    }
    
    //adicionales

    private  String printPercentages(int n){

        String line = "";

        int m = (int)Math.ceil(n/2);

        for (int j = 0; j <  m; j++) {
            line+="*";
        }

        line+="\n";

        return  line;
    }

    private void fillTable(HashTable<Integer, Double> table, DoublyLinkedList<TravelTime> travelTimesData1) {
        for (TravelTime temp : travelTimesData1) {

            if (table.contains(temp.getIdSource())) {

                Double val = table.get(temp.getIdSource());

                table.put(temp.getIdSource(), ++val);

            } else {
                table.put(temp.getIdSource(), 1.00);
            }
        }
    }


}
