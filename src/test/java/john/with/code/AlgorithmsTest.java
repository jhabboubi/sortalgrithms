package john.with.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmsTest {
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
    @Timeout(1)
    void quicksort() {
        Arrays.sort(arrCopy);
        Algorithms.quicksort(arr);
        assertArrayEquals(arrCopy, arr);
    }

    @Test
    @Timeout(1)
    void bubbleSort() {
        Arrays.sort(arrCopy);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, Algorithms.bubbleSort(new int[]{80, 70, 10, 30, 50, 20, 90, 40, 60}));
        assertArrayEquals(arrCopy, Algorithms.bubbleSort(arr));

    }

    @Test
    void swap() {
        Object[] arr = new Object[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        Algorithms.swap(arr, 0, arr.length - 1);
        assertArrayEquals(new Object[]{90, 20, 30, 40, 50, 60, 70, 80, 10}, arr);
    }

    @Test
    void factorial() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(6);
        expected.add(24);
        expected.add(120);
        expected.add(720);
        expected.add(5040);
        expected.add(40320);
        expected.add(362880);
        expected.add(3628800);

        assertArrayEquals(expected.toArray(), Algorithms.factorialList(10).toArray());
    }

    @Test
    void gcd() {
        assertEquals(15,Algorithms.gcd(45,15));
        assertEquals(5,Algorithms.gcd(15,5));
        assertEquals(5,Algorithms.gcd(10,5));
        assertEquals(32,Algorithms.gcd(128,96));
        assertEquals(3,Algorithms.gcd(3768,1701));

    }
}