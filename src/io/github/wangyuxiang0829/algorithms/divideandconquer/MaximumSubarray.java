package io.github.wangyuxiang0829.algorithms.divideandconquer;

import io.github.wangyuxiang0829.util.tuple.*;

/**
 * <p>Brief: The maximum subarray of array A is a non-empty and continuous
 * subarray of A whose values have the largest sum.
 * <p>Input: An array A[1 ... n].
 * <p>Output: A three tuple which represents the left index of the maximum
 * subarray, the right index of the maximum subarray, the sum of the
 * maximum subarray.
 * <p>Example: Input A[1, -4, 3, -4], and the output will be 3.
 * @see io.github.wangyuxiang0829.algorithms.chap04.ViolentMaximumSubarray
 * @see io.github.wangyuxiang0829.algorithms.divideandconquer.DivideAndConquerMaximumSubarray
 * @param <T> the type of the array A
 */
public interface MaximumSubarray<T extends Number> {
    ThreeTuple<Integer, Integer, Double> findMaximumSubarray(T[] A);
}
