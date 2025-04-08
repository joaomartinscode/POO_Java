package Ficha3.Students;

import Utils.InputValidation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String studentsFilePath = Paths.get(Paths.get("").toAbsolutePath().toString(),
            "src\\Ficha3\\Students", "students.csv").toString();

    private static Student[] students = new Student[3];
    private static int nextStudentIndex = 0;

    public static void main(String[] args) {
        if(!loadStudentsFile()){
            return;
        }

        Scanner sc = new Scanner(System.in);
        int option = -1;

        do{
            menu();
            option = InputValidation.validateIntBetween(sc, "Opção: ", 0, 3);
            switch(option){
                case 0:
                    System.out.println("Adeus!!");
                    break;
                case 1:
                    System.out.println("1. Listar todos os alunos");
                    for(int i = 0; i<nextStudentIndex; i++){
                        System.out.println(students[i]);
                    }
                    break;
                case 2:
                    System.out.println("2. Adicionar aluno");
                    if(students.length == nextStudentIndex){
                        students = Arrays.copyOf(students, students.length * 2);
                    }
                    students[nextStudentIndex++] = new Student(sc);
                    addStudentToFile();
                    break;
                case 3:
                    System.out.println("3. Listar aluno com melhor média");
                    double bestGrade = Double.MIN_VALUE;
                    int index = 0;
                    for(int i = 0; i<nextStudentIndex; i++){
                        if(students[i].getAvgGrade() > bestGrade){
                            bestGrade = students[i].getAvgGrade();
                            index = i;
                        }
                    }
                    System.out.println("\nO aluno com a melhor media foi: \n" + students[index]);
                    break;
            }
        }while(option != 0);

        sc.close();
    }

    private static void menu(){
        System.out.println("\nMenu: ");
        System.out.println("1. Listar todos os alunos");
        System.out.println("2. Adicionar aluno");
        System.out.println("3. Listar aluno com melhor média");
        System.out.println("0. Sair");
    }

    private static boolean loadStudentsFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(studentsFilePath, StandardCharsets.ISO_8859_1))) {
            String line;
            String[] sArray;
            while ((line = br.readLine()) != null) {
                sArray = line.split(";");

                if(students.length == nextStudentIndex){
                    students = Arrays.copyOf(students, students.length * 2);
                }

                students[nextStudentIndex++] = new Student(Integer.parseInt(sArray[0]), sArray[1],
                        sArray[2], Double.parseDouble(sArray[3]));
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o ficheiro de estudantes do caminho " + studentsFilePath);
            return false;
        }
        return true;
    }

    private static void addStudentToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(studentsFilePath,
                StandardCharsets.ISO_8859_1, true))) {
            bw.write(students[nextStudentIndex-1].getNumber() + ";"
                    + students[nextStudentIndex-1].getName() + ";"
                    + students[nextStudentIndex-1].getsClass() + ";"
                    + students[nextStudentIndex-1].getAvgGrade() + "\n");
        }catch (Exception e) {
            System.out.println("Erro ao atualizar o ficheiro de estudantes do caminho " + studentsFilePath);
        }
    }
}
