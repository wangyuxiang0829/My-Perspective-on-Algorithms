package testsort;

import io.github.wangyuxiang0829.algorithms.chap02.ComparisonSort;
import io.github.wangyuxiang0829.algorithms.chap07.QuickSort;
import io.github.wangyuxiang0829.algorithms.chap08.CountingSort;
import io.github.wangyuxiang0829.algorithms.chap08.LinearTimeSort;
import io.github.wangyuxiang0829.util.myio.In;

import java.time.Duration;
import java.time.Instant;


public class TestSort {


    private In inFile = new In(".\\testsort.dataset\\1E5numbers1.txt");


    public static void main(String[] args) {

        TestSort test = new TestSort();

        ComparisonSort<Integer> sort = new QuickSort<>(test.inFile.readAllIntegers());
        LinearTimeSort linearTimeSort = new CountingSort(new Integer[]{1, 3, 2}, 3);

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
