package controller;

import java.util.Scanner;

import javafx.util.Pair;
import model.logic.MVCModel;
import model.value_objects.TravelTime;
import view.MVCView;
import model.data_structures.*;
import model.value_objects.TravelArea;
import model.value_objects.RoadNode;
import model.value_objects.GeoCoordinate;

public class Controller {



    private MVCModel model;


    private MVCView view;


    public Controller() {
        model = new MVCModel();
        view = new MVCView();
    }


    public void run() {

        Scanner reader = new Scanner(System.in);
        boolean stop = false;


        int N = -1;

        double latitute = -1;
        double longitute = -1;

        double lo = -1;
        double hi = -1;
        
        int zone = -1;
        int hour = -1;



        while (!stop) {
            view.printMenu();

            String option = String.valueOf(reader.next());

            switch (option) {
                case "1":

                    model.loadData();

                   String l1 = "Para el trimestre " + 1 + " del 2018 se leyeron las siguientes cantidades de tiempos de viajes: " + model.travelTimesByDay(1).size() + "\n";
                    l1 += "Para el trimestre " + 2 + " del 2018 se leyeron las siguientes cantidades de tiempos de viajes: " + model.travelTimesByDay(2).size() + "\n";
                    l1 += "Para el primer semestre del 2018 se leyeron las siguientes cantidades de zonas de viaje: " + model.areasData().size() + "\n";
                    l1 += "Para el primer semestre del 2018 se leyeron las siguientes cantidades de nodos en la red vial: " + model.roadNodesData().size() + "\n";

                    model.loadRequirementsData();

                    System.out.println(l1);
                    break;

                case "A1":
                    System.out.println(" \n Ingresar cantidad de letras mas frecuentes a mostrar: \n");

                    try {
                        N = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    printArrayA1(model.A1(N));

                    break;


                case "A2":
                    System.out.println(" \n Ingresar longitud: \n");

                    try {
                        longitute = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    System.out.println(" \n Ingresar latitud: \n");

                    try {
                        latitute = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    printListA2(model.A2(latitute,longitute));


                    break;
                    
                case "A3":
                    System.out.println(" \n Ingresar tiempo inferior: \n");

                    try {
                        lo = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    System.out.println(" \n Ingresar tiempo superior: \n");

                    try {
                        hi = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    printListA3(model.A3(lo,hi));

                    break;
                    
                    
                case "B1":
                    System.out.println(" \n Ingresar cantidad a mostrar: \n");

                    try {
                        N = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    printArrayB1(model.B1(N));

                    break;

                case "B2":


                    System.out.println(" \n Ingresar longitud: \n");

                    try {
                        longitute = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    System.out.println(" \n Ingresar latitud: \n");

                    try {
                        latitute = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }


                    printListB2(model.B2(latitute,longitute));


                    break;


                case "B3":
                    System.out.println(" \n Ingresar desviacion inferior: \n");


                    try {
                        lo = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    System.out.println(" \n Ingresar desviacion superior: \n");

                    try {
                        hi = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    printListB3(model.A3(lo,hi));

                    break;
                
          case "C1":
              System.out.println(" \n Ingresar zona de origen: \n");

              try {
                  zone = reader.nextInt();
              } catch (Exception e) {
                  System.out.println("Debe ingresar un n�mero");
              }

              System.out.println(" \n Ingresar una hora: \n");

              try {
                  hour = reader.nextInt();
              } catch (Exception e) {
                  System.out.println("Debe ingresar un n�mero");
              }
              System.out.print(model.C1(zone,hour));
              printListC2(model.C1(zone,hour));

              break;
              
          
          case "C2":
        	  System.out.println(" \n Ingresar zona de origen: \n");

              try {
                  zone = reader.nextInt();
              } catch (Exception e) {
                  System.out.println("Debe ingresar un n�mero");
              }
              
              System.out.println(" \n Ingresar hora inferior: \n");

              try {
                  lo = reader.nextInt();
              } catch (Exception e) {
                  System.out.println("Debe ingresar un n�mero");
              }

              System.out.println(" \n Ingresar hora superior: \n");

              try {
                  hi = reader.nextInt();
              } catch (Exception e) {
                  System.out.println("Debe ingresar un n�mero");
              }

              printListC2(model.C2(zone,(int)lo,(int)hi));

              break;

           case "C3":

                    System.out.println(" \n Ingresar cantidad zonas a mostrar: \n");

                    try {
                        N = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un n�mero");
                    }

                    printArrC3(model.C3(N));

                    break;

           case "C4":

                    System.out.println(model.C4());

                    break;

                default: {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }

    private void printArrayA1(DoublyLinkedList<TravelArea>[] data) {
        System.out.println("----------------------------------------------");
        System.out.printf("%10s %30s", "Frecuencia", "Zonas por letra inicial");
        System.out.println();
        System.out.println("----------------------------------------------");


        int i = 0;
        for (DoublyLinkedList<TravelArea> temp: data) {

            i++;

            if (temp !=null){
                System.out.format("%10s %30s", temp.size(), i + ": " + model.getAManager().keyOf(temp.getElement(0)));
                System.out.println();
                System.out.println();


                int j = 0;
                for (TravelArea area : temp) {
                    j++;
                    System.out.format("%10s %30s", j, area.getName());
                    System.out.println();
                }

                System.out.println("----------------------------------------------");
                System.out.println();
            }
        }
    }
    
    private void printArrayB1(TravelArea[] data){
    	System.out.println("---------------------------------------------------");
        System.out.printf("%30s %10s %10s", "Nombre", "Latitud", "Longitud");
        System.out.println();
        System.out.println("---------------------------------------------------");
        
        if (data != null) {
        	for(int i=0;i<data.length;i++){
        		System.out.format("%30s %10s %10s", data[i].getName(), data[i].getMaxLatitude(), data[i].getMaxLongitud());
                System.out.println();
        	}
        }
    }

    private void printListB2(DoublyLinkedList<RoadNode> lista) {
        System.out.println("---------------------------------------------------");
        System.out.printf("%20s %20s %10s", "Longitud", "Latitud", "ID ");
        System.out.println();
        System.out.println("---------------------------------------------------");

        if (lista != null) {
            for (RoadNode node : lista) {

                System.out.format("%20s %20s %10s", node.getLongitude(), node.getLatitude(), node.getId());
                System.out.println();
            }
        }
    }


    private void printListA2(DoublyLinkedList<Pair<GeoCoordinate, String>> lista) {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%15s %15s %25s", "Longitud", "Latitud", "Zona ");
        System.out.println();
        System.out.println("-------------------------------------------------------------");

        if (lista != null) {
            for (Pair<GeoCoordinate, String> coordinate : lista) {
                System.out.format("%15s %15s %25s", coordinate.getKey().getLongitude(), coordinate.getKey().getLatitude(), coordinate.getValue());
                System.out.println();
            }
        }
    }

    private void printListA3(DoublyLinkedList<TravelTime> lista) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %16s", "Origen", "Destino", "Mes", "Tiempo promedio");
        System.out.println();
        System.out.println("------------------------------------------------------------");

        for (TravelTime node: lista) {

            System.out.format("%10s %10s %10s %16s", node.getIdSource(), node.getIdDestine(), node.getTimeIndicator(), node.getMeanTime());
            System.out.println();
        }
    }
    
    private void printListC2(DoublyLinkedList<TravelTime> lista) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %16s", "Origen", "Destino", "Hora", "Tiempo promedio");
        System.out.println();
        System.out.println("------------------------------------------------------------");

        for (TravelTime node: lista) {

            System.out.format("%10s %10s %10s %16s", node.getIdSource(), node.getIdDestine(), node.getTimeIndicator(), node.getMeanTime());
            System.out.println();
        }
    }
    
    private void printListB3(DoublyLinkedList<TravelTime> lista) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %16s", "Origen", "Destino", "Mes", "Desviacion promedio");
        System.out.println();
        System.out.println("------------------------------------------------------------");

        for (TravelTime node: lista) {

            System.out.format("%10s %10s %10s %16s", node.getIdSource(), node.getIdDestine(), node.getTimeIndicator(), node.getStandardDeviation());
            System.out.println();
        }
    }


    private void printArrC3(TravelArea[] arr) {
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%10s %30s %16s", "#","Nombre ", "Cantidad de nodos");
        System.out.println();
        System.out.println("----------------------------------------------------------------");

        int i =0;
        for (TravelArea area: arr) {
            i++;
            System.out.format("%10s %30s %16s",i, area.getName(), area.getFrontier().length);
            System.out.println();
        }
    }
}
