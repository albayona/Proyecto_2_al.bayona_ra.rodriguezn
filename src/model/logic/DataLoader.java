package model.logic;

import com.opencsv.CSVReader;

import model.data_structures.DoublyLinkedList;
import model.value_objects.GeoCoordinate;
import model.value_objects.RoadNode;
import model.value_objects.TravelArea;
import model.value_objects.TravelTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class DataLoader {

    public final static String TRAVEL_TIMES_FILE = "./data/bogota-cadastral-2018-#-All-HourlyAggregate.csv";
    public final static String ROAD_NODES_FILE = "./data/Nodes_of_red_vial-wgs84_shp.txt";
    public final static String TRAVEL_AREAS_FILE = "./data/bogota_cadastral.json";


    public void loadTravelTimes(DoublyLinkedList<TravelTime> data, int trimester){
        CSVReader reader = null;
        try {

            reader = new CSVReader(new FileReader(TRAVEL_TIMES_FILE.replaceAll("#", String.valueOf(trimester))));

            Iterator iter = reader.iterator();

            iter.next();

            while (iter.hasNext()){

                String[] params = (String[]) iter.next();

                data.addLast(new TravelTime(Integer.parseInt(params[0]), Integer.parseInt(params[1]),Integer.parseInt(params[2]), Double.parseDouble(params[3]),Double.parseDouble(params[4]) ));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void loadRoadNodes(DoublyLinkedList<RoadNode> data){
        CSVReader reader = null;
        try {

            reader = new CSVReader(new FileReader(ROAD_NODES_FILE));

            Iterator iter = reader.iterator();

            iter.next();

            while (iter.hasNext()){

                String[] params = (String[]) iter.next();

                data.addLast(new RoadNode(Integer.parseInt(params[0]), Double.parseDouble(params[1]), Double.parseDouble(params[2])));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }





    public void loadTravelAreas(DoublyLinkedList<TravelArea> data) {

        FileReader file;
        try {
            file = new FileReader(TRAVEL_AREAS_FILE);
            JSONParser parser = new JSONParser();

            JSONObject o = (JSONObject) parser.parse(file);
            JSONArray arr = (JSONArray) o.get("features");

             loadArrayOfAreas(arr, data);

            file.close();
        } catch (IOException | ParseException e) {

            e.printStackTrace();
        }
    }


    private void loadArrayOfAreas(JSONArray areas, DoublyLinkedList<TravelArea> data) {

        if(areas != null) {
            for(int i = 0; i < areas.size(); i++) {
                JSONObject areaJS = (JSONObject) areas.get(i);
                TravelArea area = loadAreaData(areaJS);
                data.addLast(area);
            }
        }
    }

    private TravelArea loadAreaData(JSONObject areaJS) {
        TravelArea areaVO = null;

        JSONObject properties = (JSONObject)areaJS.get("properties");
        JSONObject geometry = (JSONObject)areaJS.get("geometry");

        String name = (String)properties.get("scanombre");
        double perimeter = (Double) properties.get("shape_leng");
        double area = (Double) properties.get("shape_area");
        int ID = Integer.parseInt((String) properties.get("MOVEMENT_ID"));

        JSONArray arr = (JSONArray)geometry.get("coordinates");
        JSONArray coordinates = (JSONArray) ((JSONArray) arr.get(0)).get(0);

        GeoCoordinate[] frontier = loadCoordinates(coordinates);

        areaVO = new TravelArea(name, perimeter,area,ID, frontier);

        return areaVO;
    }

    private GeoCoordinate[] loadCoordinates(JSONArray coordinatesJS) {


        GeoCoordinate[] coordinatesArray = new GeoCoordinate[coordinatesJS.size()];

        for (int i = 0; i < coordinatesArray.length; i++) {
            coordinatesArray[i] = loadCoordinate((JSONArray) coordinatesJS.get(i));
        }

        return coordinatesArray;
    }

    private GeoCoordinate loadCoordinate(JSONArray coordinateJS){
        return  new GeoCoordinate(((Double) coordinateJS.get(0)), (Double) coordinateJS.get(1));
    }

}
