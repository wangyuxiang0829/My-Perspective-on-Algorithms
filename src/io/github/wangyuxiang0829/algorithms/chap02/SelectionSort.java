package io.github.wangyuxiang0829.algorithms.chap02;

import io.github.wangyuxiang0829.algorithms.sort.Sort;

/**
 * <p>2.2-2
 * <p>Brief: SelectionSort implements the interface {@link
 * io.github.wangyuxiang0829.algorithms.sort.Sort Sort} and
 * can sort an array of any {@link java.lang.Comparable
 * Comparable} type T.
 * <p>Input: A sequence of n numbers A = [a1, a2, ..., an].
 * <p>Output: A permutation(reordering) A' = [a1', a2', ..., an']
 * of the input sequence such that a1' <= a2' <= ... <= an'.
 * <p>Example: Input a sequence [1, 3, 2, 5, 4, 7, 9, 8], and the
 * output will be [1, 2, 3, 4, 5, 7, 8, 9].
 * <p>Algorithm: At first, we find the smallest element of A, and
 * exchanging it with the element in A[1]. Then find the second
 * smallest element of A, and exchanging it with A[2]. Continue
 * this manner for the first n - 1 elements of A.
 * <p>Loop invariant: At the start of each outer for loop, the
 * subarray A[1, 2, ..., i - 1] always consists of the i - 1
 * smallest elements in the array A, and the subarray is in
 * the sorted order.
 * <p>Running time: Theta(n ^ 2) for all cases.
 * @see io.github.wangyuxiang0829.algorithms.sort.Sort
 * @see io.github.wangyuxiang0829.algorithms.sort.MergeSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.BubbleSort
 * @see io.github.wangyuxiang0829.algorithms.sort.InsertionSort
 * @param <T> the type of the elements to be sorted
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    private T[] A;
    private boolean isSorted = false;


    /**
     * Brief: Constructor.
     * Explanation: Construct the instance of class SelectionSort.
     * @param A an array of type T
     */
    public SelectionSort(T[] A) {
        this.A = A;
    }




    // exchange the element A[i] with A[j].
    private void exchange(int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    /**
     * <p>Brief: Implement the abstract method in the interface Sort.
     * @see io.github.wangyuxiang0829.algorithms.sort.Sort
     * @return the sorted array
     */
    public T[] sort() {

        if (!isSorted) {
            isSorted = true;

            for (int i = 0; i < A.length - 1; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i].compareTo(A[j]) > 0)
                        exchange(i, j);
                }
            }

        }

        return A;
    }

}
