package Homework1;

import Classwork1.Fraction;

public class Main {
    public static void main(String[] args) {
        //тк число находится в диапозоне кеширования
        ItemStorage<Integer> item1 = new ItemStorage<>(100);
        item1.compareWith(100);

        //ссылки разные из за того что находится вне диапозона кеширования
        ItemStorage<Integer> item2 = new ItemStorage<>(200);
        item2.compareWith(200);

        //сравниваем 2 отдельно созданных обьекта, поэтому ссылки отличаются
        ItemStorage<Fraction> item3 = new ItemStorage<>(new Fraction(1, 2));
        item3.compareWith(new Fraction(1, 2));
    }
}