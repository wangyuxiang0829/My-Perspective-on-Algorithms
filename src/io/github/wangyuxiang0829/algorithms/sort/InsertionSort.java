package io.github.wangyuxiang0829.algorithms.sort;

/**
 * <p>Brief: InsertionSort implements the interface {@link
 * io.github.wangyuxiang0829.algorithms.sort.Sort Sort} and
 * can sort an array of any {@link java.lang.Comparable
 *  Comparable} type T.
 * <p>Input: A sequence of n numbers A = [a1, a2, ..., an].
 * <p>Output: A permutation(reordering) A' = [a1', a2', ..., an']
 * of the input sequence such that a1' <= a2' <= ... <= an'.
 * <p>Example: Input a sequence [1, 3, 2, 5, 4, 7, 9, 8], and the
 * output will be [1, 2, 3, 4, 5, 7, 8, 9].
 * <p>Algorithm: Insertion sort just like we sort a hand of playing
 * cards, we start with an empty left hand and the cards face down
 * on the table, we then remove one card at a time from the table
 * and insert it into the correct position in the left hand. To find
 * the correct position for a card, we compare it with each of the
 * cards already in the hand, from right to the left. At all times,
 * the cards held on the left hand are sorted.
 * <p>Loop invariant: At the start of each for loop, the subarray
 * A[1, ..., j - 1] consists of the elements originally in
 * A[1, ..., j - 1], but in sorted order.
 * <p>Running time: Theta(n ^ 2) for the worst case, and Theta(n)
 * for the best case.
 * @see io.github.wangyuxiang0829.algorithms.sort.Sort
 * @see io.github.wangyuxiang0829.algorithms.sort.MergeSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.BubbleSort
 * @see io.github.wangyuxiang0829.algorithms.chap02.SelectionSort
 * @param <T> the type of the elements to be sorted
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    private T[] A;
    private boolean isSorted = false;
    private boolean useRecursion = false;




    /**
     * <p>Brief: Constructor.
     * <p>Explanation: Construct the instance of class InsertionSort.
     * @param A an array of type T
     */
    public InsertionSort(T[] A) {
        this.A = A;
    }


    /**
     * Brief: Set the flag useRecursion true, so the sort
     * method will sort the array recursively.
     * @return this object itself
     */
    public InsertionSort<T> setUseRecursion() {
        useRecursion = true;
        return this;
    }




    /**
     * <p>Brief: The recursive version of InsertionSort.
     * <p>Explanation: To sort A[a1, a2, ..., an], we first
     * sort the subarray A[a1, a2, ..., an-1] recursively,
     * and then insert A[n] to the sorted array A[1... n - 1].
     * <p>Runtime: Theta(n ^ 2) for the worst time.
     * @param n the last index of the array to be sorted
     */
    private void recursiveInsertionSort(int n) {

        if (n > 0) {
            recursiveInsertionSort(n - 1);
            int i = n - 1;
            T key = A[n];
            while (i > -1 && A[i].compareTo(A[n]) > 0) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }

    }




    /**
     * <p>Brief: The iterative version of InsertionSort.
     * <p>Explanation: The outer for loop scan the array
     * from the second element to the last element, each
     * iteration we pull out the value of the element which
     * we call a 'key', and in the while loop, we keep
     * copying up to the right position until we find the
     * place where key goes, and then insert it in that place.
     * <p>Runtime: Theta(n ^ 2) for the worst time.
     */
    private void iterativeInsertionSort() {

        for (int j = 1; j < A.length; j++) {
            T key = A[j];
            int i = j - 1;
            while (i > -1 && A[i].compareTo(key) > 0) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }

    }




    /**
     * <p>Brief: Implement the abstract method in the interface Sort.
     * @see io.github.wangyuxiang0829.algorithms.sort.Sort
     * @return the sorted array
     */
    public T[] sort() {

        if (!isSorted) {
            isSorted = true;

            if (useRecursion)
                recursiveInsertionSort(A.length - 1);
            else
                iterativeInsertionSort();

        }

        return A;
    }

}
