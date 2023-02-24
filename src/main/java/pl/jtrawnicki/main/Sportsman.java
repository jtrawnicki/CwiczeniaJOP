package pl.jtrawnicki.main;

public abstract class Sportsman implements Training{
    protected String name;
    protected int age;
    protected int height;
    protected int weight;

    protected Condition condition;

    public Sportsman(String name, int age, int height, int weight, Condition condition) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.condition = condition;
    }

    public void sleepHours(int hours) {
        System.out.println("Śpi przez " + hours + " godzin");
    }
    

    public Condition getCondition() {
        return condition;
    }
}
