package controller;

import java.util.Scanner;
import model.logic.MVCModel;
import view.MVCView;

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


        int trimester = -1;


        while (!stop) {
            view.printMenu();

            int option = reader.nextInt();

            switch (option) {
                case 1:

                    try {
                        System.out.println("\nIngresar el trimestre: ");
                        trimester = reader.nextInt();
                    } catch (Exception e) {

                        System.out.print("Debe ingresar un n�mero.\n");
                    }


                    model.loadData(trimester);

                    System.out.println("Para el trimestre " + trimester + " del 2018 se leyeron las siguientes cantidades de tiempos de viajes: " + model.travelTimesData().size() + "\n");
                    System.out.println("Para el primer semestre del 2018 se leyeron las siguientes cantidades de zonas de viaje: " + model.areasData().size() + "\n");
                    System.out.println("Para el primer semestre del 2018 se leyeron las siguientes cantidades de nodos en la red vial: " + model.roadNodesData().size() + "\n");

                    break;



                default: {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }



}
