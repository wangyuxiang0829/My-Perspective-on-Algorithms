package io.github.wangyuxiang0829.algorithms.chap10;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node sentinel;
    private int length;


    public MyLinkedList() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        length = 0;
    }


    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }


    public void insert(E element) {
        Node node = new Node(sentinel, element, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        length++;
    }


    private Node get(int index) {
        if (index < 0 || index >= length)
            throw new LinkedListIndexOutOfBoundsException();
        Node x = sentinel.next;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }


    public void delete(int index) {
        Node node = get(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        length--;
    }


    private Node get(E element) {
        Node x = sentinel.next;
        while (x != sentinel && !x.key.equals(element))
            x = x.next;
        return x;
    }


    public void delete(E element) {
        Node node = get(element);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        length--;
    }


    public E search(int index) {
        return get(index).key;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node current = sentinel;

            @Override
            public boolean hasNext() {
                return current.next != sentinel;
            }

            @Override
            public E next() {
                current = current.next;
                return current.key;
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
        list.delete(Integer.valueOf(4));
        System.out.println(list);
        System.out.println(list.getLength());
    }*/

}
