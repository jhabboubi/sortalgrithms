package john.with.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithms {
    private Algorithms() {
    }


    // quick sort without parameters
    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    // quick sort used recursively
    public static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        // should be randomized and moved to last index as pivot
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int leftPointer = partitions(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);

    }

    // part of quick sort algorithm
    private static int partitions(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        if (array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }

    // swapping two indexes used in quick sort and bubble sort
    public static void swap(Object[] array, int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // swapping two indexes used in quick sort and bubble sort
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // bubble sort - own implementation
    public static int[] bubbleSort(int[] arr) {
        int moves = 0;
        // int loops = 0;
        do {
            moves = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    moves += 1;
                }
            }
            // checks how many loops and moves made in one while loops
            /*
                loops++;
                System.out.println(loops+ ": "+moves);
             */
        } while (moves > 0);

        return arr;
    }

    /**
     * get a list of factorial numbers
     *
     *  e.g. 5! = 5x4x3x2x1 = 120
     * @param toNumber up to factorial number inclusive.
     * @return a list of integers
     */

    public static List<Integer> factorialList(int toNumber) {

        List<Integer> list = new ArrayList<>();
        // added zero to match array list index with factorial number
        list.add(0);
        list.add(1);
        // i = 4

        for (int i = 2; i <= toNumber; i++) {
            int result = 1;
            for (int j = i; j > 1; j--) {
                result = result * j;
            }
            list.add(result);
        }
        return list;
    }

    public static int gcd(int one, int two){
        if(two == 0) return one;
        return gcd(two, one%two);
    }

}
