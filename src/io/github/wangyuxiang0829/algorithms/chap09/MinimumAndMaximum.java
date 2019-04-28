package io.github.wangyuxiang0829.algorithms.chap09;

import io.github.wangyuxiang0829.util.tuple.TwoTuple;

/**
 * <p>Brief: Simultaneous minimum and maximum.
 * <p>Explanation: Find the minimum and maximum element of a set of n elements at the same time.
 * @param <T> the type of element in the set A
 */
public class MinimumAndMaximum<T extends Comparable<T>> {
    private T[] A;

    public MinimumAndMaximum(T[] A) {
        this.A = A;
    }

    /**
     * <p>Brief: Find the minimum and maximum independently.
     * <p>Explanation: Need 2n - 2 comparisons.
     * <p>Running Time: T(n) = Theta(n)
     * @return the minimum and maximum element
     */
    @Deprecated
    public TwoTuple<T, T> naiveGetMinAndMax() {
        T min = A[0];
        T max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (min.compareTo(A[i]) > 0)
                min = A[i];
            if (max.compareTo(A[i]) < 0)
                max = A[i];
        }

        return new TwoTuple<>(min, max);
    }


    private TwoTuple<T, T> competition(T min, T max, int i, int j) {
        T smaller, bigger;
        if (A[i].compareTo(A[j]) < 0) {
            smaller = A[i];
            bigger = A[j];
        }
        else {
            smaller = A[j];
            bigger = A[i];
        }
        if (min.compareTo(smaller) > 0)
            min = smaller;
        if (max.compareTo(bigger) < 0)
            max = bigger;

        return new TwoTuple<>(min, max);
    }


    /**
     * <p>Brief: Process elements in pairs.
     * <p>Explanation: We compare pairs of elements from the input first with each other, and
     * then compare the smaller with current minimum and larger to the current maximum, at a
     * cost of 3 comparisons for every 2 elements. So at most 3[n / 2] comparisons.
     * <p>Running time: T(n) = Theta(n)
     * @return the minimum and maximum element
     */
    public TwoTuple<T, T> getMinAndMax() {
        T min, max;

        if (A.length % 2 == 0) {
            if (A[0].compareTo(A[1]) < 0) {
                min = A[0];
                max = A[1];
            }
            else {
                min = A[1];
                max = A[0];
            }
            for (int i = 2; i < A.length; i = i + 2) {
                TwoTuple<T, T> minAndMax = competition(min, max, i, i + 1);
                min = minAndMax.first;
                max = minAndMax.second;
            }
        }
        else {
            min = max = A[0];
            for (int i = 1; i < A.length; i = i + 2) {
                TwoTuple<T, T> minAndMax = competition(min, max, i, i + 1);
                min = minAndMax.first;
                max = minAndMax.second;
            }
        }

        return new TwoTuple<>(min, max);
    }


    /*
    public static void main(String[] args) {
        MinimumAndMaximum<Integer> minAndMax = new MinimumAndMaximum<>(new Integer[]{3, 2, 1});
        System.out.println(minAndMax.getMinAndMax());
    }*/

}
