
```java
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Example array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        performMergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    /**
     * Performs the merge sort algorithm on the specified array segment.
     *
     * @param array The array to be sorted.
     * @param startIndex The starting index of the array segment.
     * @param endIndex The ending index of the array segment.
     */
    public static void performMergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2; // Find the middle point

            // Recursively sort the first and second halves
            performMergeSort(array, startIndex, middleIndex);
            performMergeSort(array, middleIndex + 1, endIndex);

            // Merge the sorted halves
            mergeSortedHalves(array, startIndex, middleIndex, endIndex);
        }
    }

    /**
     * Merges two sorted subarrays of the specified array.
     *
     * @param array The array containing the subarrays.
     * @param startIndex The starting index of the left subarray.
     * @param middleIndex The ending index of the left subarray and the middle point.
     * @param endIndex The ending index of the right subarray.
     */
    public static void mergeSortedHalves(int[] array, int startIndex, int middleIndex, int endIndex) {
        int leftSize = middleIndex - startIndex + 1;
        int rightSize = endIndex - middleIndex;

        // Create temporary arrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[startIndex + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middleIndex + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0; // Initial indexes of first and second subarrays
        int k = startIndex; // Initial index of merged subarray
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
````

### Explanation of Changes:
- **Method Names:** Changed `mergeSort` to `performMergeSort` and `merge` to `mergeSortedHalves` for clarity.
- **Parameter Names:** Updated method parameters to be more descriptive (`left` to `startIndex`, `right` to `endIndex`, and `mid` to `middleIndex`).v