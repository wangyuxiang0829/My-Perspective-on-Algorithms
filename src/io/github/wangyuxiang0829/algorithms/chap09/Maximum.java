package io.github.wangyuxiang0829.algorithms.chap09;

/**
 * <p>Brief: Get the nth order statistic of a set {@code A} i.e. the maximum element.
 * <p>Explanation: To find the maximum element of a set of n elements, need at least n - 1 comparisons.
 * <p>Running Time: T(n) = Theta(n)
 * @param <T> the type of element in the set A
 */
public class Maximum<T extends Comparable<T>> extends SelectionProblem<T> {
    public Maximum(T[] A) {
        super(A, A.length);
    }

    @Override
    public T getOrderStatistic() {
        T max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (max.compareTo(A[i]) < 0)
                max = A[i];
        }

        return max;
    }

    /*
    public static void main(String[] args) {
        SelectionProblem<Integer> maximum = new Maximum<>(new Integer[]{3, 2, 1});
        System.out.println(maximum.getOrderStatistic());
    }*/

}
