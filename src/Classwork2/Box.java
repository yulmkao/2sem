package Classwork2;

public class
Box<T extends Number> {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        Box<Double> box2 = new Box<>();
        System.out.println(box1.getClass() == box2.getClass());
    }
}