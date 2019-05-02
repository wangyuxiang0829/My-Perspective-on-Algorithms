package io.github.wangyuxiang0829.algorithms.chap06;

public abstract class Heap<T extends Comparable<T>> {
    protected final T[] A;

    protected int heapSize;


    protected Heap(T[] A) {
        this.A = A;
        heapSize = 0;
    }




    /**
     * <p>Brief: Exchange the element A[i] with A[j]
     * @param i the first index of A
     * @param j the second index of A
     */
    protected void exchange(int i, int j) {
        T tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }




    /**
     * <p>Brief: Get the index of parent node
     * @param i the index of an element in the array(heap)
     * @return the index of parent node
     */
    protected int parent(int i) {
        if (i == 0)
            return -1;
        else
            return i >> 1;
    }




    /**
     * <p>Brief: Get the index of left child node
     * @param i the index of an element in the array(heap)
     * @return the index of left child node
     */
    protected int left(int i) {
        return i << 1;
    }




    /**
     * <p>Brief: Get the index of right child node
     * @param i the index of an element in the array(heap)
     * @return the index of right child node
     */
    protected int right(int i) {
        return (i << 1) + 1;
    }




    /**
     * <p>Brief: Judging whether an element exists in the heap.
     * @param i the index of the element
     * @return true if the index is legal which means the element exists
     */
    protected boolean exist(int i) {
        return (i < heapSize && i >= 0);
    }




    /**
     * <p>Brief: The key to maintaining the heap property.
     * <p>Explanation: Assumes that the binary trees rooted at LEFT(i) and
     * RIGHT(i) are heaps, and let the value at A[i] "float down" in the max
     * heap so that the subtree rooted at index i obeys the heap property.
     * <p>Running Time: T(n) = O(lg(n)).
     * @param i the index of an element in the array(heap)
     */
    public abstract void heapify(int i);




    /**
     * <p>Brief: Produce a heap from an unordered input array.
     * <p>Explanation:
     * <blockquote>
     *     <p>Use procedure heapify in a bottom-up manner to convert
     *     an array A[1 ... n] into a heap.
     *     <p>Because all leaves of the tree can be seen as a heap with only one
     *     element, so we call method heapify on each of the remaining nodes of
     *     the tree.
     *     <p>At last, all nodes in the tree obeys the heap property, so this tree
     *     is a heap.
     * </blockquote>
     * <p>Running Time: T(n) = O(n).
     */
    public abstract void buildHeap();

}
