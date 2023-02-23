package pl.jtrawnicki.main;

public abstract class Sportsman {
    protected String name;
    protected int age;
    protected int height;
    protected int weight;

    public Sportsman(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void sleep(int hours) {
        System.out.println("Śpi przez " + hours + " godzin");
    }

    public String getName() {
        return name;
    }

}
