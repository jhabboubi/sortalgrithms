package john.with.code;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmsTest {

    @Test
    void quicksort() {
        Random r = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(100000);
        }
        int[] arrCopy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arrCopy);
        SortAlgorithms.quicksort(arr);
        assertArrayEquals(arrCopy, arr);

    }

    @Test
    void swap() {
        Object[] arr = new Object[]{10,20,30,40,50,60,70,80,90};
        SortAlgorithms.swap(arr,0,arr.length-1);
        assertArrayEquals(new Object[]{90,20,30,40,50,60,70,80,10},arr);

    }

    @Test
    void bubbleSort() {
        Random r = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(10000000);
        }
        int[] arrCopy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arrCopy);
        assertArrayEquals(new int[]{10,20,30,40,50,60,70,80,90}, SortAlgorithms.bubbleSort(new int[]{80,70,10,30,50,20,90,40,60}));
        assertArrayEquals(arrCopy, SortAlgorithms.bubbleSort(arr));

    }
}