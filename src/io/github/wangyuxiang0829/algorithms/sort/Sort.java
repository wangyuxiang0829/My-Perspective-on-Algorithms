package io.github.wangyuxiang0829.algorithms.sort;

/**
 * <p>Brief: The interface requires all implementing classes must
 * have the ability to sort.
 * <p>Requirement: All the elements to be sorted must be a kind of
 * {@link java.lang.Comparable Comparable}.
 * <p>Input: A sequence of n numbers A = [a1, a2, ..., an].
 * <p>Output: A permutation(reordering) A' = [a1', a2', ..., an']
 * of the input sequence such that a1' <= a2' <= ... <= an'.
 * <p>Example: Input a sequence [1, 3, 2, 5, 4, 7, 9, 8, 6], and the
 * output will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
 * @see io.github.wangyuxiang0829.algorithms.sort.MergeSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.BubbleSort
 * @see io.github.wangyuxiang0829.algorithms.sort.InsertionSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.SelectionSort
 * @see io.github.wangyuxiang0829.algorithms.sort.RandomizedQuickSort
 * @see io.github.wangyuxiang0829.algorithms.chap07.InsertionQuickSort
 * @see io.github.wangyuxiang0829.algorithms.divideandconquer.QuickSort
 * @see io.github.wangyuxiang0829.algorithms.chap07.ImprovedRandomizedQuickSort
 * @param <T> the type of the elements to be sorted
 */
public interface Sort<T extends Comparable<T>> {
    T[] sort();
}
