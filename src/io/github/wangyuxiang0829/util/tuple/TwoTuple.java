package io.github.wangyuxiang0829.util.tuple;

/**
 * <p>Brief: A two-tuple that contains two other objects.
 * <p>Explanation: Packing two objects into a single object.
 * @param <A> the type of the first object
 * @param <B> the type of the second object
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

}
