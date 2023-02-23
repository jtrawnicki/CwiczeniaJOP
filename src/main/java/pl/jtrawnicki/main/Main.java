package pl.jtrawnicki.main;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Sportsman> athletes = Arrays.asList(
                new FootballPlayer("Salah", 31, 183, 84, "Liverpool FC"),
                new Sprinter("Hubert", 23, 187, 71, "Poland"),
                new BasketballPlayer("James", 32, 196, 92, "LA Lakers"),
                new Sprinter("Helmut", 226, 179, 68, "Germany"),
                new FootballPlayer("Mbappe", 24, 186, 83, "PSG"),
                new Sprinter("Zbyszek", 21, 189, 73, "Poland"),
                new BasketballPlayer("Doncic", 24, 201, 104, "Dallas Mavericks")
        );

        for (Sportsman sportsman : athletes) {
            if (sportsman instanceof FootballPlayer) {
                System.out.println(sportsman.getName() + " trenuje: ");
                ((FootballPlayer) sportsman).mainTraining();
            } else if (sportsman instanceof Sprinter) {
                System.out.println(sportsman.getName() + " rozpoczyna rozgrzewkę: ");
                ((Sprinter) sportsman).warmUp();
            } else if (sportsman instanceof BasketballPlayer) {
                System.out.println(sportsman.getName() + " ćwiczy na siłowni: ");
                ((BasketballPlayer) sportsman).gym();
                sportsman.sleep(6);
            }
        }



    }
}