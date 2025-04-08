package Ficha3.Points;

import java.util.Random;

public class Point2D {
    private double x;
    private double y;
    private String nome;

    public double getX() {return x;}

    public double getY() {return y;}

    public String getNome() {return nome;}

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}

    public void setNome(String nome) {this.nome = nome;}

    public void setXY(double x, double y){this.x = x; this.y = y;}

    public Point2D() {  // Construtor por omissão (Sem elementos)
        x = y = 0.0;    // this. só é necessário caso o construtor receber argumentos iguais às globais
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D point) {
        x = point.x;
        y = point.y;
        nome = point.nome;
    }

    public Point2D(int min, int max) {
       Random r = new Random();
       x = r.nextDouble(min, max);
       y = r.nextDouble(min, max);
    }

    public Point2D(String nome) {  // Construtor por omissão (Sem elementos)
        x = y = 0.0;
        this.nome = nome;// this. só é necessário caso o construtor receber argumentos iguais às globais
    }

    public Point2D(double x, double y, String nome) {
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

    public Point2D(int min, int max, String nome) {
        Random r = new Random();
        x = r.nextDouble(min, max);
        y = r.nextDouble(min, max);
        this.nome = nome;
    }

    public void print() {
        double xAux = Math.round(x * 100.0) / 100.0;
        double yAux = Math.round(y * 100.0) / 100.0;
        if(nome != null) {
            System.out.print(nome + "(" + xAux + ", " + yAux + ")");
        }else {
            System.out.println("(" + xAux + ", " + yAux + ")");
        }
    }

    public double distance(Point2D point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }

    public double avgDistance(Point2D p1, Point2D p2) {
        double d1 = distance(p1);
        double d2 = distance(p2);
        return (d1 + d2) / 2;
    }

    @Override
    public String toString() {
        double xAux = Math.round(x * 100.0) / 100.0;
        double yAux = Math.round(y * 100.0) / 100.0;

        if(nome != null) {
            return nome + "(" + xAux + ", " + yAux + ")";
        }else{
            return "(" + xAux + ", " + yAux + ")";
        }
    }
}
