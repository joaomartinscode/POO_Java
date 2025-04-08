package Ficha1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        do {
            menu();
            option = sc.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Adeus");
                    break;
                case 1:
                    System.out.println("1- Converter celsius em fahrenheit");
                    convertCelsiusToFahrenheit(sc);
                    break;
                case 2:
                    System.out.println("2- Calcular o volume de uma esfera");
                    calculateSphereVolume(sc);
                    break;
                case 3:
                    System.out.println("3 - Calcular a distancia entre 2 pontos");
                    calculatePointsDistance(sc);
                    break;
                case 4:
                    System.out.println("4 - Listar números inteiros positivos");
                    listPositiveIntegers(sc);
                    break;
                case 5:
                    System.out.println("5 - Listar números inteiros positivos com return/break");
                    listPositiveIntegersV2(sc);
                    break;
                case 6:
                    System.out.println("6 - Comparar números aleatórios");
                    compareRandom25();
                    break;
                case 7:
                    System.out.println("7 - Listar números primos");
                    listPrimeNumbers(sc);
                    break;
                case 8:
                    System.out.println("8 - Escrever números por extenso");
                    writeNumber(sc);
                    break;
                case 9:
                    System.out.println("9 - Listar a tabuada");
                    listMultiplicationTable(sc);
                    break;
                case 10:
                    System.out.println("10 - Listar números da sequência de fibonacci");
                    listFibonacciSequence(sc);
                    break;
                case 11:
                    System.out.println("11 - Listar números da sequência de fibonacci de maneira recursiva");
                    listFibonacciSequence2(sc);
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        } while (option != 0);
        sc.close();
    }

    private static void menu() {
        System.out.println("\n Ficha 1 - Menu:");
        System.out.println("1. Converter graus Celsius em Fahrenheit");
        System.out.println("2. Calcular o volume de uma esfera");
        System.out.println("3 - Calcular a distancia entre 2 pontos");
        System.out.println("4 - Listar números inteiros positivos");
        System.out.println("5 - Listar números inteiros positivos com return/break");
        System.out.println("6 - Comparar números aleatórios");
        System.out.println("7 - Listar números primos");
        System.out.println("8 - Escrever por extenso");
        System.out.println("9 - Listar a tabuada");
        System.out.println("10 - Listar números da sequência de fibonacci");
        System.out.println("11 - Listar números da sequência de fibonacci de maneira recursiva");
        System.out.println("0. Sair");
    }

    /**
     * 1- Converter celsius em fahrenheit
     *
     * @param sc scanner
     */
    private static void convertCelsiusToFahrenheit(Scanner sc) {
        double f, c;
        System.out.print("Indique o valor em graus celsius: ");
        c = sc.nextDouble();
        f = (c * 9 / 5) + 32;
        f = Math.round(f * 100) / 100.0;
        System.out.println(c + " ºc = " + f + " ºf");
    }

    /**
     * 2 - Calcular o volume de uma esfera
     *
     * @param sc scanner
     */
    private static void calculateSphereVolume(Scanner sc) {
        double r, v;
        System.out.println("\n Indique o raio de uma esfera: ");
        r = sc.nextDouble();
        v = 4.0 / 3.0 * Math.PI * Math.pow(r, 3);
        v = Math.round(v * 100) / 100.0;
        System.out.println("O volume da esfera de raio " + r + " e " + v);
    }

    /**
     * 3 - Calcular a distancia entre 2 pontos
     *
     * @param sc scanner
     */
    private static void calculatePointsDistance(Scanner sc) {
        double x1, y1, x2, y2, d;
        System.out.println("\n Indique a coordenada x do primeiro ponto: ");
        x1 = sc.nextDouble();
        System.out.println("\n Indique a coordenada y do primeiro ponto: ");
        y1 = sc.nextDouble();
        System.out.println("\n Indique a coordenada x do segundo ponto: ");
        x2 = sc.nextDouble();
        System.out.println("\n Indique a coordenada y do segundo ponto: ");
        y2 = sc.nextDouble();

        d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        d = Math.round(d * 100) / 100.0;
        System.out.println("A distancia entre os pontos (" + x1 + ","
                + y1 + ") e (" + x2 + "," + y2 + "): " + d);
    }

    /**
     * 4 - Listar números inteiros positivos
     *
     * @param sc scanner
     */
    private static void listPositiveIntegers(Scanner sc) {
        System.out.println("\n Indique o numero inteiro positivo até ao qual listar todos os números: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    /**
     * 5 - Listar números inteiros positivos com return/break
     *
     * @param sc scanner
     */
    private static void listPositiveIntegersV2(Scanner sc) {
        System.out.println("\n Indique o numero inteiro positivo até ao qual listar todos os números: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i);

            if (i > 99) {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i);

            if (i > 99) {
                return;
            }
        }
    }

    /**
     * 6 - Comparar números aleatórios
     */
    private static void compareRandom25() {
        System.out.println("\n 25 números aleatórios maiores ou menores que outro número aleatório");
        Random random = new Random();
        int x, y;

        for (int i = 0; i < 25; i++) {
            x = random.nextInt();
            y = random.nextInt();

            if (x == y) {
                System.out.println("\n Números são iguais");
            } else if (x > y) {
                System.out.println(x + ">" + y);
            } else {
                System.out.println(x + "<" + y);
            }
        }
    }

    /**
     * 7 - Listar números primos
     *
     * @param sc scanner
     */
    private static void listPrimeNumbers(Scanner sc) {
        System.out.println("\n Indique o número até ao qual listar os números primos: ");
        int n = sc.nextInt();

        boolean isPrime = true;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i + " é um número primo");
            }
            isPrime = true;
        }
    }

    /**
     * 8 - Escrever por extenso
     *
     * @param sc scanner
     */

    private static void writeNumber(Scanner sc) {

        int num;

        do {
            System.out.println("\n Indique um numero de 0 a 99: ");
            num = sc.nextInt();

            if (num > 99 || num < 0) {
                System.out.println("Valor invalido");
            }
        } while (num > 99 || num < 0);

        String[] s1 = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
                "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezasseis", "dezassete", "dezoito", "dezanove"};

        String[] s2 = {"vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};

        if (num < 20) {
            System.out.println(s1[num]);
        } else {
            System.out.println(s2[num / 10 - 2]);

            int r = num % 10;
            if (r != 0)
                System.out.println(" e " + s1[r]);
            System.out.println();
        }
    }

    /**
     * 9 - Listar a tabuada
     *
     * @param sc scanner
     */
    private static void listMultiplicationTable(Scanner sc) {
        System.out.println("\nIndique o número da tabuada a calcular: ");
        int n = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + n + " = " + n * i);
        }
    }

    /**
     * 10 - Listar números da sequência de fibonacci
     *
     * @param sc scanner
     */
    private static void listFibonacciSequence(Scanner sc) {
        System.out.println("\nIndique o número de elementos da sequência de fibonacci: ");
        int n = sc.nextInt();

        if (n > 0){
            int last = 0, penult = 1, current = 0;

            for (int i = 0; i < n - 1; i++) {
                current = last + penult;
                System.out.print(current + ", ");
                penult = last;
                last = current;
            }
            current = last + penult;
            System.out.print(current);
        }
    }

    /**
     * 11 - Listar números da sequência de fibonacci de maneira recursiva
     * @param sc scanner
     */
    public static void listFibonacciSequence2(Scanner sc) {
        System.out.println("\nIndique o número de elementos da sequência de fibonacci: ");
        int n = sc.nextInt();

        if (n > 0){
            for (int i = 0; i < n - 1; i++) {
                System.out.print(fibonacciAux(i) + ", ");
            }
            System.out.print(fibonacciAux(n-1));
        }
    }

    /**
     *
     * @param n número do termo da sequência de fibonacci
     * @return nth termo da sequência de fibonacci
     */
    private static int fibonacciAux(int n){
        if (n < 2 ){
            return 1;
        }
        return fibonacciAux(n - 1) + fibonacciAux(n - 2);
    }

    /**
     *
     */
    private static void listVampireNumbers() {
        int first, second, third, fourth;
        for (int i = 1000; i < 10000; i++) {
            first = i / 1000;
            second = i / 100 % 10;
            third = i / 10 % 10;
            fourth = i % 10;

            vampireNumbersAux(first, second, third, fourth, i);
            vampireNumbersAux(second, first, fourth, third, i);
            vampireNumbersAux(second, fourth, third, first, i);
            vampireNumbersAux(third, second, first, fourth, i);
            // CONTINUAR A ALTERAR OS ARGUMENTOS
        }
    }

    private static void vampireNumbersAux(int n1, int n2, int n3, int n4, int number) {
        if ((n1 * 10 + n2) * (n3 * 10 + n4) == number) {
            System.out.println(number + " é vampiro: " + number + " = " + n1 + n2 + " x " + n3 + n4);
        }
    }
}
