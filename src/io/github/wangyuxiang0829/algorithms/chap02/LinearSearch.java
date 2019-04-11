package io.github.wangyuxiang0829.algorithms.chap02;

/**
 * <p>2.1-3
 * <p>Input: A sequence of n numbers A = [a1, a2, ..., an] and a value v.
 * <p>Output: An index i such that v = A[i] or the special value {NIL}
 * if v does not appear in A.
 * <p>Example: A = [1, 2, 3, 4] and v = 0 so the output will be NIL.
 * <p>Loop invariant: the subarray A[1, 2, ..., i - 1]. At the start of
 * each for loop, the subarray A[1, 2, ..., i - 1] always don't have the
 * value v.
 * <p>Runtime: Theta(n) for the worst time.
 * @see io.github.wangyuxiang0829.algorithms.chap02.BinarySearch
 */
public class LinearSearch {

    /**
     * Brief: Scan the array 'A' to search an element 'v'.
     * @param A the array to be searched on
     * @param v the element to be searched
     * @param <T> the type of the array to be searched on
     * @return the index i such that A[i] == v, or return
     * 'null' if the array A don't contains element v
     */
    public static <T extends Comparable<T>> Integer linearSearch(T[] A, T v) {
        for (int i = 0; i < A.length; i++)
            if (A[i].compareTo(v) == 0)
                return i;
        return null;
    }

}
