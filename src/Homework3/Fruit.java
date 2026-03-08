package Homework3;

public class Fruit extends Food {
    private boolean isTasty;

    public Fruit(String name, boolean isTasty) {
        super(name);
        this.isTasty = isTasty;
    }

    public Fruit(String name) {
        super(name);
    }

    public boolean isTasty() {
        return isTasty;
    }
}
