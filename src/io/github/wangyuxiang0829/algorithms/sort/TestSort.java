package io.github.wangyuxiang0829.algorithms.sort;

import io.github.wangyuxiang0829.util.*;
import io.github.wangyuxiang0829.algorithms.chap02.BubbleSort;
import io.github.wangyuxiang0829.algorithms.divideandconquer.*;
import io.github.wangyuxiang0829.algorithms.chap02.SelectionSort;


import java.time.Duration;
import java.time.Instant;


public class TestSort {


    private In inFile = new In(".\\dataset\\1E5numbers1.txt");


    public static void main(String[] args) {

        TestSort test = new TestSort();

        Sort<Integer> sort = new QuickSort<>(test.inFile.readAllIntegers());

        Instant start = Instant.now();

        Integer[] integers = sort.sort();

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);

        System.out.println(duration.toMillis());
        System.out.println(integers.length);

        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + " ");
            if ((i + 1) % 10 == 0)
                System.out.println();
        }
    }
}
