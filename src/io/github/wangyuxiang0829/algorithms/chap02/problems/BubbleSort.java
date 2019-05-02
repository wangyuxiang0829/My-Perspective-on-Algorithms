package io.github.wangyuxiang0829.algorithms.chap02.problems;

import io.github.wangyuxiang0829.algorithms.chap02.ComparisonSort;
import io.github.wangyuxiang0829.algorithms.chap02.InsertionSort;
import io.github.wangyuxiang0829.algorithms.chap02.MergeSort;

/**
 * <p>2-2
 * <p>Brief: BubbleSort implements the interface {@link ComparisonSort ComparisonSort}
 * and can sort an array of any {@link java.lang.Comparable Comparable} type T.
 * <p>Algorithms: We find the smallest element in the input sequence via compare
 * and swap continuously from an to a1, and so a1 will be the smallest element.
 * Then find the second smallest element and swap it to a2. And repeat this operation
 * n - 1 times, so at last, an will automatically be largest element. So, the sequence
 * is sorted.
 * <p>Runtime: All cases: T(n) = Theta(n ^ 2).
 * @see ComparisonSort
 * @see MergeSort
 * @see InsertionSort
 * @see SelectionSort
 * @param <T> the type of the elements to be sorted
 */
public class BubbleSort<T extends Comparable<T>> implements ComparisonSort<T> {
    private T[] A;
    private boolean isSorted = false;




    /**
     * <p>Brief: Constructor.
     * <p>Explanation: Construct the instance of the class BubbleSort.
     * @param A an array represent the input sequence
     */
    public BubbleSort(T[] A) {
        this.A = A;
    }




    // exchange the element A[i] with A[j]
    private void exchange(int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }




    /**
     * <p>Brief: Implement the abstract method in the interface {@link
     * ComparisonSort ComparisonSort}.
     * <p>Loop invariant:
     * <blockquote>
     *     <p>Inner for loop: At the start of each iteration, the element
     *     A[j] is always the smallest in the subarray A[j, ..., n].
     * </blockquote>
     * <blockquote>
     *     <p>Outer for loop: At the start of each iteration, the subarray
     *     A[1, ..., i - 1] always contains the first (i - 1) smallest
     *     element and is sorted.
     * </blockquote>
     * @return the sorted array of type T
     */
    public T[] sort() {
        if (!isSorted) {
            isSorted = true;

            for (int i = 0; i < A.length - 1; i++)
                for (int j = A.length - 1; j > i; j--)
                    if (A[j].compareTo(A[j - 1]) < 0)
                        exchange(j - 1, j);
        }

        return A;
    }



    /*
    public static void main(String[] args) {
        ComparisonSort<Integer> sort = new BubbleSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6});
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
