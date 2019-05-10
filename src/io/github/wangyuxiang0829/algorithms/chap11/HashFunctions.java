package io.github.wangyuxiang0829.algorithms.chap11;

import java.math.BigDecimal;

/**
 * <p>Brief: A hash function {@code h} maps the universe {@code U} of keys into the
 * slots of a hash table T[0 ... m - 1].
 * <p>Explanation: {@code h : U -> {0, 1, ..., m - 1}}.
 * <p>Terminology: We say that an element with key k hashes to slot {@code h(k)}, we
 * also say that {@code h(k)} is the hash value of key {@code k}.
 */
public class HashFunctions {
    public static final double A  = (Math.sqrt(5) - 1) / 2;
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
}
