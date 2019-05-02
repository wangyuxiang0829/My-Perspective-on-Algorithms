package io.github.wangyuxiang0829.algorithms.chap09;

import io.github.wangyuxiang0829.algorithms.chap07.RandomizedQuickSort;

/**
 * <p>Brief: Selection in expected linear time.
 * <p>Algorithm: Divide and Conquer:
 * <blockquote>
 *     <p>Divide: Use the procedure {@link RandomizedQuickSort#randomizedPartition(int, int)}
 *     partitions the array A[p ... r] into two sub arrays A[p ... q - 1] and A[q + 1 ... r],
 *     and we call A[q] pivot.
 *     <p>Conquer: Get the rank of pivot {@code k = q - p + 1} which means the pivot is the kth
 *     smallest element in the array A[p ... r], and then compare k with i, and we have three
 *     conditions:
 *     <blockquote>
 *         <p>if {@code i == k}, then the pivot is the answer i.e. the ith order statistic.
 *         <p>else if {@code i < k}, then we recursively find the ith order statistic in the
 *         left subarray A[p ... q - 1].
 *         <p>else {@code i > k}, then because we know that there are k elements that are smaller
 *         than ith order statistic in array A[p ... r], so we recursively find the {@code i - k}
 *         order statistic element in the right subarray A[q + 1 ... r].
 *     </blockquote>
 *     <p>Combine: Nothing to do.
 * </blockquote>
 * <p>Running Time:
 * <blockquote>
 *     <p>Worst case: T(n) = Theta(n ^ 2)
 *     <p>Expected: E[T(n)] = Theta(n)
 * </blockquote>
 * @param <T> the type of element in the set A
 */
public class RandomizedSelect<T extends Comparable<T>> extends SelectionProblem<T> {
    private RandomizedQuickSort<T> randomizedQuickSort;




    public RandomizedSelect(T[] A, int i) {
        super(A, i);
        randomizedQuickSort = new RandomizedQuickSort<>(A);
    }




    private T randomizedSelect(int p, int r, int i) {
        if (p == r)
            return A[p];

        int q = randomizedQuickSort.randomizedPartition(p, r);
        int k = q - p + 1;

        if (i == k)
            return A[q];
        else if (i < k)
            return randomizedSelect(p, q - 1, i);
        else
            return randomizedSelect(q + 1, r, i - k);

    }




    @Override
    public T getOrderStatistic() {
        return randomizedSelect(0, A.length - 1, i);
    }


    /*
    public static void main(String[] args) {
        System.out.println(new RandomizedSelect<Integer>(new Integer[]{3, 2, 1}, 2).getOrderStatistic());
    }*/

}
