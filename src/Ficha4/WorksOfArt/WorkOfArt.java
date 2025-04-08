package Ficha4.WorksOfArt;

import Utils.InputValidation;

import java.util.Scanner;

public class WorkOfArt {
    private String name;
    private String author;
    private int year;
    private double price;
    private int number;
    private Order order = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public WorkOfArt(Scanner sc, int number) {
        System.out.print("Introduza o nome da obra de arte: ");
        name = sc.nextLine();
        System.out.print("Introduza o nome do autor da obra de arte: ");
        author = sc.nextLine();
        year = InputValidation.validateIntGT0(sc, "Introduza o ano do arte: ");
        price = InputValidation.validateDoubleGT0(sc, "Introduza o valor da obra: ");
        this.number = number;
    }

    @Override
    public String toString() {
        String s = "\nName: " + name +
                ", Author: " + author +
                ", Year: " + year +
                ", Price: " + price +
                ", Number: " + number;

        if (order != null) {
            s += ", Order: " + order.getNumber();
        }

        return s;
    }

}
