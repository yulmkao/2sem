package Homework4;

public class MyDoubleLinkedList<T> implements MyList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    @Override
    public void add(T item) {
        DoubleNode<T> newNode = new DoubleNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("aaa");
        }
        if (index == size) {
            add(item);
            return;
        }
        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        DoubleNode<T> newNode = new DoubleNode<>(item);
        newNode.next = current;
        newNode.previous = current.previous;
        if (current.previous != null) {
            current.previous.next = newNode;
        } else {
            head = newNode;
        }
        current.previous = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("aaa");
        }
        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current.data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("aaa");
        }
        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.previous = current.previous;
        } else {
            tail = current.previous;
        }
        size--;
        return current.data;
    }

    @Override
    public boolean remove(T item) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }
                size--;
                return true;
            }
            current = current.next;
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
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        DoubleNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}