package john.with.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortAlgorithmsTest {
    Random r;
    int[] arr;
    int[] arrCopy;

    @BeforeEach
    void setUp() {
        r = new Random();
        arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(Integer.MAX_VALUE);
        }
        arrCopy = Arrays.copyOf(arr, arr.length);

    }

    @Test
    @Timeout(3)
    void quicksort() {
        Arrays.sort(arrCopy);
        SortAlgorithms.quicksort(arr);
        assertArrayEquals(arrCopy, arr);
    }

    @Test
    @Timeout(3)
    void bubbleSort() {
        Arrays.sort(arrCopy);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, SortAlgorithms.bubbleSort(new int[]{80, 70, 10, 30, 50, 20, 90, 40, 60}));
        assertArrayEquals(arrCopy, SortAlgorithms.bubbleSort(arr));

    }

    @Test
    void swap() {
        Object[] arr = new Object[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        SortAlgorithms.swap(arr, 0, arr.length - 1);
        assertArrayEquals(new Object[]{90, 20, 30, 40, 50, 60, 70, 80, 10}, arr);
    }


}