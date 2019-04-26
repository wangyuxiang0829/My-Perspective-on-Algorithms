package io.github.wangyuxiang0829.algorithms.sort;

/**
 * <p>Brief: This interface extends the interface {@link Sort Sort} and
 * requires every implementing class can sort in linear time.
 * <p>Explanation: Beat the lower bound of Omega(nlg(n)) by gathering information
 * about the sorted order of the input sequence by means other than comparing each
 * elements.
 * @see CountingSort
 */
public interface LinearTimeSort extends Sort<Integer> {

}
