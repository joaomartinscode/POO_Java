package Ficha3.FuelStation;

import Utils.InputValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double liters = InputValidation.validateDoubleGE0(sc, "\n Quantos litros de combustível tem a estação de combustível? ");
        double price = InputValidation.validateDoubleGT0(sc, "\nQual o preço por litro?");

        FuelStation fuelStation = new FuelStation(liters, price);

        int option = -1;

        while (option != 0) {
            menu();
            option = InputValidation.validateIntBetween(sc, "Opção: ", 0, 6);
            switch (option) {
                case 0:
                    System.out.println("Adeus!!!");
                    return;
                case 1:
                    System.out.println("Vender combustível em litros");
                    liters = InputValidation.validateDoubleGT0(sc, "Quantos litros de combustível vai vender?");
                    fuelStation.sellFuelLiters(liters);
                    break;
                case 2:
                    System.out.println("Vender combustível por valor");
                    double value = InputValidation.validateDoubleGT0(sc, "Qual o valor combustível vai vender?");
                    fuelStation.sellFuelValue(value);
                    break;
                case 3:
                    System.out.println("3. Comprar combustível ao distribuidor");
                    liters = InputValidation.validateDoubleGT0(sc, "Quantos litros de combustível vai comprar ao distribuidor?");
                    fuelStation.buyFuel(liters);
                    break;
                case 4:
                    System.out.println("4. Alterar preço por litro");
                    price = InputValidation.validateDoubleGT0(sc, "Qual o valor por litro?");
                    fuelStation.changePrice(price);
                    break;
                case 5:
                    System.out.println("5. Consultar preço por litro");
                    System.out.println("Preço: " + fuelStation.getPricePerLiter() + " €/litro");
                    break;
                case 6:
                    System.out.println("6. Consultar a quantidade de combustível na estação");
                    System.out.println("Quantidade: " + fuelStation.getLiters() + " litros");
                    break;
            }
            sc.close();
        }
    }
    private static void menu(){
        System.out.println("\n Menu");
        System.out.println("1. Vender combustível por litros");
        System.out.println("2. Vender combustível por valor");
        System.out.println("3. Comprar combustível ao distribuidor");
        System.out.println("4. Alterar preço por litro");
        System.out.println("5. Consultar preço por litro");
        System.out.println("6. Consultar a quantidade de combustível na estação");
        System.out.println("0. Sair");
    }
}
