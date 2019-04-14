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
 * <p>Algorithm: Divide and Conquer.
 * <blockquote>
 *     <p>Explanation: The maximum subarray A[i ... j] of an array
 *     A[low ... high] can only exist in the following three places:
 *     <blockquote>
 *         <p>Entirely in the left subarray A[low ... mid] so that
 *         low <= i <= j <= mid.
 *         <p>Entirely in the right subarray A[(mid + 1) ... high]
 *         so that mid < i <= j <= high.
 *         <p>Crossing the midpoint so that low <= i <= mid < j <= high.
 *     </blockquote>
 *     <p>Divide: Divide the array A[low ... high] into two subarray
 *     A[low ... mid] and A[(mid + 1) ... high].
 *     <p>Conquer: Recursively find the maximum subarray in the two
 *     subarray which we called left subarray and right subarray, and
 *     when the sub-problem size is small enough which means there exist
 *     only one element in the subarray, then we just solve it non-recursive.
 *     <p>Combine: Find the maximum subarray crossing the midpoint and compare
 *     with the other two subarray to find the max subarray.
 * </blockquote>
 * <p>Running Time: T(n) = Theta(nlg(n)).
 */
public class DivideAndConquerMaximumSubarray<T extends Number> implements MaximumSubarray<T> {

    private ThreeTuple<Integer, Integer, Double> findMaxCrossingSubarray(T[] A, int low, int mid, int high) {

        double leftSum = Double.NEGATIVE_INFINITY;
        double sum = 0;
        int minLeftIndex = 0;
        for (int i = mid; i >= low; i--) {
            sum += A[i].doubleValue();
            if (sum > leftSum) {
                leftSum = sum;
                minLeftIndex = i;
            }
        }
        double rightSum = Double.NEGATIVE_INFINITY;
        sum = 0;
        int maxRightIndex = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += A[j].doubleValue();
            if (sum > rightSum) {
                rightSum = sum;
                maxRightIndex = j;
            }
        }

        return new ThreeTuple<>(minLeftIndex, maxRightIndex, leftSum + rightSum);

    }

    private ThreeTuple<Integer, Integer, Double> findMaximumSubarray(T[] A, int low, int high) {

        if (low == high)
            return new ThreeTuple<>(low, high, A[low].doubleValue());
        else {
            int mid = (low + high) / 2;
            ThreeTuple<Integer, Integer, Double> leftMaximumSubarray = findMaximumSubarray(A, low, mid);
            ThreeTuple<Integer, Integer, Double> rightMaximumSubarray = findMaximumSubarray(A, mid + 1, high);
            ThreeTuple<Integer, Integer, Double> crossingMidMaximumSubarray = findMaxCrossingSubarray(A, low, mid, high);
            if (leftMaximumSubarray.third > rightMaximumSubarray.third && leftMaximumSubarray.third > crossingMidMaximumSubarray.third)
                return leftMaximumSubarray;
            else if (rightMaximumSubarray.third > leftMaximumSubarray.third && rightMaximumSubarray.third > crossingMidMaximumSubarray.third)
                return rightMaximumSubarray;
            else
                return crossingMidMaximumSubarray;
        }

    }

    public ThreeTuple<Integer, Integer, Double> findMaximumSubarray(T[] A) {
        return findMaximumSubarray(A, 0, A.length - 1);
    }

}
