package io.github.wangyuxiang0829.algorithms.chap04;

import java.util.Arrays;

/**
 * <p>Brief: Compute the nth Fibonacci number in Fibonacci sequence.
 * <p>Explanation: Fibonacci numbers is defined by the following recurrence:
 * <blockquote>
 *     <p>F0 = 0,
 *     <p>F1 = 1,
 *     <p>Fn = Fn-1 + Fn-2 (n >= 2).
 *     <p>Example: The Fibonacci sequence is just like this:
 *     0, 1, 1, 2, 3, 5, 8, ...
 * </blockquote>
 * <p>Input: A non-negative integer n >= 0.
 * <p>Output: The nth Fibonacci number Fn.
 */
public class FibonacciNumber {

    /**
     * <p>Brief: The recursive version for computing the nth Fibonacci number.
     * <p>Algorithm: Divide and Conquer.
     * <blockquote>
     *     <p>Divide: Divide the problem of size n into two sub-problem whose
     *     size is (n - 1) and (n - 2).
     *     <p>Conquer: Recursively solve each sub-problem, and if the problem
     *     size n <= 1, we just solve it.
     *     <p>Combine: Combine the solutions of two sub-problem by adding them
     *     together and get the solution of the original problem.
     * </blockquote>
     * <p>Running Time: T(n) = Omega(Phi ^ n).
     * @param n the nth Fibonacci number to be computed
     * @return the nth Fibonacci number
     */
    @Deprecated
    public static int recursiveAlgorithm(final int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return recursiveAlgorithm(n - 1) + recursiveAlgorithm(n - 2);
    }

    /**
     * <p>Brief: The dynamic programming version for computing the nth Fibonacci number.
     * <p>Algorithm: Rather than saying it is dynamic programming, we can symbolically
     * say it is bottom-up algorithm. we just compute the number from 0 to n, just like
     * bottom-up.
     * <p>Running Time: Theta(n).
     * @param n the nth Fibonacci number to be computed
     * @return the nth Fibonacci number
     */
    public static int bottomUpAlgorithm(final int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int[] fibonacciSequence = new int[n + 1];
            fibonacciSequence[1] = 1;
            for (int i = 2; i <= n; i++)
                fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
            return fibonacciSequence[n];
        }
    }

    /**
     * <p>Brief: The recursive squaring version for computing the nth Fibonacci number.
     * <p>Theorem:
     * <blockquote>
     *     <p> [[F(n+1), F(n)  ],       =>       ([[1, 1], ) ^ n
     *     <p> [F(n)  , F(n-1)]]        =>       ( [1, 0]] )
     * </blockquote>
     * <p>Algorithm: The same as {@link PoweringANumber#recursiveSquaring(double, int)}, the
     * only difference is that one is powering a number and another is powering a two-by-two
     * parentMatrix, but they all cost constant time.
     * <p>Running Time: Theta(lg(n)).
     * @param n the nth Fibonacci number to be computed
     * @return the nth Fibonacci number
     */
    public static int recursiveSquaring(final int n) {

        class TwoByTwoMatrix {

            private int[][] matrix = new int[2][2];

            private TwoByTwoMatrix() {
                matrix[0][0] = 1;
                matrix[0][1] = 1;
                matrix[1][0] = 1;
                matrix[1][1] = 0;
            }

            private TwoByTwoMatrix multiplication(TwoByTwoMatrix another) {
                TwoByTwoMatrix answer = new TwoByTwoMatrix();
                answer.matrix[0][0] = this.matrix[0][0] * another.matrix[0][0] + this.matrix[0][1] * another.matrix[1][0];
                answer.matrix[0][1] = this.matrix[0][0] * another.matrix[0][1] + this.matrix[0][1] * another.matrix[1][1];
                answer.matrix[1][0] = this.matrix[1][0] * another.matrix[0][0] + this.matrix[1][1] * another.matrix[1][0];
                answer.matrix[1][1] = this.matrix[1][0] * another.matrix[0][1] + this.matrix[1][1] * another.matrix[1][1];
                return answer;
            }

            public String toString() {
                return "[" + Arrays.toString(matrix[0]) + ",\n " + Arrays.toString(matrix[1]) + "]";
            }

            private TwoByTwoMatrix powering(int x) {
                if (x < 1)
                    throw new IllegalArgumentException("the power of parentMatrix must not less than 1");
                else if (x == 1) {
                    System.out.println("power of 1:\n" + this);
                    return this;
                }
                else {
                    if (x % 2 == 0) {
                        TwoByTwoMatrix tmp = powering(x / 2);
                        TwoByTwoMatrix answer = tmp.multiplication(tmp);
                        System.out.println("power of " + x + ":\n" + answer);
                        return answer;
                    }
                    else {
                        TwoByTwoMatrix tmp = powering((x - 1) / 2);
                        TwoByTwoMatrix anotherTmp = tmp.multiplication(tmp);
                        System.out.println("power of " + (x - 1) + ":\n" + anotherTmp);
                        TwoByTwoMatrix answer = anotherTmp.multiplication(this);
                        System.out.println("power of " + x + ":\n" + answer);
                        return answer;
                    }
                }
            }

            private TwoByTwoMatrix powering() {
                return powering(n);
            }

            private int[][] getMatrix() {
                return matrix;
            }

        }




        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        else if (n == 0)
            return 0;
        else {
            int[][] ints = new TwoByTwoMatrix().powering().getMatrix();
            return ints[1][0];
        }

    }

}
