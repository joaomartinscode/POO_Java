package Ficha3.Temperatures;

import Utils.InputValidation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            menu();
            option = InputValidation.validateIntBetween(sc, "Opção: ", 0, 3);
            switch (option) {
                case 1:
                    System.out.println("1. Adicionar uma temperatura");
                    Temperature temperature = new Temperature(sc);
                    System.out.println("Temperatura: " + temperature);
                    break;
                case 2:
                    System.out.println("2. Converter uma temperatura");
                    Temperature temperature2 = new Temperature(sc);
                    System.out.println("Temperatura: " + temperature2);
                    if(temperature2.getUnit() == 'C'){
                        System.out.println(temperature2.convert('F'));
                    }else{
                        System.out.println(temperature2.convert('C'));
                    }
                    break;
                case 3:
                    System.out.println("Analise de 10 temperaturas");
                    Temperature[] temps = new Temperature[10];
                    for (int i = 0; i < 10; i++) {
                        temps[i] = new Temperature(sc);
                    }
                    System.out.println(Arrays.toString(temps));
                    System.out.println("Temperatura Máxima: " + Temperature.max(temps));
                    System.out.println("Temperatura Mínima: " + Temperature.min(temps));
                    System.out.println("Temperatura Média: " + Temperature.avg(temps));
                    System.out.println("Amplitude da Temperatura: " + Temperature.amplitude(temps));
                    System.out.println("Temperatura mais próxima da média: " + Temperature.closeToAvg(temps));
                    break;
            }
        }
        sc.close();
    }

    private static void menu(){
        System.out.println("\nMenu");
        System.out.println("1. Adicionar uma temperatura");
        System.out.println("2. Converter uma temperatura");
        System.out.println("3. Analise de 10 temperaturas");
        System.out.println("0. Sair");
    }
}
