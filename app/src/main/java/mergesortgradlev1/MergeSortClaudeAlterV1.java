package mergesortgradlev1;

import java.util.Arrays;

public class MergeSortClaudeAlterV1 {

    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param array The array to be sorted.
     * @param left  The starting index of the array segment.
     * @param right The ending index of the array segment.
     */
    public static void mergeSort(int[] array, int left, int right) {
        // Base case: if the segment has 1 or fewer elements, it's already sorted
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the middle point (avoids integer overflow)

            // Recursively sort the first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays of array[].
     *
     * @param array The array containing the subarrays.
     * @param left  The starting index of the left subarray.
     * @param mid   The ending index of the left subarray and the middle point.
     * @param right The ending index of the right subarray.
     */
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        // Merge the temporary arrays back into array[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
