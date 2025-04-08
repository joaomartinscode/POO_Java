package Ficha4.WorksOfArt;

import Utils.InputValidation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<WorkOfArt> worksOfArt = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        int workOfArtNumber = 1;
        int orderNumber = 1;
        int orderNumberToSearch = 0;
        int workOfArtToSearch = 0;
        int i, j;


        int option = -1;
        while (option != 0) {
            menu();
            option = InputValidation.validateIntBetween(sc, "Opção: ", 0, 7);
            switch (option) {
                case 1:
                    System.out.println("1. Adicionar obra de arte");
                    WorkOfArt workOfArt = new WorkOfArt(sc, workOfArtNumber++);
                    worksOfArt.add(workOfArt);
                    break;
                case 2:
                    System.out.println("2. Listar obras de arte");
                    for (WorkOfArt work : worksOfArt) {
                        System.out.println(work);
                    }
                    break;
                case 3:
                    System.out.println("3. Criar nova encomenda obras de arte");
                    orders.add(new Order(orderNumber++, LocalDate.now()));
                    break;
                case 4:
                    System.out.println("4. Adicionar obras de arte a encomenda já existente");
                    orderNumberToSearch = InputValidation.validateIntBetween(sc, "Qual o numero da encomenda que deseja adicionar uma obra de arte: ", 1, orderNumber - 1);
                    for(i = 0; i<orders.size(); i++){
                        if(orders.get(i).getNumber() == orderNumberToSearch){
                            workOfArtToSearch = InputValidation.validateIntBetween(sc, "Qual a obra de arte que deseja adicionar: ", 1, workOfArtNumber - 1);
                            for (j = 0; j < worksOfArt.size(); j++) {
                                if(worksOfArt.get(j).getNumber() == workOfArtToSearch){
                                    orders.get(i).addWorkOfArt(worksOfArt.get(j));
                                    worksOfArt.get(j).setOrder(orders.get(i));
                                    System.out.println("Obra de arte encomendada com sucesso!");
                                    break;
                                }
                            }
                            if(j == worksOfArt.size()){
                                System.out.println("Obra de arte não encontrada!");
                            }
                            break;
                        }
                    }
                    if(i == orders.size() ){
                        System.out.println("Encomenda não encontrada!");
                    }
                    break;
                case 7:
                    System.out.println("7. Listar encomendas");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
            }

        }
        sc.close();
    }

    private static void menu() {
        System.out.println("\nMenu");
        System.out.println("1. Adicionar obra de arte");
        System.out.println("2. Listar obras de arte");
        System.out.println("3. Criar nova encomenda obras de arte");
        System.out.println("4. Adicionar obras de arte a encomenda já existente");
        System.out.println("7. Listar encomendas");
        System.out.println("0. Sair");
    }
}
