package io.github.wangyuxiang0829.algorithms.chap02.problems;

import io.github.wangyuxiang0829.algorithms.chap02.ComparisonSort;
import io.github.wangyuxiang0829.algorithms.chap02.InsertionSort;
import io.github.wangyuxiang0829.algorithms.chap02.MergeSort;

/**
 * <p>2.2-2
 * <p>Brief: SelectionSort implements the interface {@link
 * ComparisonSort ComparisonSort} and
 * can sort an array of any {@link java.lang.Comparable
 * Comparable} type T.
 * <p>Algorithm: At first, we find the smallest element of A, and
 * exchanging it with the element in A[1]. Then find the second
 * smallest element of A, and exchanging it with A[2]. Continue
 * this manner for the first n - 1 elements of A.
 * <p>Loop invariant: At the start of each outer for loop, the
 * subarray A[1, 2, ..., i - 1] always consists of the i - 1
 * smallest elements in the array A, and the subarray is in
 * the sorted order.
 * <p>Running time: All cases: T(n) = Theta(n ^ 2)
 * @see ComparisonSort
 * @see MergeSort
 * @see BubbleSort
 * @see InsertionSort
 * @param <T> the type of the elements to be sorted
 */
public class SelectionSort<T extends Comparable<T>> implements ComparisonSort<T> {
    private T[] A;
    private boolean isSorted = false;


    /**
     * <p>Brief: Constructor.
     * <p>Explanation: Construct the instance of class SelectionSort.
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
     * <p>Brief: Implement the abstract method in {@link ComparisonSort ComparisonSort}.
     * @see ComparisonSort
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
