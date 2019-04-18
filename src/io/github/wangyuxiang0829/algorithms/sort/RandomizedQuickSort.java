package io.github.wangyuxiang0829.algorithms.sort;

import io.github.wangyuxiang0829.algorithms.divideandconquer.QuickSort;

import java.util.Random;

public class RandomizedQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    public RandomizedQuickSort(T[] A) {
        super(A);
    }




    private static int random(int i, int j) {
        Random random = new Random();

        return random.nextInt(j - i + 1) + i;
    }




    protected int partition(int p, int r) {
        int random = random(p, r);

        super.exchange(random, p);

        return super.partition(p, r);
    }




    private void randomizedQuickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            randomizedQuickSort(p, q - 1);
            randomizedQuickSort(q + 1, r);
        }
    }




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
