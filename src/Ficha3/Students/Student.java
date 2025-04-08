package Ficha3.Students;
import Utils.InputValidation;

import java.util.Scanner;

public class Student {
    private int number;
    private String name;
    private String sClass;
    private double avgGrade;

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public Student(int number,String name,String sClass, double avgGrade){
        this.number = number;
        this.name = name;
        this.sClass = sClass;
        this.avgGrade = avgGrade;
    }

    public Student(Scanner sc) {
        number = InputValidation.validateIntGT0(sc, "Introduza o numero do aluno: ");
        avgGrade = InputValidation.validateDoubleBetween(sc, "Introduza a media do aluno: ",
                0.0, 20.0);
        System.out.println("Introduza o nome do aluno: ");
        name = sc.nextLine();
        System.out.println("Introduza o curso do aluno: ");
        sClass = sc.nextLine();
    }

    @Override
    public String toString() {
        return " Número: " + number +
                "\n Nome: " + name +
                "\n Curso: " + sClass +
                "\n Média: " + avgGrade + "\n";
    }

}
