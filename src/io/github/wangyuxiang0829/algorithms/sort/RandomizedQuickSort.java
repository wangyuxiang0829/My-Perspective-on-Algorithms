package io.github.wangyuxiang0829.algorithms.sort;

import io.github.wangyuxiang0829.algorithms.divideandconquer.QuickSort;
import java.util.Random;

/**
 * <p>Brief: A randomized version of {@link QuickSort QuickSort}.
 * <p>Explanation: Instead of always using A[p] as the pivot, we will select a randomly
 * chosen element from the subarray A[p ... r].
 * <p>Running Time:
 * <blockquote>
 *     <p>Expected running rime: E[T(n)] = Theta(nlg(n))
 *     <p>Worst case running time: T(n) = Theta(n ^ 2)
 * </blockquote>
 * @param <T> the type of the elements to be sorted
 */
public class RandomizedQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    public RandomizedQuickSort(T[] A) {
        super(A);
    }




    protected static int random(int i, int j) {
        Random random = new Random();

        return random.nextInt(j - i + 1) + i;
    }




    protected int randomizedPartition(int p, int r) {
        exchange(random(p, r), p);

        return partition(p, r);
    }




    private void randomizedQuickSort(int p, int r) {
        if (p < r) {
            int q = randomizedPartition(p, r);
            randomizedQuickSort(p, q - 1);
            randomizedQuickSort(q + 1, r);
        }
    }




    @Override
    public T[] sort() {
        randomizedQuickSort(0, A.length - 1);
        return A;
    }



    /*
    public static void main(String[] args) {
        Sort<Integer> sort = new RandomizedQuickSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6});
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
