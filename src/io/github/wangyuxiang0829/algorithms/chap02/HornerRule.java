package io.github.wangyuxiang0829.algorithms.chap02;

/**
 * <p>Brief: A polynomial evaluation method named after
 * William George Horner.
 * <p>Explanation: This method allows evaluation of a
 * polynomial of degree n with only n multiplications
 * and n additions. This is optimal, since there are
 * polynomials of degree n that cannot be evaluated
 * with fewer arithmetic operations.
 * <p>Runtime: Theta(n)
 * <p>Input: A polynomial of degree n (i.e.
 * a0 + a1 * x + ... + an * x ^ n) that the coefficients
 * is represented by an array A[a0, a1, ..., an] and the
 * value of the variable x.
 * <p>Output: The value of the polynomial.
 */
public class HornerRule {

    /**
     * Brief: A naive method for evaluating a polynomial.
     * Explanation: Compute each term of polynomial and sum.
     * Runtime: Theta(n ^ 2).
     * @param A an array contains the coefficients a0, a1, ..., an
     * @param x a value of variable x
     * @return the value of the polynomial
     */
    @Deprecated
    public static double naivePolynomialEvaluation(double[] A, double x) {
        double y = 0;
        for (int k = 0; k < A.length; k++) {
            double temp = 1;
            for (int i = 0; i < k; i++) {
                temp *= x;
            }
            y += A[k] * temp;
        }
        return y;
    }

    public static double hornerRule(double[] A, double x) {
        double y = 0;
        for (int i = A.length - 1; i > -1; i--)
            y = A[i] + x * y;
        return y;
    }

}
