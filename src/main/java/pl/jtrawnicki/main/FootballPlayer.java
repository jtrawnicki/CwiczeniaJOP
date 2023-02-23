package pl.jtrawnicki.main;

public class FootballPlayer extends Sportsman implements Training{

    protected String club;

    public FootballPlayer(String name, int age, int height, int weight, String club) {
        super(name, age, height, weight);
        this.club = club;
    }


    @Override
    public void warmUp() {
        System.out.println("15 minut biegania...");
    }

    @Override
    public void mainTraining() {
        System.out.println("Gierka 5 na 5...");

    }

    @Override
    public void gym() {
        System.out.println("Trening siłowy...");

    }


}
