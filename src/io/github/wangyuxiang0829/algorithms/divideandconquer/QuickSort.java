package io.github.wangyuxiang0829.algorithms.divideandconquer;

import io.github.wangyuxiang0829.algorithms.sort.Sort;

/**
 * <p>Brief: QuickSort implements the interface {@link
 * io.github.wangyuxiang0829.algorithms.sort.Sort Sort} and
 * can sort an array of any {@link java.lang.Comparable Comparable}
 * type T.
 * <p>Algorithm: Divide and Conquer.
 * <blockquote>
 *     <p>Divide: Partition the array into 2 subarray around the pivot
 *     x such that all elements in the lower subarray are less than or
 *     equal to x and all elements in the upper subarray are greater than
 *     or equal to x.
 *     <p>Conquer: Recursively sort the 2 subarray.
 *     <p>Combine: Because it is sorted in place, so we don't need to do
 *     anything to combine.
 * </blockquote>
 * <p>Running Time:
 * <blockquote>
 *     <p>Worst case: T(n) = Theta(n ^ 2).
 *     <p>Best case: T(n) = Theta(n * lg(n)).
 *     <p>Average case: T(n) = Theta(n * lg(n)).
 * </blockquote>
 * @param <T> the type of the elements to be sorted
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    protected T[] A;




    public QuickSort(T[] A) {
        this.A = A;
    }




    protected void exchange(int i, int j) {
        T tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }




    protected int partition(int p, int r) {
        T x = A[p];
        int i = p;

        for (int j = p + 1; j <= r; j++) {
            if (A[j].compareTo(x) <= 0) {
                i = i + 1;
                exchange(i, j);
            }
        }

        exchange(p, i);
        return i;
    }




    private void quickSort(int p, int r) {

        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }

    }




    @Override
    public T[] sort() {
        quickSort(0, A.length - 1);
        return A;
    }





    /*
    public static void main(String[] args) {
        Sort<Integer> sort = new QuickSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6});
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
