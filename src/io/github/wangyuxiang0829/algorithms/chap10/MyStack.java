package io.github.wangyuxiang0829.algorithms.chap10;

import java.lang.reflect.Array;

public class MyStack<E> {
    private E[] S;
    private int top;


    @SuppressWarnings("unchecked")
    public MyStack(Class<E> E, int n) {
        top = -1;
        S = (E[]) Array.newInstance(E, n);
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public void push(E x) throws StackOverflowException {
        top++;
        if (top == S.length)
            throw new StackOverflowException();
        S[top] = x;
    }


    public E pop() throws StackUnderflowException {
        if (top == -1)
            throw new StackUnderflowException();
        if (top == S.length)
            top = S.length - 1;
        top--;
        return S[top + 1];
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= top; i++)
            stringBuilder.append(S[i]).append(" ");

        return stringBuilder.toString();
    }


    /*
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(Integer.class, 10);
        try {
            for (int i = 10; i < 21; i++)
                stack.push(i);
        } catch (StackOverflowException e) {
            System.out.println("stack overflow");
            try {
                stack.pop();
            } catch (StackUnderflowException s) {
                System.out.println("stack underflow");
            }
            System.out.println(stack);
        }
    }*/

}
