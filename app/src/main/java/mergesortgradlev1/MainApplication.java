package mergesortgradlev1;

import java.util.Arrays;

public class MainApplication {

    public static void main(String[] args) {
        int[] array = { 38, 27, 43, 3, 9, 82, 10 }; // Example array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        MergeSortHelperNames.performMergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));

    }
}