package pl.jtrawnicki.main;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Sportsman> athletes = Arrays.asList(
                new FootballPlayer("Salah", 31, 183, 84, Condition.FIT, "Liverpool FC"),
                new Sprinter("Hubert", 23, 187, 71, Condition.CONVALESCENT, "Poland"),
                new BasketballPlayer("James", 32, 196, 92,Condition.CONVALESCENT, "LA Lakers"),
                new Sprinter("Helmut", 226, 179, 68, Condition.INJURED, "Germany"),
                new FootballPlayer("Mbappe", 24, 186, 83, Condition.CONVALESCENT, "PSG"),
                new Sprinter("Zbyszek", 21, 189, 73, Condition.FIT, "Poland"),
                new BasketballPlayer("Doncic", 24, 201, 104, Condition.INJURED,"Dallas Mavericks")
        );

        for (Sportsman sportsman : athletes) {
            if (sportsman.getCondition().equals(Condition.FIT)) {
                sportsman.mainTraining();
            } else if (sportsman.getCondition().equals(Condition.CONVALESCENT)) {
                sportsman.gym();
            } else if (sportsman.getCondition().equals(Condition.INJURED)) {
                sportsman.sleepHours(8);
            }
        }



    }
}