package io.github.wangyuxiang0829.algorithms.chap11;

import io.github.wangyuxiang0829.algorithms.chap10.MyLinkedList;
import java.math.BigDecimal;
import java.util.Random;

/**
 * <p>Brief: Contains some hash functions {@code h} that map the universe {@code U}
 * of keys into the slots of a hash table T[0 ... m - 1], in other words, compute an
 * index into an array of slots or buckets, from which the desired value can be found.
 * <p>Explanation: {@code h : U -> {0, 1, ..., m - 1}}.
 * <p>Terminology: We say that an element with key k hashes to a slot {@code h(k)}, we
 * also say that {@code h(k)} is the hash value of key {@code k}.
 */
public class HashFunctions {
    public static final double A = (Math.sqrt(5) - 1) / 2;


    /**
     * <p>Brief: {@code h(k) = k mod m}.
     * <p>Explanation: When using the division method, usually avoid some certain
     * values of {@code m}, A prime not too close to an exact power of 2 is often
     * a good choice for {@code m}.
     * @param k the value of key
     * @param m the number of slots in the hash table
     * @return the hash value of key k
     */
    public static int divisionMethod(int k, int m) {
        return k % m;
    }


    /**
     * <p>Brief: {@code h(k) = floor(((k * A) mod 1) * m)}.
     * <p>Explanation: The multiplication method for creating hash functions operates in
     * two steps:
     * <blockquote>
     *     <p>First: We multiply the key {@code k} by a constant {@code A} in the range
     *     {@code 0 < A < 1} and extract the fractional part of {@code k * A}.
     *     <p>Then: We multiply this value by {@code m} and take the floor of the result.
     * </blockquote>
     * @param k the value of key
     * @param m the number of slots in the hash table
     * @return the hash value of key k
     */
    public static int multiplicationMethod(int k, int m) {
        return BigDecimal.valueOf(k * A).divideAndRemainder(BigDecimal.valueOf(1))[1].multiply(BigDecimal.valueOf(m)).intValue();
    }


    /**
     * <p>Brief: Choose a hash function at random independently from the keys.
     * <p>Explanation:
     * <blockquote>
     *     <p>First: Decompose any key {@code k} into {@code r + 1} digits:
     *     {@code K = < k0, k1, k2, ..., kr >} where 0 <= ki <= m - 1;
     *     <p>Second: Pick {@code a = < a0, a1, a2, ..., ar >} each {@code ai} is
     *     chosen randomly from {0, 1, ..., m - 1};
     *     <p>Third: Define {@code ha(k) = (a0 * k0 + a1 * k1 + ... + ar * kr) % m}
     *     <p>Finally: Randomly choosing a function in the collection {@code H} which
     *     {@code H = {ha(k)}}.
     * </blockquote>
     * @param k the value of key
     * @param m the number of slots in the hash table and should be a prime
     * @return the hash value of key k
     */
    public static int universalHashing(int k, int m, Random randomInt) {
        MyLinkedList<Integer> K = new MyLinkedList<>();
        do {
            K.insert(k % m);
            k = k / m;
        } while (k != 0);


        int[] a = new int[K.getLength()];
        for (int i = 0; i < a.length; i++)
            a[i] = randomInt.nextInt(m);


        int sum = 0, i = 0;
        for (int ki : K)
            sum += ki * a[i++];


        return sum % m;
    }

}
