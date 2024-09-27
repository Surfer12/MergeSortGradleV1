package mergesortgradlev1;

import mergesortgradlev1.MergeSortClaudeAlterV1;

import java.util.Arrays;

public class MainApplication {

    /**
     * Main method to demonstrate the merge sort algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] array = { 38, 27, 43, 3, 9, 82, 10 }; // Example unsorted array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        MergeSortClaudeAlterV1.mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
