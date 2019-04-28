package io.github.wangyuxiang0829.algorithms.chap09;

/**
 * <p>Brief: Selecting the ith order statistic from a set of n elements.
 * <p>Explanation: The ith order statistic of a set of n elements is the ith smallest element.
 * <p>Selection problem:
 * <blockquote>
 *     <p>Input: A set of n elements and an integer i, with 1<= i <= n.
 *     <p>Output: The element x in the set A that is larger than exactly i - 1 other elements of A.
 * </blockquote>
 * @param <T> the type of element in the set A
 */
public abstract class SelectionProblem<T extends Comparable<T>> {
    T[] A;
    int i;

    SelectionProblem(T[] A, int i) {
        if (i < 1 || i > A.length)
            throw new IllegalArgumentException("the ith order statistic requires i >= 1 && i <= n");
        this.A = A;
        this.i = i;
    }

    public abstract T getOrderStatistic();

}
