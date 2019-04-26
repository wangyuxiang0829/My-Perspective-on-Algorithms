package io.github.wangyuxiang0829.algorithms.sort;

import io.github.wangyuxiang0829.datastructures.MaxHeap;

public class HeapSort<T extends Comparable<T>> extends MaxHeap<T> implements ComparisonSort<T> {
    public HeapSort(T[] A) {
        super(A);
    }




    @Override
    public T[] sort() {
        buildHeap();
        for (int i = A.length - 1; i > 0; i--) {
            exchange(0, i);
            heapSize--;
            heapify(0);
        }
        return A;
    }




    /*
    public static void main(String[] args) {
        Sort<Integer> sort = new HeapSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6});
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
