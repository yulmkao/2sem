package Homework4;

public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {  //если не знаем ссылку на след обьект
        this.data = data;
        this.next = null;
    }
}
