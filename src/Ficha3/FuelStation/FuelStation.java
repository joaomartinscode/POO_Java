package Ficha3.FuelStation;

public class FuelStation {
    private double liters;
    private double pricePerLiter;

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public FuelStation(double liters, double pricePerLiter) {
        this.liters = liters;
        this.pricePerLiter = pricePerLiter;
        System.out.println("A estação de combustível tem " + liters + " litros a " + pricePerLiter + " €/litro.");
    }

    public void sellFuelLiters(double liters) {
        if(this.liters > liters) {
            System.out.println("Foram vendidos " + liters + " litros a " + pricePerLiter
                    + " €/litro, dando um total de " + Math.round(liters * pricePerLiter * 100.0) / 100.0 + "€ a pagar");
            this.liters -= liters;
        } else if (this.liters > 0) {
            System.out.println("Não havia combustivel suficiente por isso só foram vendidos " + this.liters +
                    " litros a " + pricePerLiter + " €/litro, dando um total de " +
                    Math.round(this.liters * pricePerLiter * 100.0) / 100.0 + "€ a pagar");
            this.liters = 0;
        } else{
            System.out.println("Não há combustível a vender");
        }
    }

    public void sellFuelValue(double value) {
        double liters = Math.round(value / pricePerLiter * 100.0) / 100.0;
        sellFuelLiters(liters);
    }

    public void buyFuel(double liters) {
        System.out.println("Foram comprados " + liters + " litros");
        this.liters += liters;
        System.out.println("Estação de combustível ficou com " + this.liters + " litros");
    }

    public void changePrice(double price) {
        pricePerLiter = price;
        System.out.println("O preço do combustível ficou a " + pricePerLiter + " €/litro");
    }
}
