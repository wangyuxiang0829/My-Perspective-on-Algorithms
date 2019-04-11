package io.github.wangyuxiang0829.algorithms.divideandconquer;

import java.util.Arrays;

public class FibonacciNumber {
    @Deprecated
    public static int recursiveAlgorithm(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return recursiveAlgorithm(n - 1) + recursiveAlgorithm(n - 2);
    }

    public static int bottomUpAlgorithm(int n) {
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

    private static class TwoByTwoMatrix {
        private int[][] twoByTwoMatrix = new int[2][2];

        private TwoByTwoMatrix(int a00, int a01, int a10, int a11) {
            twoByTwoMatrix[0][0] = a00;
            twoByTwoMatrix[0][1] = a01;
            twoByTwoMatrix[1][0] = a10;
            twoByTwoMatrix[1][1] = a11;
        }

        private TwoByTwoMatrix() {
            twoByTwoMatrix[0][0] = 1;
            twoByTwoMatrix[0][1] = 1;
            twoByTwoMatrix[1][0] = 1;
            twoByTwoMatrix[1][1] = 0;
        }

        private TwoByTwoMatrix matrixMultiplication(TwoByTwoMatrix matrix) {
            TwoByTwoMatrix newMatrix = new TwoByTwoMatrix(0, 0, 0, 0);
            newMatrix.twoByTwoMatrix[0][0] = twoByTwoMatrix[0][0] * matrix.twoByTwoMatrix[0][0] + twoByTwoMatrix[0][1] * matrix.twoByTwoMatrix[1][0];
            newMatrix.twoByTwoMatrix[0][1] = twoByTwoMatrix[0][0] * matrix.twoByTwoMatrix[0][1] + twoByTwoMatrix[0][1] * matrix.twoByTwoMatrix[1][1];
            newMatrix.twoByTwoMatrix[1][0] = twoByTwoMatrix[1][0] * matrix.twoByTwoMatrix[0][0] + twoByTwoMatrix[1][1] * matrix.twoByTwoMatrix[0][1];
            newMatrix.twoByTwoMatrix[1][1] = twoByTwoMatrix[1][0] * matrix.twoByTwoMatrix[0][1] + twoByTwoMatrix[1][1] * matrix.twoByTwoMatrix[1][1];
            return newMatrix;
        }

        public String toString() {
            return Arrays.toString(twoByTwoMatrix);
        }

        private int[][] getTwoByTwoMatrix() {
            return twoByTwoMatrix;
        }

    }

    private static class PoweringAMatrix {
        private TwoByTwoMatrix x;

        private PoweringAMatrix(TwoByTwoMatrix x) {
            this.x = x;
        }

        private TwoByTwoMatrix recursiveSquaring(int n) {
            if (n < 1)
                throw new IllegalArgumentException("n must not less than 1");
            if (n == 1)
                return x;
            if (n % 2 == 0) {
                TwoByTwoMatrix tmp = recursiveSquaring(n / 2);
                return tmp.matrixMultiplication(tmp);
            }
            else {
                TwoByTwoMatrix tmp = recursiveSquaring((n - 1) / 2);
                return tmp.matrixMultiplication(tmp).matrixMultiplication(x);
            }
        }

    }

    public static int recursiveSquaring(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        if (n == 0)
            return 0;
        else {
            int[][] ints = new PoweringAMatrix(new TwoByTwoMatrix()).recursiveSquaring(n).getTwoByTwoMatrix();
            return ints[0][1];
        }
    }

}
