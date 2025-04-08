package Ficha2;

import java.util.Arrays;
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
                    System.out.println("1 - Criar array de inteiros num intervalo");
                    int[] array = newRandomArrayInRange(sc);
                    for (int j : array) {
                        System.out.print(j + ", ");
                    }
                    System.out.print(array[array.length - 1]);
                    break;
                case 2:
                    System.out.println("2 - Verificar se o numero esta no array");
                    isNumberInArray(sc, newRandomArrayInRange(sc));
                    break;
                case 3:
                    System.out.println("3 - Verificar se a palavra é palindrome");
                    System.out.print("Indique uma palavra: ");
                    isPalindrome(sc.next());
                    break;
                case 4:
                    System.out.println("4 - Análise de valores no Array");
                    listArrayStats(newRandomArrayInRange(sc));
                    break;
                case 5:
                    System.out.println("5 - Criar histograma de valores de um array");
                    listArrayHistogram(newRandomArrayInRange(sc));
                    break;
                case 6:
                    System.out.println("6 - Remover espaços a mais da frase");
                    concatStrings(sc);
                    break;
                case 7:
                    System.out.println("7 - Imprimir a distancia entre as coordenadas");
                    calcDistancePointsArray(sc);
                    break;
                case 8:
                    System.out.println("8 - Verificar se alguma palavra da frase está contida noutra palavra");
                    searchWordsInsideWords(sc);
                    break;
                case 9:
                    System.out.println("9 - Procurar nome numa lista de nomes");
                    checkIfNameInNames(sc);
                    break;
                case 10:
                    System.out.println("10 - Verificar se há nomes repetidos no array");
                    checkIfNamesRepeated(sc);
                    break;
                case 11:
                    System.out.println("11 - Contar o número de vezes que cada nome está num array nomes");
                    countRepeteadNames(sc);
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        } while (option != 0);
        sc.close();
    }

    private static void menu() {
        System.out.println("\n Ficha 2 - Menu:");
        System.out.println("1 - Criar array de inteiros num intervalo");
        System.out.println("2 - Verificar se o numero esta no array");
        System.out.println("3 - Verificar se a palavra é palindrome");
        System.out.println("4 - Análise de valores no Array");
        System.out.println("5 - Criar histograma de valores de um array");
        System.out.println("6 - Remover espaços a mais da frase");
        System.out.println("7 - Imprimir a distancia entre as coordenadas");
        System.out.println("8 - Verificar se alguma palavra da frase está contida noutra palavra");
        System.out.println("9 - Procurar nome numa lista de nomes");
        System.out.println("10 - Verificar se há nomes repetidos no array");
        System.out.println("11 - Contar o número de vezes que cada nome está num array nomes");
        System.out.println("0. Sair");
    }

    /**
     * 1 - Criar array de inteiros num intervalo
     * @param sc scanner
     * @return array de inteiros de um intervalo e com tantos elementos conforme pedido pelo utilizador
     */
    private static int[] newRandomArrayInRange(Scanner sc) {
        int min, max, range;
        System.out.println("Indique o valor mínimo: ");
        min = sc.nextInt();
        System.out.println("Indique o valor máximo: ");
        max = sc.nextInt();
        System.out.println("Indique o numero de elementos a colocar no array: ");
        range = sc.nextInt();

        int[] randomArray = new int[range];
        Random rand = new Random();

        for (int i = 0; i < range; i++) {
            randomArray[i] = rand.nextInt(min, max+1);
        }

        return randomArray;
    }

    /**
     * 2 - Verificar se o numero esta no array
     * @param sc scanner
     * @param array array de inteiros de um intervalo e com tantos elementos conforme pedido pelo utilizador
     */
    private static void isNumberInArray(Scanner sc, int[] array) {
        System.out.println(Arrays.toString(array));

        System.out.print("Indique o numero que pretende encontrar no array: ");
        int number = sc.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                System.out.println("O " + number +  " encontra-se na posição: " + (i+1));
                return;
            }
        }
        System.out.println("O " + number + " não foi encontrado");
    }

    /**
     * 3 - Verificar se a palavra é palindrome
     * @param palavra palavra que ira confirmar se é palindrome
     */
    private static void isPalindrome(String palavra) {
        for (int i = 0; i < palavra.length() / 2; i++) {
            if(palavra.charAt(i) != palavra.charAt(palavra.length() - i - 1)) {
                System.out.println("Não é palindrome");
            }
        }
        System.out.println("É palindrome");
    }

    /**
     * 4 - Análise de valores no Array
     * @param array array de inteiros
     */
    private static void listArrayStats(int[] array) {
        System.out.println(Arrays.toString(array));
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        double media = total / array.length;

        total = 0;
        double dif, difMin = Double.MAX_VALUE;
        int closerToAvg = 0;
        int nValAbove = 0, nValBelow = 0;

        for (int i = 0; i < array.length; i++) {
            dif = Math.pow(array[i] - media, 2);
            total += dif;

            if(dif < difMin){
                closerToAvg = array[i];
                difMin = dif;
            }

            if(array[i] > media){
                nValAbove++;
            }else if(array[i] < media){
                nValBelow++;
            }
        }
        double variance = total / array.length;


        System.out.println("Média: " + media);
        System.out.println("Variância: " + variance);
        System.out.println("Valor mais próximo da média: " + closerToAvg);
        System.out.println("Valores acima da média: " + nValAbove + " | valores abaixo da média: " + nValBelow);
    }

    /**
     * 5 - Criar histograma de valores de um array
     * @param array array de números inteiros
     */
    private static void listArrayHistogram(int[] array) {
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        int n = 1;

        for(int i = 1; i < array.length; i++){
            if(array[i] == array[i-1]){
                n++;
            }else{
                System.out.println(array[i-1] + ": " + n + "X");
                n = 1;
            }
            System.out.println(array[array.length - 1] + ": " + n + "X");
        }
    }

    /**
     * 6 - Remover espaços a mais da frase
     * @param sc scanner
     */
    private static void concatStrings(Scanner sc) {
        sc.nextLine();
        System.out.print("Escreva uma frase: ");
        String frase = sc.nextLine();

        frase = frase.trim().replaceAll("\\s+", " ");

        String[] palavras = frase.split(" ");
        System.out.println(String.join(" ", palavras));

        System.out.println(frase);
    }

    /**
     * 7 - Imprimir a distancia entre as coordenadas
     * @param sc scanner
     */
    private static void calcDistancePointsArray(Scanner sc){
        sc.nextLine();
        System.out.println("Introduza as coordenadas dos pontos separados por espaços (x1 y1 x2 y2 ...): ");
        String s = sc.nextLine().trim().replaceAll("\\s+", " ");
        String[] cord = s.split(" ");

        if(cord.length % 2 != 0){
            System.out.println("Coordenadas inválidas!!");
            return;
        }

        double[] pointsX = new double[cord.length / 2];
        double[] pointsY = new double[cord.length / 2];

        for (int i = 0; i < cord.length; i+=2) {
            pointsX[i / 2] = Double.parseDouble(cord[i]);
            pointsY[i / 2] = Double.parseDouble(cord[i+1]);
        }

        double dist = 0;

        for (int i = 0; i < pointsX.length - 1; i++) {
            dist = Math.sqrt(Math.pow(pointsX[i + 1]
                    - pointsX[i], 2) + Math.pow(pointsY[i + 1] - pointsY[i], 2));
        }

        dist = Math.round(dist * 100) / 100.0;

        System.out.println("A distancia entre os pontos é: " + dist);
    }

    /**
     * 8 - Verificar se alguma palavra da frase está contida noutra palavra
     * @param sc scanner
     */
    private static void searchWordsInsideWords(Scanner sc) {
        sc.nextLine();
        System.out.println("Introduza uma frase: ");
        String s = sc.nextLine().trim().replaceAll("\\s+", " ").toLowerCase();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(!words[i].equals(words[j]) && words[i].contains(words[j])){
                    System.out.println("A palavra \"" + words[i] + "\" contém a palavra \"" + words[j] + "\"");
                }
            }
        }
    }

    /**
     * 9 - Procurar nome numa lista de nomes
     * @param sc scanner
     */
    private static void checkIfNameInNames(Scanner sc){
        System.out.print("Indique quantos nomes vai introduzir: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nome " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        System.out.println("Indique o nome que deseja verificar se existe no array: ");
        String name = sc.nextLine();
        for (int i = 0; i < names.length; i++) {
            if(names[i].equalsIgnoreCase(name)){
                System.out.println("O nome " + name + " existe no array na posição: " + (i+1));
                return;
            }
        }
        System.out.println("O nome não foi encontrado!");
    }

    /**
     * 10 - Verificar se há nomes repetidos no array
     * @param sc scanner
     */
    private static void checkIfNamesRepeated(Scanner sc){
        System.out.print("Indique quantos nomes vai introduzir: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nome " + (i + 1) + ": ");
            names[i] = sc.nextLine().toLowerCase();
        }

        Arrays.sort(names);
        for (int i = 0; i < names.length-1; i++) {
            if(names[i].equals(names[i + 1])){
                System.out.println("Há nomes repetidos no array!!");
                return;
            }
        }
    }

    /**
     * 11 - Contar o número de vezes que cada nome está num array nomes
     * @param sc scanner
     */
    private static void countRepeteadNames(Scanner sc){
        System.out.print("Indique quantos nomes vai introduzir: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nome " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
        System.out.println(String.join(" ", names));

        int cnt = 1;

        for (int i = 0; i < names.length-1; i++) {
            if(names[i].equalsIgnoreCase(names[i+1])){
                cnt++;
            }else{
                System.out.println(names[i] + "=" + cnt);
                cnt = 1;
            }
        }
        System.out.println(names[n - 1] + "=" + cnt);
    }

}
