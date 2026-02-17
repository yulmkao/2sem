package Classwork2;

import Classwork1.Fraction;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 10);

        Calculator<Integer> intType = new Calculator<>();
        System.out.println("сложение типа int: " + intType.add(10, 5));

        Calculator<Double> doubleType = new Calculator<>();
        System.out.println("деление типа double: " + doubleType.divide(7.5, 2.5));

        Calculator<Fraction> fractionType = new Calculator<>();
        System.out.println("сложение типа fraction: " + fractionType.add(f1, f2));

        Calculator<Long> longType = new Calculator<>();
        System.out.println("умножение типа long: " + longType.multiply(2500L, 5L));

        Calculator<Float> floatType = new Calculator<>();
        System.out.println("вычитание типа float: " + floatType.subtract(240.0f, 8f));
    }
}