package io.github.wangyuxiang0829.algorithms.chap04.problems;

import io.github.wangyuxiang0829.algorithms.chap04.DivideAndConquerMaximumSubarray;
import io.github.wangyuxiang0829.algorithms.chap04.MaximumSubarray;
import io.github.wangyuxiang0829.util.tuple.ThreeTuple;

/**
 * <p>4.1-2
 * <p>Brief: A brute-force solution to the maximum subarray problem.
 * <p>Algorithm: Simply try every possible pair of (i, j) which is the
 * left index and right index of the subarray A[i ... j]. And for each
 * (i, j) we cost constant time to evaluate the sum of A[i ... j].
 * <p>Running Time: Because there exist Theta(n ^ 2) possible pairs of
 * (i, j) and for each (i, j) we cost Theta(1), So the running time
 * T(n) = Theta(n ^ 2).
 * @see MaximumSubarray
 * @see DivideAndConquerMaximumSubarray
 * @param <T> the type of the array A
 */
public class ViolentMaximumSubarray<T extends Number> implements MaximumSubarray<T> {

    public ThreeTuple<Integer, Integer, Double> findMaximumSubarray(T[] A) {
        double maxSum = Double.NEGATIVE_INFINITY;
        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < A.length; i++) {
            double sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j].doubleValue();
                if (sum > maxSum) {
                    maxSum = sum;
                    leftIndex = i;
                    rightIndex = j;
                }
            }
        }
        return new ThreeTuple<>(leftIndex, rightIndex, maxSum);
    }

}
