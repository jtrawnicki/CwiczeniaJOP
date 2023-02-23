package pl.jtrawnicki.main;

public class Sprinter extends Sportsman implements Training{

    protected String nationality;

    public Sprinter(String name, int age, int height, int weight, String nationality) {
        super(name, age, height, weight);
        this.nationality = nationality;
    }

    @Override
    public void warmUp() {
        System.out.println("30 minut biegu...");
    }

    @Override
    public void mainTraining() {
        System.out.println("10x100m Sprint");
    }

    @Override
    public void gym() {
        System.out.println("45min treningu siłowego...");
    }
}
