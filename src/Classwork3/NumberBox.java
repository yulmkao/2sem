package Classwork3;

public class NumberBox<T extends Number> {
    private T[] numbers;

    public NumberBox(T[] numbers) {
        this.numbers = numbers;
    }

    public T[] getNumbers() {
        return numbers;
    }

    public void setNumbers(T[] numbers) {
        this.numbers = numbers;
    }

    public static void printSquared(NumberBox<? extends Number> box) {
        System.out.print("квадраты: ");
        for (Number num : box.getNumbers()) {
            double square = UniversalCalculator.multiply(num, num);
            System.out.print(square + " ");
        }
        System.out.println();
    }

    public static double sum(NumberBox<? extends Number> box) {
        double total = 0.0;
        for (Number num : box.getNumbers()) {
            total = UniversalCalculator.add(total, num);
        }
        return total;
    }

    public static double[] fillWithRandom(NumberBox<? super Number> box) {
        double[] randomNumbers = new double[box.getNumbers().length];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = Math.random() * 67;
            box.getNumbers()[i] = randomNumbers[i];
        }
        return randomNumbers;
    }

    public static void copy(NumberBox<? extends Number> box1, NumberBox<? super Number> box2) {
        Number[] array1 = box1.getNumbers();
        Number[] array2 = box2.getNumbers();
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
    }

    public static double[] addBoxes(NumberBox<? extends Number> box1, NumberBox<? extends Number> box2) {
        if (box1.getNumbers().length != box2.getNumbers().length) {
            throw new IllegalArgumentException("размер должен быть одинаковый");
        }
        double[] result = new double[box1.getNumbers().length];
        for (int i = 0; i < result.length; i++) {
            result[i] = UniversalCalculator.add(box1.getNumbers()[i], box2.getNumbers()[i]);
        }
        return result;
    }

    public void append(NumberBox<? extends Number> other) {
        int currentSize = this.numbers.length;
        int otherSize = other.getNumbers().length;
        int newSize = currentSize + otherSize;
        Number[] newArray = new Number[newSize];
        for (int i = 0; i < currentSize; i++) {
            newArray[i] = this.numbers[i];
        }
        for (int i = 0; i < otherSize; i++) {
            newArray[currentSize + i] = other.getNumbers()[i];
        }
        this.numbers = (T[])newArray;
    }
}
