package Homework4;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int size;

    @Override
    public void add(T item) {
        if (head == null) {
            head = new Node<>(item);
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(item);
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ааа");
        }
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ааа");
        }
        int counter = 0;
        Node<T> node = head;
        while (counter < index) {
            node = node.next;
            counter++;
        }
        return node.data;
    }

    @Override
    public T remove(int index) {
        T removedItem;
        if (index == 0) {
            removedItem = head.data;
            head = head.next;
        } else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            removedItem = node.next.data;
            node.next = node.next.next;
        }
        size--;
        return removedItem;
    }

    @Override
    public boolean remove(T item) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(item)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> node = head;
        while (node.next != null) {
            if (node.next.data.equals(item)) {
                node.next = node.next.next;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        Node<T> node = head;
        int index = 0;
        while (node != null) {
            if (node.data.equals(item)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }
}