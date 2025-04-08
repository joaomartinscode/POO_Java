package Ficha3.Temperatures;

import java.util.Scanner;

public class Temperature {
    private double temperature;
    private char unit;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public char getUnit() {
        return unit;
    }

    public void setUnit(char unit) {
        this.unit = unit;
    }

    public Temperature(double temperature, char unit) {
        this.temperature = temperature;
        this.unit = unit;
    }

    public Temperature(Scanner sc){
        while(true) {
            System.out.println("Introduza uma temperatura (x.xºC ou x.xºF");
            String s = sc.nextLine();
            String[] split = s.split("º");
            if (split.length == 2) {
                try {
                    split[0] = split[0].replace(',', '.');
                    temperature = Double.parseDouble(split[0]);
                    if(split[1].equalsIgnoreCase("C") || split[1].equalsIgnoreCase("F") ) {
                        unit = split[1].toUpperCase().charAt(0);
                        break;
                    }
                } catch (NumberFormatException ignored) {}
            }
            System.out.println("Formato incorreto");
        }
    }

    public Temperature convert(char unit){
        if(this.unit == unit){
            return new Temperature(temperature, this.unit);
        }
        if(this.unit == 'C'){
            double f = 1.8 * temperature + 32;
            f = Math.round(f*100) / 100.0;
            return new Temperature(f, 'F');
        }
        if(this.unit == 'F'){
            double c = (temperature - 32) * (5 / 9.0);
            c = Math.round(c*100) / 100.0;
            return new Temperature(c, 'C');
        }
        System.out.println("Unidade invalida. As unidades válidas são C ou F");
        return null;
    }

    public static Temperature max(Temperature[] temps){
        double max = temps[0].convert('C').temperature;
        int index = 0;
        for(int i = 1; i < temps.length; i++){
            if(temps[i].convert('C').temperature > max){
                max = temps[i].convert('C').temperature;
                index = i;
            }
        }
        return temps[index];
    }

    public static Temperature min(Temperature[] temps){
        double min = temps[0].convert('C').temperature;
        int index = 0;
        for(int i = 1; i < temps.length; i++){
            if(temps[i].convert('C').temperature < min){
                min = temps[i].convert('C').temperature;
                index = i;
            }
        }
        return temps[index];
    }

    public static Temperature avg(Temperature[] temps){
        double total = 0;
        for (Temperature temp : temps) {
            total += temp.convert('C').temperature;
        }
        return new Temperature( Math.round(total / temps.length * 100) / 100.0 , 'C');
    }

    public static Temperature amplitude(Temperature[] temps){
        double min = min(temps).convert('C').temperature;
        double max = max(temps).convert('C').temperature;

        return new Temperature(Math.round((max-min) * 100) / 100.0 , 'C');
    }

    public static Temperature closeToAvg(Temperature[] temps){
        double avg = avg(temps).temperature;
        double dif = Math.abs(temps[0].convert('C').temperature - avg);
        int index = 0;
        for(int i = 1; i < temps.length; i++){
            if(dif > Math.abs(temps[i].convert('C').temperature - avg)){
                dif = Math.abs(temps[i].convert('C').temperature - avg);
                index = i;
            }
        }

        return temps[index];
    }

    @Override
    public String toString() {
        return  temperature + "º" + unit;
    }
}
