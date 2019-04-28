package io.github.wangyuxiang0829.algorithms.chap09;

/**
 * <p>Brief: Get the first order statistic of a set {@code A} i.e. the minimum element.
 * <p>Explanation: To find the minimum element of a set of n elements, need at least n - 1 comparisons.
 * <p>Running Time: T(n) = Theta(n)
 * @param <T> the type of element in the set A
 */
public class Minimum<T extends Comparable<T>> extends SelectionProblem<T> {
    public Minimum(T[] A) {
        super(A, 1);
    }

    @Override
    public T getOrderStatistic() {
        T min = A[0];

        for (int i = 1; i < A.length; i++) {
            if (min.compareTo(A[i]) > 0)
                min = A[i];
        }

        return min;
    }

    /*
    public static void main(String[] args) {
        SelectionProblem<Integer> minimum = new Minimum<>(new Integer[]{3, 2, 1});
        System.out.println(minimum.getOrderStatistic());
    }*/

}
