package Ficha3.Points;

import Utils.InputValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        double x = 0, y = 0, dist;
        int n, min, max;
        Point2D[] points;

        do {
            menu();
            option = InputValidation.validateIntBetween(sc, "Opção: ", 0, 10);
            switch (option) {
                case 0:
                    System.out.println("Adeus");
                    break;
                case 1:
                    System.out.println("1. Criar ponto com coordenadas predefinidas");
                    Point2D point = new Point2D();
                    System.out.println("p1: (" + point.getX() + ", " + point.getY() + ")");
                    break;
                case 2:
                    System.out.println("2. Criar ponto com coordenadas recebidas");
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X do ponto: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada y do ponto: ");
                    Point2D point2 = new Point2D(x, y);
                    point2.print();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("3. Criar ponto através de coordenadas de outro ponto");
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X do ponto: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada y do ponto: ");
                    Point2D point3 = new Point2D(x, y);
                    point3.print();
                    System.out.println();
                    Point2D point4 = new Point2D(point3);
                    System.out.println(point4);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Alterar coordenadas de um ponto");
                    Point2D point5 = new Point2D();
                    System.out.println(point5);
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada Y: ");
                    point5.setXY(x, y);
                    break;
                case 5:
                    System.out.println("5. Calcular distancia entre dois pontos");
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada Y: ");
                    Point2D point6 = new Point2D(x, y);
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada Y: ");
                    Point2D point7 = new Point2D(x, y);

                    dist = point6.distance(point7);
                    dist = Math.round(dist * 100.0) / 100.0;
                    System.out.println("A distancia entre os pontos é: " + dist);
                    break;
                case 6:
                    System.out.println("6. Criar array de pontos aleatórios e calcular distancia");
                    n = InputValidation.validateIntGT0(sc, "Introduza o tamanho do array de pontos: ");
                    min = InputValidation.validateInt(sc, "Introduza o valor mínimo: ");
                    max = InputValidation.validateInt(sc, "Introduza o valor máximo: ");

                    points = new Point2D[n];
                    for (int i = 0; i < n; i++) {
                        points[i] = new Point2D(min, max);
                        System.out.println(points[i]);
                    }

                    dist = 0.0;
                    for (int i = 0; i < n - 1; i++) {
                        dist += points[i].distance(points[i + 1]);
                    }

                    dist = Math.round(dist * 100.0) / 100.0;
                    System.out.println("Distância total: " + dist);
                    break;
                case 7:
                    System.out.println("7. Criar três pontos com nome");
                    System.out.println("Introduza o nome do ponto com coordenadas predefinidas: ");
                    String name = sc.nextLine();
                    Point2D p8 = new Point2D(name);
                    System.out.println(p8);

                    System.out.println("Introduza o nome do ponto com coordenadas também pedidas: ");
                    name = sc.nextLine();
                    x = InputValidation.validateDouble(sc, "Introduza a coordenada X: ");
                    y = InputValidation.validateDouble(sc, "Introduza a coordenada Y: ");
                    Point2D p9 = new Point2D(x, y, name);
                    System.out.println(p9);

                    System.out.println("Introduza o novo nome para o ultimo ponto: ");
                    name = sc.nextLine();
                    p9.setNome(name);
                    System.out.println(p9);
                    break;
                case 8:
                    System.out.println("8. Criar array de pontos aleatórios e calcular distancia, ponto mais próximo e ponto mais distante");
                    n = InputValidation.validateIntGT0(sc, "Introduza o tamanho do array de pontos: ");
                    min = InputValidation.validateInt(sc, "Introduza o valor mínimo: ");
                    max = InputValidation.validateInt(sc, "Introduza o valor máximo: ");

                    points = new Point2D[n];
                    for (int i = 0; i < n; i++) {
                        points[i] = new Point2D(min, max, "p" + i);
                        System.out.println(points[i]);
                    }

                    dist = 0.0;
                    for (int i = 0; i < n - 1; i++) {
                        dist += points[i].distance(points[i + 1]);
                    }

                    dist = Math.round(dist * 100.0) / 100.0;
                    System.out.println("Distância total: " + dist);

                    double distMin = Double.MAX_VALUE;
                    double distMax = Double.MIN_VALUE;
                    int distMinPos = 0;
                    int distMaxPos = 0;

                    for (int i = 1; i < n - 1; i++) {
                        dist = points[i].avgDistance(points[i-1], points[i+1]);

                        if (dist < distMin) {
                            distMin = dist;
                            distMinPos = i;
                        }
                        if (dist > distMax) {
                            distMax = dist;
                            distMinPos = i;
                        }
                    }

                    distMin = Math.round(distMin * 100.0) / 100.0;
                    distMax = Math.round(distMax * 100.0) / 100.0;
                    System.out.println("Ponto mais proximo dos vizinhos: " + points[distMinPos] + ", ponto mais distante: " + points[distMaxPos]);
                    System.out.println("Distancia minima: " + distMin + ", distancia maxima: " + distMax);
                    break;
                case 9:
                    System.out.flush();
                    break;
            }
        } while (option != 0);
        sc.close();
    }

    private static void menu() {
        System.out.println("\n Ficha 2 - Menu:\n");
        System.out.println("1. Criar ponto com coordenadas predefinidas");
        System.out.println("2. Criar ponto com coordenadas recebidas");
        System.out.println("3. Criar ponto através de coordenadas de outro ponto");
        System.out.println("4. Alterar coordenadas de um ponto");
        System.out.println("5. Calcular distancia entre dois pontos");
        System.out.println("6. Criar array de pontos aleatórios e calcular distancia");
        System.out.println("7. Criar três pontos com nome");
        System.out.println("8. Criar array de pontos aleatórios e calcular distancia, ponto mais próximo e ponto mais distante");
        System.out.println("0. Sair");
    }

}

