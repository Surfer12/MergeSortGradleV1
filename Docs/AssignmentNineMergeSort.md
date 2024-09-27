# CIS232 Assignment 9


## Merge Sort and AI tool usage

### Instructions

```
Assignment 9
Due Tuesday by 11:59pm Points 100 Submitting a file upload File Types jpeg, png, and pdf Available Sep 26 at 12am - Oct 1 at 11:59pm

Merge Sort and AI tool usage:

Understand the Merge Sort Algorithm:

Review the merge sort code from your slides to grasp its functionality.
Identify the key components of the algorithm, including the merge function.
Utilize an AI Tool for Explanation:

Select an AI tool of your choice.
Prompt the AI to explain the code and the merge function in detail.
Ask the AI to elaborate on the time and space complexity of merge sort.
Iterate and Seek Clarifications:

Review the AI's responses carefully.
If you have any doubts or need further elaboration, pose additional questions to the AI.
Compile Your Submission:

Capture screenshots of your prompts and the AI's answers.
Write a brief paragraph expressing your thoughts on the AI's explanations.
Submission:

Submit your screenshots and a pdf with the brief paragraph (state the AI tool you used). Name the files appropriately CIS232_firstname_lastname
```

# Merge Sort

## Code
```java
/**
 * Merge Sort implementation in Java.
 */
public class MergeSort {

    /**
     * Main method to execute the merge sort algorithm.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Example array
        System.out.println("Unsorted array: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param array The array to be sorted.
     * @param left  The starting index of the array segment.
     * @param right The ending index of the array segment.
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Find the middle point

            // Recursively sort the first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    /**
     * Merges two subarrays of array[].
     *
     * @param array The array containing the subarrays.
     * @param left  The starting index of the left subarray.
     * @param mid   The ending index of the left subarray and the middle point.
     * @param right The ending index of the right subarray.
     */
    public static void merge(int[] array, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0; // Initial indexes of first and second subarrays
        int k = left; // Initial index of merged subarray
        while (i < n1 && j < n2) {
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
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
```

### Explanation:
- **Main Method:** Initializes an example array and calls the `mergeSort` method.
- **mergeSort Method:** Recursively divides the array into halves until single elements remain, then merges them back together.
- **merge Method:** Merges two sorted subarrays into a single sorted array.

This implementation follows the divide-and-conquer approach typical of the Merge Sort algorithm.

## AI tool usage

I used the AI tool Cursor-Small to help me understand the code and the merge function in detail.

I asked the AI to explain the code and the merge function in detail.

I asked the AI to elaborate on the time and space complexity of merge sort.

## Thoughts on the AI's explanations

The AI's explanations were helpful in understanding the code and the merge function in detail.

The AI's explanations were helpful in understanding the time and space complexity of merge sort.



