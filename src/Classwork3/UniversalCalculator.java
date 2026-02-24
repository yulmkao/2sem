package Classwork3;

public class UniversalCalculator {

    public static double add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static double subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static double multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static double divide(Number a, Number b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("делить на ноль нельзя");
        }
        return a.doubleValue() / b.doubleValue();
    }
}