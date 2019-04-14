package io.github.wangyuxiang0829.algorithms.divideandconquer;

import io.github.wangyuxiang0829.util.tuple.*;

public interface MaximumSubarray<T extends Number> {
    ThreeTuple<Integer, Integer, Double> findMaximumSubarray(T[] A);
}
