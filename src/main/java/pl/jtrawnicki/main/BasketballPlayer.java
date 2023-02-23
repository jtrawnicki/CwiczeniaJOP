package pl.jtrawnicki.main;

public class BasketballPlayer extends Sportsman implements Training{

    protected String team;

    public BasketballPlayer(String name, int age, int height, int weight, String team) {
        super(name, age, height, weight);
        this.team = team;
    }

    @Override
    public void warmUp() {
        System.out.println("Ćwiczenia rozciągające...");
    }

    @Override
    public void mainTraining() {
        System.out.println("Trening zespołowy...");

    }

    @Override
    public void gym() {
        System.out.println("Trening siłowy 1.5h...");
    }
}
