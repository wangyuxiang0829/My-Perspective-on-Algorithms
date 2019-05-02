package io.github.wangyuxiang0829.algorithms.chap06;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {
    public MaxHeap(T[] A) {
        super(A);
    }




    @Override
    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (exist(l) && A[l].compareTo(A[i]) > 0)
            largest = l;
        else
            largest = i;

        if (exist(r) && A[r].compareTo(A[largest]) > 0)
            largest = r;

        if (largest != i) {
            exchange(i, largest);
            heapify(largest);
        }
    }




    @Override
    public void buildHeap() {
        heapSize = A.length;
        for (int i = (A.length - 1) >> 1; i >= 0; i--)
            heapify(i);
    }

}
