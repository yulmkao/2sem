package Classwork1;

import java.util.Objects;

public class Fraction extends Number {
    private int numerator;
    private int denominator;

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) {
            throw new IllegalArgumentException("знаменатель не может быть равен 0");
        }
        reduce();
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int findNOD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void reduce() {
        int nod = findNOD(numerator, denominator);
        numerator /= nod;
        denominator /= nod;
    }


    public Fraction add(Fraction other) {
        Fraction result = new Fraction(this.numerator * other.getDenominator() +
                other.getNumerator() * this.denominator, this.denominator * other.getDenominator());
        result.reduce();
        return result;
    }

    public Fraction subtract(Fraction other) {
        Fraction result = new Fraction(this.numerator * other.getDenominator() -
                other.getNumerator() * this.denominator, this.denominator * other.getDenominator());
        result.reduce();
        return result;
    }

    public Fraction multiply(Fraction other) {
        Fraction result = new Fraction(this.numerator * other.getNumerator(),
                this.denominator * other.getDenominator());
        result.reduce();
        return result;
    }

    public Fraction divide(Fraction other) {
        if (other.getNumerator() == 0) {
            throw new ArithmeticException("деление на ноль!");
        }
        Fraction result = new Fraction(this.numerator * other.getDenominator(),
                this.denominator * other.getNumerator());
        result.reduce();
        return result;
    }

    public Fraction negate() {
        return new Fraction(-numerator, denominator);
    }

    public double abs(double number) {
        if (number < 0) {
            return -number;
        }
        return number;
    }

    public boolean isProper() {
        return abs(numerator) < abs(denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction other)) {
            return false;
        }
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }
}