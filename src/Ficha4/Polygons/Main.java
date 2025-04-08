package Ficha4.Polygons;

import Ficha3.Points.Point2D;
import Utils.InputValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polygon polygon = new Polygon();
        Point2D vertex;
        double x, y;
        int option = -1;

        while (option != 0) {
            menu();
            option = InputValidation.validateIntBetween(sc, "Opção: ", 0, 7);
            switch (option) {
                case 1:
                    System.out.println("1. Adicionar vértices ao final do polígono :");
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada Y: ");
                    vertex = new Point2D(x, y);
                    polygon.addVertex(vertex);
                    break;
                case 7:
                    System.out.println("7. Listar polígono");
                    System.out.println(polygon);
                    break;
            }
        }

        sc.close();
    }

    public static void menu(){
        System.out.println("\n              ------- MENU --------");
        System.out.println("1. Adicionar vértices ao final do polígono");
        System.out.println("7. Listar polígono");
        System.out.println("0. Sair");
    }
}
