package io.github.wangyuxiang0829.algorithms.chap02;

/**
 * <p>2.3-5
 * <p>Input: A sorted sequence A = [a1, a2, ..., an] and a value v.
 * <p>Output: An index i such that v = A[i] or the special value {NIL}
 * if v does not appear in A.
 * <p>Example: A = [1, 2, 3, 4] and v = 0 so the output will be NIL.
 * <p>Algorithms: Check the midpoint of the sequence against v and
 * eliminate half of the sequence from further consideration. Repeat
 * this procedure, halving the size of the remaining portion of the
 * sequence each time.
 * <p>Runtime: Theta(lg(n)) for the worst case.
 * @see io.github.wangyuxiang0829.algorithms.chap02.LinearSearch
 */
public class BinarySearch {

    private static <T extends Comparable<T>> Integer recursiveBinarySearch(T[] A, T v, int p, int r) {

        if (p > r) {
            return null;
        }
        else {
            int q = (p + r) / 2;
            if (A[q].compareTo(v) == 0)
                return q;
            else if (A[q].compareTo(v) < 0)
                return recursiveBinarySearch(A, v, q + 1, r);
            else
                return recursiveBinarySearch(A, v, p, q - 1);
        }

    }

    private static <T extends Comparable<T>> Integer iterativeBinarySearch(T[] A, T v, int p, int r) {

        while (p < r || p == r) {

            int q = (p + r) / 2;

            if (A[q].compareTo(v) == 0)
                return q;
            else if (A[q].compareTo(v) < 0)
                p = q + 1;
            else
                r = q - 1;

        }

        return null;
    }

    /**
     * Brief: Searching an element in a sorted sequence.
     * @param A the array to be searched on
     * @param v the element to be searched
     * @param useRecursion whether use the recursive version
     * @param <T> the type of the array to be searched on
     * @return the index i such that A[i] == v, or return
     * 'null' if the array A don't contains element v
     */
    public static <T extends Comparable<T>> Integer binarySearch(T[] A, T v, boolean useRecursion) {

        if (useRecursion)
            return recursiveBinarySearch(A, v, 0, A.length - 1);
        else
            return iterativeBinarySearch(A, v, 0, A.length - 1);

    }

}
