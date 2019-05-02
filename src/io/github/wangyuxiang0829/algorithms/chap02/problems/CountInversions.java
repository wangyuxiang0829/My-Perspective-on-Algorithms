package io.github.wangyuxiang0829.algorithms.chap02.problems;

import java.lang.reflect.Array;

/**
 * <p>2-4
 * <p>Question Brief: To determine the number of inversions
 * in an array of n distinct elements. If i < j and A[i] >
 * A[j], then the pair (i, j) is called an inversion of A.
 * <p>Input: An array of n distinct elements A = [a1, a2,
 * ..., an].
 * <p>Output: The numbers of inversions in the array A.
 * <p>Example: Input A[5, 3, 2, 1] and will output 6.
 * <p>Algorithm: Just like sorting.
 * @param <T> the type of the array A
 */
public class CountInversions<T extends Comparable<T>> {
    private T[] A;
    private Class<T> tClass;




    /**
     * Brief: Constructor.
     * Explanation: Construct an instance of the class
     * CountInversions to get the numbers of inversions
     * in the array A.
     * @param A an array of n distinct elements
     * @param tClass the Class object of the T
     */
    public CountInversions(T[] A, Class<T> tClass) {
        this.A = A;
        this.tClass = tClass;
    }




    /**
     * Brief: Overloading method which will automatically
     * use the faster merge sort to get the result.
     * @return the number of inversions in this array
     */
    public int getInversions() {
        return getInversions(false);
    }




    /**
     * Brief: The user interface to get the number of
     * inversions in the array A.
     * @param useInsertionSort if true, this method will use
     * InsertionSort to get the number of inversions
     * @return the number of inversions in this array
     */
    public int getInversions(boolean useInsertionSort) {
        if (useInsertionSort) {
            return new InsertionSortForInversions().countInversions();
        }
        else {
            return new MergeSortForInversions().countInversions(0, A.length - 1);
        }
    }

    private class InsertionSortForInversions {
        private int numberOfInversions = 0;

        private int countInversions() {

            for (int j = 1; j < A.length; j++) {
                T key = A[j];
                int i = j - 1;
                while (i > -1 && A[i].compareTo(key) > 0) {
                    A[i + 1] = A[i];
                    i--;
                    numberOfInversions++;
                }
                A[i + 1] = key;
            }

            return numberOfInversions;
        }

    }

    private class MergeSortForInversions {

        @SuppressWarnings("unchecked")
        private int mergeInversions(int p, int q, int r) {
            int n1 = q - p + 1;
            int n2 = r - q;

            T[] L = (T[]) Array.newInstance(tClass, n1);
            T[] R = (T[]) Array.newInstance(tClass, n2);

            System.arraycopy(A, p, L, 0, n1);
            System.arraycopy(A, q + 1, R, 0, n2);

            int inversions = 0;
            int i = 0, j = 0, k = p;

            try {

                for (; k < r || k == r; k++) {

                    if (L[i].compareTo(R[j]) < 0) {
                        A[k] = L[i++];
                    }
                    else {
                        A[k] = R[j++];
                        inversions += n1 - i;
                    }

                }

            } catch (ArrayIndexOutOfBoundsException e) {

                if (i > n1 || i == n1) {
                    System.arraycopy(R, j, A, k, r - k + 1);
                }
                else {
                    System.arraycopy(L, i, A, k, r - k + 1);
                }

            }

            return inversions;
        }

        private int countInversions(int p, int r) {

            int inversions = 0;
            if (p < r) {

                int q = (p + r) / 2;
                inversions += countInversions(p, q);
                inversions += countInversions(q + 1, r);
                inversions += mergeInversions(p, q, r);

            }
            return inversions;

        }

    }

}
