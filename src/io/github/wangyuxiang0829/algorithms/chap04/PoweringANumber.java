package io.github.wangyuxiang0829.algorithms.chap04;

/**
 * <p>Brief: Class PoweringANumber contains two static methods which
 * can compute a number's power.
 * <p>Input: A number x and an integer n >= 0.
 * <p>Output: The value of x ^ n.
 * <p>Example: Input x = 1.2, n = 5 and the Output will be 2.48832.
 */
public class PoweringANumber {
    /**
     * <p>Algorithm: Simply multiply x by n times.
     * <p>Running Time: Theta(n).
     * @param x a number of double type
     * @param n an integer number which must be non-negative
     * @return the value of x ^ n
     */
    @Deprecated
    public static double naiveAlgorithm(double x, int n) {

        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        if (n == 0)
            return 1;
        for (int i = 1; i < n; i++)
            x *= x;
        return x;

    }

    /**
     * <p>Algorithm: Divide and Conquer:
     * <blockquote>
     *     <p>Divide: We want to get the value of x ^ n, we can
     *     divide it into two sub-problems: x ^ (n / 2) and
     *     x ^ (n / 2), and because they are the same, so there
     *     is only one sub-problem which is the same as the
     *     original problem but only have problem size n / 2.
     *     <p>Conquer: We recursively solve the sub-problem which
     *     is compute the value of x ^ (n / 2).
     *     <p>Combine: We combine the solutions of sub-problem by
     *     multiply x ^ (n / 2) * x ^ (n / 2) to get the solution
     *     of the original problem x ^ n.
     * </blockquote>
     * <p>Running Time: T(n) = T(n / 2) + Theta(1) = Theta( lg(n) ).
     * @param x a number of double type
     * @param n an integer number which must be non-negative
     * @return the value of x ^ n
     */
    public static double recursiveSquaring(double x, int n) {

        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        if (n == 0)
            return 1;
        if (n % 2 == 0) {
            double tmp = recursiveSquaring(x, n / 2);
            return tmp * tmp;
        }
        else {
            double tmp = recursiveSquaring(x, (n - 1) / 2);
            return x * tmp * tmp;
        }
    }

}
