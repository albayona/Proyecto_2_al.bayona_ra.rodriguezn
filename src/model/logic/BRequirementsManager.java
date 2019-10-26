package model.logic;

import model.data_structures.DoublyLinkedList;
import model.data_structures.HashTable;
import model.value_objects.RoadNode;

public class BRequirementsManager {
    private HashTable<String, DoublyLinkedList<RoadNode>> B2Table;

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


    public DoublyLinkedList<RoadNode> B2(double latitute, double longitute) {
        return B2Table.get(Math.floor(latitute*100) + "-"  + Math.floor(longitute*100));
    }

    private String keyOf(RoadNode n){
        return  Math.floor(n.getLatitude()*100) + "-"  + Math.floor(n.getLongitude()*100);
    }
}
