package john.with.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void factorialList() {
        List<BigInteger> expected = new ArrayList<>();
        expected.add(BigInteger.valueOf(0));
        expected.add(BigInteger.valueOf(1));
        expected.add(BigInteger.valueOf(2));
        expected.add(BigInteger.valueOf(6));
        expected.add(BigInteger.valueOf(24));
        expected.add(BigInteger.valueOf(120));
        expected.add(BigInteger.valueOf(720));
        expected.add(BigInteger.valueOf(5040));
        expected.add(BigInteger.valueOf(40320));
        expected.add(BigInteger.valueOf(362880));
        expected.add(BigInteger.valueOf(3628800));

        assertArrayEquals(expected.toArray(), Algorithms.factorialList(10).toArray());

    }

    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,6","4,24","5,120","6,720","7,5040","8,40320","9,362880","10,3628800"})
    void factorial(int n,int expected) {
        assertEquals(expected,Algorithms.factorial(n));
    }

    @Test
    void factorialPositiveNumbersOnly() {
        assertThrows(IllegalArgumentException.class, () -> Algorithms.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> Algorithms.factorial(-10));

    }

    @Test
    void gcd() {
        //assertEquals(15,Algorithms.gcd(45,15));
        assertEquals(5,Algorithms.gcd(15,5));
        assertEquals(5,Algorithms.gcd(10,5));
        assertEquals(32,Algorithms.gcd(128,96));
        assertEquals(3,Algorithms.gcd(3768,1701));
        int gcdFortyFiveAndFifteen = Algorithms.gcd(45, 15);
        assertThat(gcdFortyFiveAndFifteen).isEqualTo(15);

    }
}