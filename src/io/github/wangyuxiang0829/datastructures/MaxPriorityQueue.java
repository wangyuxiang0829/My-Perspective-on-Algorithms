package io.github.wangyuxiang0829.datastructures;

public class MaxPriorityQueue extends MaxHeap<Double> {
    public MaxPriorityQueue(Double[] A) {
        super(A);
        buildHeap();
    }




    /**
     * @return the element of priority queue with the largest key
     */
    public Double maximum() {
        return A[0];
    }




    /**
     * <p>Brief: Removes the returns the element with largest key
     * @return the element of priority queue with the largest key
     * @throws HeapUnderflowException if the heap does not have any element
     */
    public Double extractMax() throws HeapUnderflowException {
        if (heapSize < 1)
            throw new HeapUnderflowException();

        Double max = A[0];
        exchange(0, heapSize - 1);
        heapSize--;
        heapify(0);

        return max;
    }




    /**
     * <p>Brief: Increase the value of an element x's key to a new value k
     * @param i the index of the element x
     * @param key the value of k
     */
    public void increaseKey(int i, double key) {
        if (key < A[i])
            throw new RuntimeException("new key is not greater than current key");
        A[i] = key;
        while (exist(parent(i)) && A[parent(i)] < A[i]) {
            exchange(i, parent(i));
            i = parent(i);
        }
    }




    /**
     * <p>Brief: Insert the element x into this priority queue
     * @param key the key value of the element x
     * @throws HeapOverflowException if the heap in full
     */
    public void insert(double key) throws HeapOverflowException {
        if (heapSize > A.length)
            throw new HeapOverflowException();
        heapSize++;
        A[heapSize - 1] = Double.NEGATIVE_INFINITY;
        increaseKey(heapSize - 1, key);
    }

    /*
    public static void main(String[] args) {
        MaxPriorityQueue m = new MaxPriorityQueue(new Double[]{1.5, 2.5, 3.5, 4.5});
        try {
            for (int i = 0; i < 10; i++)
                System.out.println(m.extractMax());
        } catch (HeapUnderflowException e) {
            System.err.println("the heap doesn't have more elements");
        }
    }*/

}
