package io.github.wangyuxiang0829.algorithms.chap07;

/**
 * <p>7-5
 * <p>Brief: Improve the {@link RandomizedQuickSort RandomizedQuickSort} by partition
 * around a pivot that is chosen more carefully than just picking a random element
 * from the subarray.
 * <p>Explanation: Choose the pivot as the median (middle element) of a set of 3 elements
 * randomly selected from the subarray.
 * <p>Running Time:
 * <blockquote>
 *     <p>Expected running time: E[T(n)] = Theta(nlg(n)).
 *     <p>Worst case running time: T(n) = Theta(n ^ 2).
 * </blockquote>
 * @param <T> the type of the elements to be sorted
 */
public class ImprovedRandomizedQuickSort<T extends Comparable<T>> extends RandomizedQuickSort<T> {

    public ImprovedRandomizedQuickSort(T[] A) {
        super(A);
    }




    private int medianOfThree(int p, int r) {
        int first = random(p, r);
        int second = random(p, r);
        int third = random(p, r);

        if (A[first].compareTo(A[second]) < 0) {
            if (A[third].compareTo(A[second]) > 0) {
                return second;
            }
            else {
                if (A[third].compareTo(A[first]) > 0) {
                    return third;
                }
                else {
                    return first;
                }
            }
        }
        else {
            if (A[third].compareTo(A[second]) < 0) {
                return second;
            }
            else {
                if (A[third].compareTo(A[first]) < 0) {
                    return third;
                }
                else {
                    return first;
                }
            }
        }
    }




    private int medianOfThreePartition(int p, int r) {
        exchange(p, medianOfThree(p, r));

        return partition(p, r);
    }




    private void improvedRandomizedQuickSort(int p, int r) {
        if (p < r) {
            int q = medianOfThreePartition(p, r);
            improvedRandomizedQuickSort(p, q - 1);
            improvedRandomizedQuickSort(q + 1, r);
        }
    }




    @Override
    public T[] sort() {
        improvedRandomizedQuickSort(0, A.length - 1);
        return A;
    }




    /*
    public static void main(String[] args) {
        ComparisonSort<Integer> sort = new ImprovedRandomizedQuickSort<>(new Integer[]{1, 3, 2, 5, 4, 7, 9, 8, 6});
        System.out.println(java.util.Arrays.toString(sort.sort()));
    }*/

}
