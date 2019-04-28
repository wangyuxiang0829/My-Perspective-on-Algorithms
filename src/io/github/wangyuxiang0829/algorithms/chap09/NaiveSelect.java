package io.github.wangyuxiang0829.algorithms.chap09;

import io.github.wangyuxiang0829.algorithms.sort.HeapSort;

public class NaiveSelect<T extends Comparable<T>> extends SelectionProblem<T> {
    private HeapSort<T> heapSort;

    public NaiveSelect(T[] A, int i) {
        super(A, i);
        heapSort = new HeapSort<>(A);
    }

    @Override
    public T getOrderStatistic() {
        heapSort.sort();
        return A[i - 1];
    }

    /*
    public static void main(String[] args) {
        System.out.println(new NaiveSelect<Integer>(new Integer[]{3, 2, 1}, 2).getOrderStatistic());
    }*/
}
