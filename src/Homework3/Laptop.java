package Homework3;

public class Laptop extends Electronics {
    private int ramSize;

    public Laptop(String name, int ramSize) {
        super(name);
        this.ramSize = ramSize;
    }

    public int getRamSize() {
        return ramSize;
    }
}
