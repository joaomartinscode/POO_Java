package Ficha4.WorksOfArt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int number;
    private LocalDate date;
    private ArrayList<WorkOfArt> worksOfArtOrdered = new ArrayList<>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order(int number, LocalDate date) {
        this.number = number;
        this.date = date;
    }

    public void addWorkOfArt(WorkOfArt workOfArt) {
        if (!worksOfArtOrdered.contains(workOfArt)) {
            worksOfArtOrdered.add(workOfArt);
        }
    }

    public void removeWorkOfArt(WorkOfArt workOfArt) {
        worksOfArtOrdered.remove(workOfArt);
    }

    public void clearWorksOfArt() {
        worksOfArtOrdered.clear();
    }

    public String toString() {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String s = "\n Encomenda número: " + number + " de " + formattedDate + "\n";
        for (WorkOfArt workOfArt : worksOfArtOrdered) {
            s += workOfArt;
        }
        return s;
    }

}
