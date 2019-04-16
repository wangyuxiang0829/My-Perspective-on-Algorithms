package io.github.wangyuxiang0829.util.tuple;

/**
 * <p>Brief: A three-tuple that contains three other objects.
 * <p>Explanation: Packing three objects into a single object.
 * @param <A> the type of the first object
 * @param <B> the type of the second object
 * @param <C> the type of the third object
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

}
