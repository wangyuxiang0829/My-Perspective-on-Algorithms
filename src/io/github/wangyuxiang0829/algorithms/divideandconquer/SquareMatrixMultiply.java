package io.github.wangyuxiang0829.algorithms.divideandconquer;

import io.github.wangyuxiang0829.util.tuple.FourTuple;
import io.github.wangyuxiang0829.util.tuple.TwoTuple;

class SubMatrix {
    final double[][] parentMatrix;
    final TwoTuple<Integer, Integer> rowIndex;
    final TwoTuple<Integer, Integer> colIndex;

    SubMatrix(double[][] parentMatrix, TwoTuple<Integer, Integer> rowIndex, TwoTuple<Integer, Integer> colIndex) {
        this.parentMatrix = parentMatrix;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public String toString() {
        int rowStart = rowIndex.first;
        int rowEnd = rowIndex.second;
        int colStart = colIndex.first;
        int colEnd = colIndex.second;

        StringBuilder result = new StringBuilder();
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                result.append(parentMatrix[i][j]).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> partition() {
        int rowMid = (rowIndex.first + rowIndex.second) / 2;
        int colMid = (colIndex.first + colIndex.second) / 2;

        SubMatrix one = new SubMatrix(parentMatrix, new TwoTuple<>(rowIndex.first, rowMid),
                new TwoTuple<>(colIndex.first, colMid));
        SubMatrix two = new SubMatrix(parentMatrix, new TwoTuple<>(rowIndex.first, rowMid),
                new TwoTuple<>(colMid + 1, colIndex.second));
        SubMatrix three = new SubMatrix(parentMatrix, new TwoTuple<>(rowMid + 1, rowIndex.second),
                new TwoTuple<>(colIndex.first, colMid));
        SubMatrix four = new SubMatrix(parentMatrix, new TwoTuple<>(rowMid + 1, rowIndex.second),
                new TwoTuple<>(colMid + 1, colIndex.second));

        return new FourTuple<>(one, two, three, four);
    }

    int getOrder() {
        return rowIndex.second - rowIndex.first + 1;
    }

    SubMatrix add(SubMatrix another, SubMatrix result) {

        if (getOrder() != another.getOrder()) {
            throw new IllegalArgumentException("matrix addition requires the order of two matrices must be the same");
        }

        for (int i = result.rowIndex.first, m = 0; i <= result.rowIndex.second; i++, m++) {
            for (int j = result.colIndex.first, n = 0; j <= result.colIndex.second; j++, n++) {
                result.parentMatrix[i][j] = parentMatrix[rowIndex.first + m][colIndex.first + n] +
                        another.parentMatrix[another.rowIndex.first + m][another.colIndex.first + n];
            }
        }

        return result;
    }

    SubMatrix subtract(SubMatrix another, SubMatrix result) {

        if (getOrder() != another.getOrder()) {
            throw new IllegalArgumentException("matrix addition requires the order of two matrices must be the same");
        }

        for (int i = result.rowIndex.first, m = 0; i <= result.rowIndex.second; i++, m++) {
            for (int j = result.colIndex.first, n = 0; j <= result.colIndex.second; j++, n++) {
                result.parentMatrix[i][j] = parentMatrix[rowIndex.first + m][colIndex.first + n] -
                        another.parentMatrix[another.rowIndex.first + m][another.colIndex.first + n];
            }
        }

        return result;
    }

}

public class SquareMatrixMultiply {
    private SubMatrix first, second, result;

    private static boolean isLegal(double[][] A, double[][] B) {

        boolean aIsSquare = true;
        boolean bIsSquare = true;

        for (double[] row : A) {
            if (row.length != A.length) {
                aIsSquare = false;
                break;
            }
        }

        for (double[] row : B) {
            if (row.length != B.length) {
                bIsSquare = false;
                break;
            }
        }

        return (aIsSquare && bIsSquare && A.length == B.length);

    }

    public SquareMatrixMultiply(double[][] A, double[][] B) {
        if (!isLegal(A, B))
            throw new IllegalArgumentException("each matrix should be square and the order of two matrices should be the same");

        first = new SubMatrix(A, new TwoTuple<>(0, A.length - 1), new TwoTuple<>(0, A.length - 1));
        second = new SubMatrix(B, new TwoTuple<>(0, B.length - 1), new TwoTuple<>(0, B.length - 1));

    }

    public double[][] naiveMultiplication() {

        int n = first.getOrder();
        result = new SubMatrix(new double[n][n], new TwoTuple<>(0, n - 1), new TwoTuple<>(0, n - 1));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.parentMatrix[i][j] = 0;
                for (int k = 0; k < n; k++)
                    result.parentMatrix[i][j] += first.parentMatrix[i][k] * second.parentMatrix[k][j];
            }
        }

        return result.parentMatrix;

    }

