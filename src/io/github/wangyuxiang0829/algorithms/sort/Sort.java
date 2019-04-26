package io.github.wangyuxiang0829.algorithms.sort;

/**
 * <p>Brief: This interface requires all implementing classes must
 * have the ability to sort.
 * <p>Input: A sequence of n numbers A = < a1, a2, ..., an >.
 * <p>Output: A permutation(reordering) A' = < a1', a2', ..., an' >
 * of the input sequence such that a1' <= a2' <= ... <= an'.
 * <p>Example: Input a sequence [1, 3, 2, 5, 4, 7, 9, 8, 6], and the
 * output will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
 * @param <T> the type of the elements to be sorted
 */
public interface Sort<T> {
    /**
     * <p>Brief: This method sort the input array and return the sorted array.
     * @return an array of type T that has been sorted
     */
    T[] sort();
}
