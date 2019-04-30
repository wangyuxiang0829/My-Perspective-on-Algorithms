package io.github.wangyuxiang0829.algorithms.chap09;

public class LinearTimeSelect<T extends Comparable<T>> extends SelectionProblem<T> {
    public LinearTimeSelect(T[] A, int i) {
        super(A, i);
    }

    private void exchange(int i, int j) {
        T tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private int partitionInPlace(int p, int r, int q, int k) {
        exchange(p, q);

        T x = A[p];
        int i = p;

        for (int j = p + k; j <= r; j = j + k) {
            if (A[j].compareTo(x) <= 0) {
                i = i + k;
                exchange(i, j);
            }
        }

        exchange(p, i);
        return i;
    }

    private void sort(int p, int r, int k) {

        for (int j = p + k; j <= r; j = j + k) {
            T key = A[j];
            int i = j - k;

            while (i >= p && A[i].compareTo(key) > 0) {
                A[i + k] = A[i];
                i = i - k;
            }
            A[i + k] = key;
        }

    }

    private int findBetterPivot(int p, int r, int k) {
        int n = (r - p) / k + 1;

        if (n < 5)
            return p;

        int i = 0;
        for (; i < n / 5; i++) {
            sort(p + i * 5 * k, p + i * 5 * k + 4 * k, k);
        }

        linearTimeSelect(p + 2 * k, p + i * 5 * k - 3 * k, (i + 1) / 2, 5 * k);
        int m = ((i + 1) / 2) - 1;
        return p + 2 * k + m * 5 * k;
    }

    private T linearTimeSelect(int p, int r, int i, int k) {
        if (p == r)
            return A[p];

        int q = partitionInPlace(p, r, findBetterPivot(p, r, k), k);
        int rank = (q - p) / k + 1;

        if (i == rank)
            return A[q];
        else if (i < rank)
            return linearTimeSelect(p, q - k, i, k);
        else
            return linearTimeSelect(q + k, r, i - rank, k);
    }

    @Override
    public T getOrderStatistic() {
        return linearTimeSelect(0, A.length - 1, i, 1);
    }

    /*
    public static void main(String[] args) {
        System.out.println(new LinearTimeSelect<Integer>(new Integer[]{0, 2, 1, 4, 3, 5, 6, 10, 8, 9, 7}, 4).getOrderStatistic());
    }*/

}
