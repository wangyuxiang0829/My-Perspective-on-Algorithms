package io.github.wangyuxiang0829.algorithms.chap02;

import io.github.wangyuxiang0829.algorithms.chap02.problems.BubbleSort;
import io.github.wangyuxiang0829.algorithms.chap02.problems.SelectionSort;
import io.github.wangyuxiang0829.algorithms.chap06.HeapSort;
import io.github.wangyuxiang0829.algorithms.chap07.RandomizedQuickSort;

import java.lang.reflect.Array;

/**
 * <p>Brief: MergeSort implements the interface {@link ComparisonSort ComparisonSort}
 * and can sort an array of any {@link java.lang.Comparable Comparable} type T.
 * <p>Algorithm(divide-and-conquer):
 * <blockquote>
 *     <p>Divide: Divide the n-element sequence to be sorted into two
 *     sub sequences of n/2 elements each.
 *     <p>Conquer: Recursively sort the two sub sequences using merge
 *     sort, when the size of sub sequence is less than or equal to
 *     1, just return because it is sorted.
 *     <p>Combine: Merge the two sorted sub sequences to produce the
 *     sorted answer.
 * </blockquote>
 * <p>Runtime: All cases: T(n) = Theta(nlg(n))
 * @see HeapSort
 * @see InsertionSort
 * @see RandomizedQuickSort
 * @see BubbleSort
 * @see SelectionSort
 * @param <T> the type of the elements to be sorted
 */
public class MergeSort<T extends Comparable<T>> implements ComparisonSort<T> {
    private T[] A;
    private Class<T> tClass;
    private boolean isSorted = false;




    /**
     * <p>Brief: Constructor.
     * <p>Explanation: Construct the instance of the class MergeSort.
     * @param A an array of type T
     * @param tClass the Class object of the type T
     */
    public MergeSort(T[] A, Class<T> tClass) {
        this.A = A;
        this.tClass = tClass;
    }




    /**
     * <p>Brief: Merge the two sorted sub sequences to produce
     * the sorted answer.
     * <p>Explanation: Suppose we have two piles of cards face
     * up on a table. Each pile is sorted, with the smallest cards
     * on top. We wish to merge the two piles into a single sorted
     * output pile, which is to be face down on the table. Our basic
     * step consists of choosing the smaller of the two cards on top
     * of the face-up piles, removing it from its pile (which exposes
     * a new top card), and placing this card face down onto the output
     * pile. We repeat this step until one input pile is empty, at which
     * time we just take the remaining input pile and place it face down
     * onto the output pile.
     * <p>Loop invariant: At the start of each iteration of the for loop,
     * the subarray A[p, p + 1, ..., k - 1] contains the k - p smallest
     * elements of L[1, 2, ..., n1 + 1] and R[1, 2, ..., n2 + 1] in sorted
     * order. Moreover, L[i] and R[j] are the smallest elements of their
     * arrays that have not been copied back into A.
     * <p>Runtime: Theta(n) for the worst case.
     * @param p the left index of the array to be merged
     * @param q the middle index of the array to be merged
     * which separate the two sorted subarray.
     * @param r the right index of the array to be merged
     */
    @SuppressWarnings("unchecked")
    private void merge(int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        T[] L = (T[]) Array.newInstance(tClass, n1);
        T[] R = (T[]) Array.newInstance(tClass, n2);

        System.arraycopy(A, p, L, 0, n1);
        System.arraycopy(A, q + 1, R, 0, n2);

        int i = 0, j = 0, k = p;

        try {

            for (; k <= r ; k++) {

                if (L[i].compareTo(R[j]) <= 0) {
                    A[k] = L[i++];
                }
                else {
                    A[k] = R[j++];
                }

            }

        } catch (ArrayIndexOutOfBoundsException e) {

            if (i >= n1) {
                System.arraycopy(R, j, A, k, r - k + 1);
            }
            else {
                System.arraycopy(L, i, A, k, r - k + 1);
            }

        }

    }




    /**
     * <p>Brief: Divide the array into two subarray and sort
     * the two subarray recursively. Finally, combine the
     * sorted subarray.
     * <p>Base case: if q == r, then the subarray only have
     * one element, so it is sorted, and we don't have to
     * do anything.
     * @param p the left index of the array to be sorted
     * @param r the right index of the array to be sorted
     */
    private void mergeSort(int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }

    }




    /**
     * <p>Brief: Implement the abstract method in the interface ComparisonSort.
     * @see ComparisonSort#sort()
     * @return the sorted array
     */
    public T[] sort() {

        if (!isSorted) {
            isSorted = true;

            mergeSort(0, A.length - 1);
        }

        return A;
    }


    /*
    public static void main(String[] args) {
        Sort<Integer> sort = new MergeSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6}, Integer.class);
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
