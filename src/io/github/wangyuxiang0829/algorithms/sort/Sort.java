package io.github.wangyuxiang0829.algorithms.sort;

/**
 * <p>Brief: The interface that requires all implement classes must
 * have the ability to sort.
 * <p>Requirement: All the elements to be sorted must be a kind of
 * Comparable.
 * @see io.github.wangyuxiang0829.algorithms.sort.MergeSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.BubbleSort
 * @see io.github.wangyuxiang0829.algorithms.sort.InsertionSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.SelectionSort
 * @param <T> the type of the elements to be sorted
 */
public interface Sort<T extends Comparable<T>> {
    T[] sort();
}
