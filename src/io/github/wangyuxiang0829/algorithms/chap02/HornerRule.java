package io.github.wangyuxiang0829.algorithms.chap02;

/**
 * <p>Brief: A polynomial evaluation method named after William George Horner.
 * <p>Explanation: This method allows evaluation of a polynomial of degree n
 * with only n multiplications and n additions. This is optimal, since there
 * are polynomials of degree n that cannot be evaluated with fewer arithmetic
 * operations.
 * <p>Input: A polynomial of degree n (i.e. y = a0 + a1 * x + ... + an * x ^ n)
 * that the coefficients is represented by an array A[a0, a1, ..., an] and the
 * value of the variable x.
 * <p>Output: The value of the polynomial.
 * <p>Example: Input A = [1.2, 1.4, 3.4] and x = 4.0, so the output will be 61.2
 * <p>Runtime: T(n) = Theta(n)
 */
public class HornerRule {

    /**
     * <p>Brief: A naive method for evaluating a polynomial.
     * <p>Explanation: Simply compute each term of polynomial and sum.
     * <p>Runtime: Theta(n ^ 2).
     * @param A an array contains the coefficients a0, a1, ..., an
     * @param x the value of variable x
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
        for (int i = A.length - 1; i >= 0; i--)
            y = A[i] + x * y;
        return y;
    }

    /*
    public static void main(String[] args) {
        System.out.println(hornerRule(new double[]{1.2, 1.4, 3.4}, 4.0));
    }*/

}
