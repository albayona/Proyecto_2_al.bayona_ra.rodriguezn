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

	private RedBlackTree<Integer, RedBlackTree<Integer, DoublyLinkedList<TravelTime>>> C1Tree;
    private RedBlackTree<Integer, RedBlackTree<Integer, DoublyLinkedList<TravelTime>>> C2Tree;
    private  MaxHeap<TravelArea> C3Heap;
    private HashTable<Integer, Double> C4Table;
    //TODO load
    
    public  void loadC1Data(DoublyLinkedList<TravelTime> travelTimes){

        C1Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimes) {
            if (C1Tree.contains(temp.getIdSource())){

                RedBlackTree<Integer, DoublyLinkedList<TravelTime>> subTree = C1Tree.get(temp.getIdSource());

                putInTree(temp, subTree);

                C1Tree.put(temp.getIdSource(), subTree);

            }
            else {
                RedBlackTree<Integer, DoublyLinkedList<TravelTime>> subTree = new RedBlackTree<>();

                DoublyLinkedList<TravelTime> list = new DoublyLinkedList<>();

                list.addLast(temp);

                subTree.put(temp.getTimeIndicator(), list);

                C1Tree.put(temp.getIdSource(), subTree);
            }
        }


    }
    
    public  void loadC2Data(DoublyLinkedList<TravelTime> travelTimes){

        C2Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimes) {
            if (C2Tree.contains(temp.getIdDestine())){

                RedBlackTree<Integer, DoublyLinkedList<TravelTime>> subTree = C2Tree.get(temp.getIdDestine());

                putInTree(temp, subTree);

                C2Tree.put(temp.getIdDestine(), subTree);

            }
            else {
                RedBlackTree<Integer, DoublyLinkedList<TravelTime>> subTree = new RedBlackTree<>();

                DoublyLinkedList<TravelTime> list = new DoublyLinkedList<>();

                list.addLast(temp);

                subTree.put(temp.getTimeIndicator(), list);

                C2Tree.put(temp.getIdDestine(), subTree);
            }
        }

    }

    private void putInTree(TravelTime temp, RedBlackTree<Integer, DoublyLinkedList<TravelTime>> subTree) {
        if (subTree.contains(temp.getTimeIndicator())){

            DoublyLinkedList<TravelTime> list = subTree.get(temp.getTimeIndicator());
            list.addLast(temp);

            subTree.put(temp.getTimeIndicator(), list);

        }
        else {


            DoublyLinkedList<TravelTime> list = new DoublyLinkedList<>();

            list.addLast(temp);
            subTree.put(temp.getTimeIndicator(), list);
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

        DoublyLinkedList<TravelTime> ans;

        ans = C1Tree.get(orig).get(hour);

        ans.mergeSort(new DestineComparator());

        return ans;
    }

    private static class DestineComparator implements Comparator<TravelTime> {

        public int compare(TravelTime o1, TravelTime o2) {

            if (o1.getIdDestine() < o2.getIdDestine()) return -1;
            if (o1.getIdDestine() > o2.getIdDestine()) return 1;
            else return 0;
        }
    }


    public DoublyLinkedList<TravelTime> C2(int dest, int inf,int sup){

        DoublyLinkedList<TravelTime> ans = new DoublyLinkedList<>();

        Iterator<DoublyLinkedList<TravelTime>> iter = C2Tree.get(dest).valuesInRange(inf,sup);

        for (Iterator<DoublyLinkedList<TravelTime>> it = iter; it.hasNext(); ) {
            DoublyLinkedList<TravelTime> temp = it.next();

            ans.addAll(temp);
        }

        ans.mergeSort(new HourComparator());

        return ans;
    }

    private static class HourComparator implements Comparator<TravelTime> {

        public int compare(TravelTime o1, TravelTime o2) {

            if (o1.getTimeIndicator() < o2.getTimeIndicator()) return -1;
            if (o1.getTimeIndicator() > o2.getTimeIndicator()) return 1;
            else return 0;
        }
    }

    public TravelArea[] C3(int num) {

        TravelArea[] prioritized  = new TravelArea[num];

        for (int i = 0; i < num; i++) {
            prioritized[i] = C3Heap.max();
        }

        return prioritized;
    }

    private static class NumNodesComparator implements Comparator<TravelArea> {

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
