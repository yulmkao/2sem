package Classwork3;

import Classwork1.Fraction;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 10);
        System.out.println("сложение типа int: " + UniversalCalculator.add(10, 5));
        System.out.println("деление типа double: " + UniversalCalculator.divide(7.5, 2.5));
        System.out.println("сложение типа fraction: " + UniversalCalculator.add(f1, f2));
        System.out.println("умножение типа long: " + UniversalCalculator.multiply(2500L, 5L));
        System.out.println("вычитание типа float: " + UniversalCalculator.subtract(240.0f, 8f));

        //тестирование numberbox
        NumberBox<Integer> box1 = new NumberBox<>(new Integer[]{1, 2, 3, 4, 5});
        NumberBox<Double> box2 = new NumberBox<>(new Double[]{1.2, 2.7, 3.9, 4.4, 5.6});
        NumberBox<Double> box3 = new NumberBox<>(new Double[]{});

        NumberBox.printSquared(box1);

       //System.out.println(NumberBox.fillWithRandom(box3));

        //System.out.println(NumberBox.copy(box1, box3));

        System.out.println("сумма чисел " + NumberBox.sum(box1));

        System.out.println(NumberBox.addBoxes(box1, box2));

        box1.append(box2);
        System.out.println(box1);
    }
}
