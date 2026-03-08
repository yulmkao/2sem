package Homework3;

public class CargoBay<T> {
    private T[] items;

    public CargoBay(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public void add(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                System.out.println("груз был добавлен!");
            }
        }
        System.out.println("слишком многа(");
    }

    public T get(int index) {
        return items[index];
    }

    public T[] getAll() {
        return items;
    }

    public int getSize() {
        int count = 0;
        for (T item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
}