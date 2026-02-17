package Classwork2;

public class Calculator<T extends Number> {
    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("делить на ноль нельзя");
        }
        return a.doubleValue() / b.doubleValue();
    }
}
