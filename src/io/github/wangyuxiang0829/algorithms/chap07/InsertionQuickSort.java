package io.github.wangyuxiang0829.algorithms.chap07;

import io.github.wangyuxiang0829.algorithms.sort.InsertionSort;
import io.github.wangyuxiang0829.algorithms.sort.RandomizedQuickSort;


/**
 * <p>Brief: Improve the running time of {@link RandomizedQuickSort RandomizedQuickSort}
 * in practice by taking advantage of the fast running time of {@link InsertionSort
 * InsertionSort} when its input is "nearly" sorted.
 * <p>Algorithms: Upon calling quick sort on a subarray with less than or equal to k
 * elements, let it simply return without sorting the subarray. After the top-level
 * call to quick sort, run insertion sort on the entire array to finish the sorting
 * process.
 * @param <T> the type of the elements to be sorted
 */
public class InsertionQuickSort<T extends Comparable<T>> extends RandomizedQuickSort<T> {
    private InsertionSort<T> insertionSort;
    private final int k;

    public InsertionQuickSort(T[] A, int k) {
        super(A);
        this.k = k;
        insertionSort = new InsertionSort<>(A);
    }

    public InsertionQuickSort(T[] A) {
        this(A, 3);
    }

    private void insertionQuickSort(int p, int r) {
        if (p < r - k + 1) {
            int q = randomizedPartition(p, r);
            insertionQuickSort(p, q - 1);
            insertionQuickSort(q + 1, r);
        }
    }

    @Override
    public T[] sort() {
        insertionQuickSort(0, A.length - 1);
        return insertionSort.sort();
    }

    /*
    public static void main(String[] args) {
        ComparisonSort<Integer> sort = new InsertionQuickSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6});
        System.out.println(java.util.Arrays.toString(sort.sort()));

    }*/

}
