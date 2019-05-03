package io.github.wangyuxiang0829.algorithms.chap10;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node head;
    private int length;

    public MyLinkedList() {
        head = null;
        length = 0;
    }

    public MyLinkedList(E element) {
        head = new Node(null, element, null);
        length = 1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(E element) {
        length++;
        Node node = new Node(null, element, head);
        if (head != null)
            head.prev = node;
        head = node;
    }

    public void delete(int index) {
        length--;
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
    }

    public E search(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.key;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                try {
                    return current.key;
                } finally {
                    current = current.next;
                }
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[ ");
        for (E e : this)
            stringBuilder.append(e).append(" ");
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public int getLength() {
        return length;
    }

    private class Node {
        Node prev;
        E key;
        Node next;

        Node(Node prev, E element, Node next) {
            this.prev = prev;
            this.key = element;
            this.next = next;
        }

    }


    /*
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++)
            list.insert(i);
        list.delete(0);
        System.out.println(list);
        System.out.println(list.getLength());
    }*/

}
