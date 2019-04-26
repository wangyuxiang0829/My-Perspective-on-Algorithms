package io.github.wangyuxiang0829.algorithms.sort;

/**
 * <p>Brief: This interface extends {@link Sort Sort} and requires every
 * implementing class can use only comparison to determine the relative
 * order of each element.
 * <p>Requirement: All the elements to be sorted must be a kind of
 * {@link java.lang.Comparable Comparable}.
 * <p>Running Time: For all comparison sorts
 * <blockquote>
 *     <p>T(n) = Omega(nlg(n))
 * </blockquote>
 * @see HeapSort
 * @see MergeSort
 * @see InsertionSort
 * @see RandomizedQuickSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.BubbleSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.SelectionSort
 * @see io.github.wangyuxiang0829.algorithms.chap07.InsertionQuickSort
 * @see io.github.wangyuxiang0829.algorithms.divideandconquer.QuickSort
 * @see io.github.wangyuxiang0829.algorithms.chap07.ImprovedRandomizedQuickSort
 * @param <T> the type of the elements to be sorted
 */
public interface ComparisonSort<T extends Comparable<T>> extends Sort<T> {

}
