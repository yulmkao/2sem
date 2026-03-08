package Homework4;

public class DoubleNode<E> {
    E data;
    DoubleNode<E> next;
    DoubleNode<E> previous;

    DoubleNode(E data) {
        this.data = data;
    }
}