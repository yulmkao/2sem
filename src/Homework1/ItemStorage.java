package Homework1;

public class ItemStorage<T> {
    private T value;

    public ItemStorage(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void compareWith(T otherValue) {
        if (value == null || otherValue == null) {
            throw new IllegalArgumentException("ревизия невозможна, обьект не найден");
        }
        System.out.println("сравнение ссылок: " + (value == otherValue));
        System.out.println("сравнение значений: " + value.equals(otherValue));
        if (value.equals(otherValue)) {
            System.out.println("значения идентичны. контроль качества пройден");
        }
    }
}