    private static SubMatrix recursiveMultiplication(SubMatrix A, SubMatrix B) {
        int n = A.getOrder();
        SubMatrix C = new SubMatrix(new double[n][n], new TwoTuple<>(0, n - 1), new TwoTuple<>(0, n - 1));

        if (n == 1)
            C.parentMatrix[0][0] = A.parentMatrix[A.rowIndex.first][A.colIndex.first] * B.parentMatrix[B.rowIndex.first][B.colIndex.first];
        else {
            FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> subA = A.partition();
            FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> subB = B.partition();
            FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> subC = C.partition();

            recursiveMultiplication(subA.first, subB.first).add(recursiveMultiplication(subA.second, subB.third), subC.first);
            recursiveMultiplication(subA.first, subB.second).add(recursiveMultiplication(subA.second, subB.fourth), subC.second);
            recursiveMultiplication(subA.third, subB.first).add(recursiveMultiplication(subA.fourth, subB.third), subC.third);
            recursiveMultiplication(subA.third, subB.second).add(recursiveMultiplication(subA.fourth, subB.fourth), subC.fourth);
        }

        return C;
    }

    private static SubMatrix strassenMethod(SubMatrix A, SubMatrix B) {
        int n = A.getOrder();
        SubMatrix C = new SubMatrix(new double[n][n], new TwoTuple<>(0, n - 1), new TwoTuple<>(0, n - 1));

        if (n == 1)
            C.parentMatrix[0][0] = A.parentMatrix[A.rowIndex.first][A.colIndex.first] * B.parentMatrix[B.rowIndex.first][B.colIndex.first];
        else {
            FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> subA = A.partition();
            FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> subB = B.partition();
            FourTuple<SubMatrix, SubMatrix, SubMatrix, SubMatrix> subC = C.partition();

            SubMatrix[] S = new SubMatrix[10];
            for (int i = 0; i < S.length; i++)
                S[i] = new SubMatrix(new double[n / 2][n / 2], new TwoTuple<>(0, n / 2 - 1), new TwoTuple<>(0, n / 2 - 1));

            S[0] = subB.second.subtract(subB.fourth, S[0]);
            S[1] = subA.first.add(subA.second, S[1]);
            S[2] = subA.third.add(subA.fourth, S[2]);
            S[3] = subB.third.subtract(subB.first, S[3]);
            S[4] = subA.first.add(subA.fourth, S[4]);
            S[5] = subB.first.add(subB.fourth, S[5]);
            S[6] = subA.second.subtract(subA.fourth, S[6]);
            S[7] = subB.third.add(subB.fourth, S[7]);
            S[8] = subA.first.subtract(subA.third, S[8]);
            S[9] = subB.first.add(subB.second, S[9]);

            SubMatrix P1 = strassenMethod(subA.first, S[0]);
            SubMatrix P2 = strassenMethod(S[1], subB.fourth);
            SubMatrix P3 = strassenMethod(S[2], subB.first);
            SubMatrix P4 = strassenMethod(subA.fourth, S[3]);
            SubMatrix P5 = strassenMethod(S[4], S[5]);
            SubMatrix P6 = strassenMethod(S[6], S[7]);
            SubMatrix P7 = strassenMethod(S[8], S[9]);

            P5.add(P4, subC.first).subtract(P2, subC.first).add(P6, subC.first);
            P1.add(P2, subC.second);
            P3.add(P4, subC.third);
            P5.add(P1, subC.fourth).subtract(P3, subC.fourth).subtract(P7, subC.fourth);
        }

        return C;
    }

    public double[][] recursiveMultiplication() {
        result = recursiveMultiplication(first, second);
        return result.parentMatrix;
    }

    public double[][] strassenMethod() {
        result = strassenMethod(first, second);
        return result.parentMatrix;
    }

    public String toString() {
        if (result == null)
            return "The result has not been computed!";
        else
            return first.toString() +
                    "---------------------\n" +
                    second.toString() +
                    "---------------------\n" +
                    result.toString();
    }





    /*
    public static void main(String[] args) {

        double[][] matrix1 = {{1, 1}, {1, 2}};
        double[][] matrix2 = {{1, 1}, {1, 1}};
        SquareMatrixMultiply matrixMultiply = new SquareMatrixMultiply(matrix1, matrix2);

        double[][] result1 = matrixMultiply.strassenMethod();
        double[][] result2 = matrixMultiply.naiveMultiplication();
        double[][] result3 = matrixMultiply.recursiveMultiplication();

        for (double[] i : result1) {
            for (double j : i)
                System.out.print(j + " ");
            System.out.println();
        }

        System.out.println();

        for (double[] i : result2) {
            for (double j : i)
                System.out.print(j + " ");
            System.out.println();
        }

        System.out.println();

        for (double[] i : result3) {
            for (double j : i)
                System.out.print(j + " ");
            System.out.println();
        }

    }
    */

}
