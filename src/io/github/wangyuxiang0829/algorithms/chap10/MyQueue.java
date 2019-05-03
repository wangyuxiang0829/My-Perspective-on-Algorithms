package io.github.wangyuxiang0829.algorithms.chap10;

import java.lang.reflect.Array;

public class MyQueue<E> {
    private E[] Q;
    private int tail;
    private int head;

    @SuppressWarnings("unchecked")
    public MyQueue(Class<E> E, int n) {
        tail = head = 0;
        Q = (E[]) Array.newInstance(E, n);
    }

    public void enQueue(E x) {
        Q[tail] = x;
        if (tail == Q.length - 1)
            tail = 0;
        else
            tail++;
    }

    public E deQueue() {
        E x = Q[head];
        if (head == Q.length - 1)
            head = 0;
        else
            head++;
        return x;
    }
}
