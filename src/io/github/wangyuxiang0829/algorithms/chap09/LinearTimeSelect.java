package io.github.wangyuxiang0829.algorithms.chap09;

import java.util.Iterator;

/**
 * <p>Brief: Selection in worst-case linear time.
 * <p>Explanation: We guarantee a good split upon partitioning the array.
 * <p>Algorithm:
 * <blockquote>
 * <p>1. Divide the n elements of the input array into [n / 5] groups of 5 elements each
 * and the last group is made up of the remaining n % 5 elements.
 * <p>2. Find the median of each of the [n / 5] groups by using any method you want because
 * there are only 5 elements in each group, one method is sorting each group and picking
 * the 3th element in the sorted array and that is the median.
 * <p>3. Use {@code LinearTimeSelect} recursively find the median {@code x} of the [n / 5]
 * medians found in step 2.
 * <p>4. Partition the input array around the median-of-medians {@code x}, compute the value
 * of {@code k} that represent x be the kth smallest element.
 * <p>5.
 * <blockquote>
 * <p>if i == k, then return x.
 * <p>if i < k, recursively find the ith smallest element on the low side.
 * <p>if i > k, recursively find the (i - k)th smallest element on the high side.
 * </blockquote>
 * </blockquote>
 * <p>Running Time:
 * <blockquote>
 * <p>Analysis:
 * <blockquote>
 * <p>Step1: T(1) = O(1)
 * <p>Step2: T(2) = O(n)
 * <p>Step3: T(3) = T([n / 5])
 * <p>Step4: T(4) = O(n)
 * <p>Step5: T(5) = T(7n / 10 + 6)
 * </blockquote>
 * <p>Worst case: T(n) = O(n)
 * </blockquote>
 *
 * @param <T> the type of element in the set A
 */
public class LinearTimeSelect<T extends Comparable<T>> extends SelectionProblem<T> {

    public LinearTimeSelect(T[] A, int i) {
        super(A, i);
    }


    /**
     * <p>Brief: Complete Step4.
     *
     * @param A           the abstract array we will partition
     * @param qFalseIndex the false index of {@code x} in the abstract array A
     * @return the false index of the pivot {@code x} after partition
     */
    private int partitionInPlace(AbstractArray A, int qFalseIndex) {
        A.exchange(0, qFalseIndex);

        T x = A.get(0);
        int i = 0;

        for (int j = 1; j < A.length; j++) {
            if (A.get(j).compareTo(x) <= 0) {
                i++;
                A.exchange(i, j);
            }
        }

        A.exchange(0, i);
        return i;
    }

    /**
     * <p>Brief: Complete Step2.
     *
     * @param A thr sorted abstract array
     */
    private void sort(AbstractArray A) {
        for (int j = 1; j < A.length; j++) {
            T key = A.get(j);
            int i = j - 1;

            while (i >= 0 && A.get(i).compareTo(key) > 0) {
                A.set(i + 1, A.get(i));
                i--;
            }
            A.set(i + 1, key);
        }
    }

    /**
     * <p>Brief: Complete Step1, Step2, Step3.
     *
     * @param A the abstract array where we will find the better pivot from
     * @return false index of the better pivot in the abstract array A
     */
    private int findBetterPivot(AbstractArray A) {
        int n = A.length;

        if (n < 5)
            return 0;

        int i = 0;
        for (; i < n / 5; i++) {
            sort(new AbstractArray(A.trueIndex(5 * i), A.trueIndex(5 * i + 4), A.getK()));
        }

        AbstractArray groupMedians = new AbstractArray(A.trueIndex(2), A.trueIndex(5 * i - 3), 5 * A.getK());
        int medianFalseIndex = (groupMedians.length + 1) / 2 - 1;
        linearTimeSelect(groupMedians, medianFalseIndex + 1);

        return 2 + 5 * medianFalseIndex;
    }

    /**
     * <p>Brief: Selecting the ith order statistic in the abstract array A
     *
     * @param A the abstract array where we will select the ith order statistic
     * @param i a number that identify the ith order statistic
     * @return the ith order statistic
     */
    private T linearTimeSelect(AbstractArray A, int i) {
        if (A.length == 1)
            return A.get(0);

        int q = partitionInPlace(A, findBetterPivot(A));
        int rank = q + 1;

        if (i == rank)
            return A.get(q);
        else if (i < rank)
            return linearTimeSelect(new AbstractArray(A.trueIndex(0), A.trueIndex(q - 1), A.getK()), i);
        else
            return linearTimeSelect(new AbstractArray(A.trueIndex(q + 1), A.trueIndex(A.length - 1), A.getK()), i - rank);
    }

    @Override
    public T getOrderStatistic() {
        return linearTimeSelect(new AbstractArray(0, A.length - 1, 1), i);
    }

    public class AbstractArray implements Iterable<T> {
        public final int length;
        private final int p, r, k;


        public AbstractArray(int pTrueIndex, int rTrueIndex, int kTrueIndex) {
            if ((rTrueIndex - pTrueIndex) % kTrueIndex != 0)
                throw new RuntimeException("Can't construct this object, illegal argument");

            this.p = pTrueIndex;
            this.r = rTrueIndex;
            this.k = kTrueIndex;
            length = (rTrueIndex - pTrueIndex) / kTrueIndex + 1;
        }


        public int getK() {
            return k;
        }


        private boolean isInArray(int trueIndex) {
            return trueIndex >= p && trueIndex <= r && (trueIndex - p) % k == 0;
        }


        public int falseIndex(int trueIndex) {
            if (isInArray(trueIndex)) {
                return (trueIndex - p) / k;
            } else {
                throw new IllegalArgumentException("index is not in this abstract array");
            }
        }


        public int trueIndex(int falseIndex) {
            if (falseIndex > length || falseIndex < 0)
                throw new ArrayIndexOutOfBoundsException();
            return p + falseIndex * k;
        }


        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private int currentIndex;

                {
                    currentIndex = p - k;
                }

                @Override
                public boolean hasNext() {
                    return currentIndex < r;
                }

                @Override
                public T next() {
                    currentIndex = currentIndex + k;
                    return A[currentIndex];
                }
            };
        }


        public T get(int falseIndex) {
            return A[trueIndex(falseIndex)];
        }


        public void set(int falseIndex, T x) {
            A[trueIndex(falseIndex)] = x;
        }


        public void exchange(int falseIndex1, int falseIndex2) {
            if (falseIndex1 == falseIndex2)
                return;
            T tmp = A[trueIndex(falseIndex1)];
            A[trueIndex(falseIndex1)] = A[trueIndex(falseIndex2)];
            A[trueIndex(falseIndex2)] = tmp;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[ ");
            for (T x : this)
                stringBuilder.append(x).append(" ");
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /*
    public static void main(String[] args) {
        System.out.println(new LinearTimeSelect<Integer>(new Integer[]{0, 2, 1, 4, 3, 5, 6, 10, 8, 9, 7}, 4).getOrderStatistic());
    }*/

    /*
    public static void main(String[] args) {
        LinearTimeSelect<Integer> select = new LinearTimeSelect<>(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 2);
        System.out.println(select.new AbstractArray(0, 6, 2));
    }*/

}
