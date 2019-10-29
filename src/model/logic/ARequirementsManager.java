package model.logic;

import javafx.util.Pair;
import model.data_structures.*;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;
import model.value_objects.GeoCoordinate;

import java.util.Comparator;
import java.util.Iterator;

public class ARequirementsManager {



    private  MaxHeap<DoublyLinkedList<TravelArea>> A1Heap;

    private HashTable<String, DoublyLinkedList<Pair<GeoCoordinate, String>>> A2Table;;

    private   RedBlackTree<Double, TravelTime> A3Tree;


    public void loadA1Data(DoublyLinkedList<TravelArea> areasData){

        HashTable<String, DoublyLinkedList<TravelArea>> A1Table = new HashTable<>(31);
        A1Heap = new MaxHeap(10, new NumAreasComparator());

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

            A1Heap.add(temp);
        }

        A1Table = null;
    }





    public void loadA2Data(DoublyLinkedList<TravelArea> areasData){
        A2Table = new HashTable<>(101);

        for (TravelArea temp: areasData) {

            for (GeoCoordinate coordinate: temp.getFrontier()) {

                if (A2Table.contains(keyOf(coordinate))) {

                    DoublyLinkedList<Pair<GeoCoordinate, String>> val = A2Table.get(keyOf(coordinate));
                    val.addLast(new Pair<>(coordinate, temp.getName()));

                    A2Table.put(keyOf(coordinate), val);

                } else {
                    DoublyLinkedList<Pair<GeoCoordinate, String>> val = new DoublyLinkedList<>();
                    val.addLast(new Pair<>(coordinate, temp.getName()));
                    A2Table.put(keyOf(coordinate), val);
                }
            }
        }
    }

    public  void loadA3Data(DoublyLinkedList<TravelTime> travelTimesByMonth1){

        A3Tree = new RedBlackTree<>();

        for (TravelTime temp: travelTimesByMonth1) {

            A3Tree.put(temp.getMeanTime(), temp);
        }
    }


    public DoublyLinkedList<TravelArea>[] A1(int num) {

        DoublyLinkedList<TravelArea>[] mostFrequent = new DoublyLinkedList[num];

        for (int i = 0; i < num; i++) {

            DoublyLinkedList<TravelArea> temp = A1Heap.max();

            if (temp != null) {
                temp.mergeSort(new NameComparator());
                mostFrequent[i] = temp;
            }
        }

        return mostFrequent;
    }

    private class NameComparator implements Comparator<TravelArea> {

        @Override
        public int compare(TravelArea o1, TravelArea o2) {

            return o1.getName().compareTo(o2.getName());
        }
    }

    private class NumAreasComparator implements Comparator<DoublyLinkedList<TravelArea>> {

        @Override
        public int compare(DoublyLinkedList<TravelArea> o1, DoublyLinkedList<TravelArea> o2) {

            if (o1.size() < o2.size()) return -1;
            if (o1.size() > o2.size()) return 1;
            else return 0;
        }
    }

    public String keyOf(TravelArea a){
        return String.valueOf(a.getName().charAt(0));
    }






    public DoublyLinkedList<Pair<GeoCoordinate, String>> A2(double latitute, double longitute) {
        return A2Table.get(Math.floor(latitute*1000) + "-"  + Math.floor(longitute*1000));
    }

    private String keyOf(GeoCoordinate n){
        return  Math.floor(n.getLatitude()*1000) + "-"  + Math.floor(n.getLongitude()*1000);
    }



    public TravelTime[] A3(double lo, double hi) {


        Iterator<TravelTime> iter = A3Tree.valuesInRange(lo, hi);

        DoublyLinkedList<TravelTime> wanted = new DoublyLinkedList<>();

        for (Iterator<TravelTime> it = iter; it.hasNext(); ) {

            TravelTime temp = it.next();

            wanted.addLast(temp);
        }

        //crack

        TravelTime[] times = wanted.toArray();
        MergeSort.mergeSort(times, new TravelDestineComparator());
        MergeSort.mergeSort(times, new TravelSourceComparator());

        return times;

    }

    private static class TravelSourceComparator implements Comparator<Object> {

        public int compare(Object o1, Object o2) {

            if (((TravelTime)o1).getIdSource() < ((TravelTime)o2).getIdSource()) return -1;
            if (((TravelTime)o1).getIdSource() > ((TravelTime)o2).getIdSource()) return 1;
            else return 0;
        }
    }

    private static class TravelDestineComparator implements Comparator<Object> {

        public int compare(Object o1, Object o2) {

            if (((TravelTime)o1).getIdDestine() < ((TravelTime)o2).getIdDestine()) return -1;
            if (((TravelTime)o1).getIdDestine() > ((TravelTime)o2).getIdDestine()) return 1;
            else return 0;
        }
    }





}
