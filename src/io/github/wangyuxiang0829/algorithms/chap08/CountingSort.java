package io.github.wangyuxiang0829.algorithms.chap08;

/**
 * <p>Brief: This class implements the interface {@link LinearTimeSort LinearTimeSort}
 * which means can sort in linear time.
 * <p>Requirements: All the elements in the input sequence must be in the set
 * { 0, 1, 2, ..., k } which means every element must be non-negative integer and should
 * also be less than or equal to k.
 * <p>Explanation: Using array index as a tool for determining the relative order.
 * <p>Running time:
 * <blockquote>
 *     <p>T(n) = Theta(n + k)
 *     <p>If k = O(n), then T(n) = Theta(n)
 * </blockquote>
 */
public class CountingSort implements LinearTimeSort {
    private int k;
    private Integer[] A;
    private Integer[] B;
    private boolean isSorted = false;




    public CountingSort(Integer[] A, int k) {
        if (k < 0)
            throw new IllegalArgumentException("k must be greater than or equal to 0");
        this.k = k;
        this.A = A;
        B = new Integer[A.length];
    }




    @Override
    public Integer[] sort() {
        if (!isSorted) {
            isSorted = true;

            /*
            The array C is used for auxiliary storage, the index of C represent one element in the
            set { 0, 1, 2, ... k }
             */
            int[] C = new int[k + 1];

            /*
            After the first for loop, the element in C[j] indicates the number of j appear in array A
             */
            for (int j : A)
                C[j]++;

            /*
            After the second for loop, the element in C[j] indicated the number of elements that are less
            than or equal to j in array A
             */
            for (int i = 1; i <= k; i++)
                C[i] = C[i] + C[i - 1];

            /*
            For every element in the input array A, for example A[j], we view the array C to get the number
            of elements that are less than or equal to A[j], so the new position of element A[j] in the output
            array is (C[A[j]] - 1)
             */
            for (int j = A.length - 1; j >= 0; j--) {
                B[C[A[j]] - 1] = A[j];
                C[A[j]]--;
            }

        }

        return B;
    }

    /*
    public static void main(String[] args) {
        LinearTimeSort sort = new CountingSort(new Integer[]{0, 1, 3, 2, 5, 4}, 5);
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
