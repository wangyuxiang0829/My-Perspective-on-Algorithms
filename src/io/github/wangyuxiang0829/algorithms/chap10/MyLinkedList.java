package io.github.wangyuxiang0829.algorithms.chap10;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node sentinel;
    private int length;


    public MyLinkedList() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
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


    public Node search(int index) {
        if (index < 0 || index >= length)
            throw new LinkedListIndexOutOfBoundsException();
        Node x = sentinel.next;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }


    public void delete(int index) {
        Node node = search(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        length--;
    }


    public void delete(Node node) {
        if (node.getLinkedList() != this)
            throw new IllegalArgumentException("this node isn't in this LinkedList");
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    public E get(int index) {
        return search(index).key;
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


    public class Node {
        private Node prev;
        private E key;
        private Node next;


        Node(Node prev, E element, Node next) {
            this.prev = prev;
            this.key = element;
            this.next = next;
        }


        MyLinkedList<E> getLinkedList() {
            return MyLinkedList.this;
        }


        @Override
        public String toString() {
            return key.toString();
        }

    }


    /*
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.insert(i);
        }
        System.out.println(list);
        System.out.println(list.get(0));
        list.delete(1);
        System.out.println(list);
        System.out.println(list.getLength());
    }*/


}
