package io.github.wangyuxiang0829.algorithms.chap02;

/**
 * <p>2.1-4
 * <p>Input: An array of booleans A = [a1, a2, ..., an] and an
 * array of booleans B = [b1, b2, ..., bn], each representing an
 * integer stored in binary format (each digit is a number, either
 * 0 or 1, most-significant digit first) and each of length n.
 * <p>Output: An array C = [c1, c2, ..., cn+1] such that C = A + B
 * where A, B and C are the integers, represented by A, B and C.
 * <p>Example: A = [1, 1, 1, 1] and B = [1, 1, 0, 0] so C will be
 * [1, 1, 0, 1, 1].
 * <p>Loop invariant: The variable 'carry'. At the start of each for
 * loop, the variable 'carry' always represent the carry from the
 * original digit.
 */
public class AddTwoBinary {

    @Deprecated
    public static int[] badAddTwoBinary(int[] A, int[] B) {
        int[] C = new int[A.length + 1];
        int[] temp = new int[A.length + 1];
        for (int i = A.length - 1; i > -1; i--) {
            int j = 0;
            if (A[i] == 1)
                j++;
            if (B[i] == 1)
                j++;
            if (temp[i + 1] == 1)
                j++;
            if (j == 0) {
                C[i + 1] = 0;
                continue;
            }
            if (j == 1) {
                C[i + 1] = 1;
                continue;
            }
            if (j == 2) {
                C[i + 1] = 0;
                temp[i] = 1;
                continue;
            }
            if (j == 3) {
                C[i + 1] = 1;
                temp[i] = 1;
            }
        }
        C[0] = temp[0];
        return C;
    }

    public static int[] addTwoBinary(int[] A, int[] B) {

        int[] C = new int[A.length + 1];
        int carry = 0;
        for (int i = A.length - 1; i > -1; i--) {
            C[i + 1] = (A[i] + B[i] + carry) % 2;
            carry = (A[i] + B[i] + carry) / 2;
        }
        C[0] = carry;

        return C;
    }

}
