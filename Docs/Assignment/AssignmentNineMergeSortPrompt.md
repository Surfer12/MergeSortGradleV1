# CIS232 Assignment 9: Merge Sort and AI tool usage

## Instructions

<!-- Assignment 9
Due Tuesday by 11:59pm Points 100 Submitting a file upload File Types jpeg, png, and pdf Available Sep 26 at 12am - Oct 1 at 11:59pm -->

## Tasks

1. **Task 1: Merge Sort and AI tool usage:**
   - Understand the Merge Sort Algorithm.
   - Review the merge sort code from your slides to grasp its functionality.
   - Identify the key components of the algorithm, including the merge function.
   - Utilize an AI Tool for Explanation.
   - Iterate and Seek Clarifications.

2. **Task 2: Understand the Merge Sort Algorithm:**
   - Review the merge sort code from your slides to grasp its functionality.
   - Identify the key components of the algorithm, including the merge function.

3. **Task 3: Utilize an AI Tool for Explanation:**
   - Utilize an AI Tool for Explanation.
   - Prompt the AI to explain the code and the merge function in detail.
   - Ask the AI to elaborate on the time and space complexity of merge sort.

4. **Task 4: Iterate and Seek Clarifications:**
   - Review the AI's responses carefully.
   - If you have any doubts or need further elaboration, pose additional questions to the AI.

5. **Task 5: Compile Your Submission:**
   - Capture screenshots of your prompts and the AI's answers.
   - Write a brief paragraph expressing your thoughts on the AI's explanations.

## Key components of the Merge Sort Algorithm

### performMergeSort method 
#### The recursive function that splits, sorts and then merges the array.

```java
/**
     * Performs the merge sort algorithm on the specified array segment.
     *
     * @param array      The array to be sorted.
     * @param startIndex The starting index of the array segment.
     * @param endIndex   The ending index of the array segment.
     */
    public static void performMergeSort(int[] array, int startIndex, int endIndex) {
        // Base case: if the segment has 1 or fewer elements, it's already sorted
        if (startIndex < endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2; // Find the middle point (avoids integer
                                                                        // overflow)

            // Recursively sort the first half
            performMergeSort(array, startIndex, middleIndex); // Left half

            // Recursively sort the second half
            performMergeSort(array, middleIndex + 1, endIndex); // Right half

            // Merge the sorted halves
            mergeSortedHalves(array, startIndex, middleIndex, endIndex);
        }
    }
```

### mergeSortedHalves method
#### The method that merges the two halves of the array.

```java
/**
     * Merges two sorted subarrays of the specified array.
     *
     * @param array       The array containing the subarrays.
     * @param startIndex  The starting index of the left subarray.
     * @param middleIndex The ending index of the left subarray and the middle
     *                    point.
     * @param endIndex    The ending index of the right subarray.
     */
    public static void mergeSortedHalves(int[] array, int startIndex, int middleIndex, int endIndex) {
        int leftSize = middleIndex - startIndex + 1;
        int rightSize = endIndex - middleIndex;

        // Create temporary arrays
        int[] leftArray = Arrays.copyOfRange(array, startIndex, middleIndex + 1);
        int[] rightArray = Arrays.copyOfRange(array, middleIndex + 1, endIndex + 1);

        // Merge the temporary arrays back into array[startIndex..endIndex]
        int leftIndex = 0, rightIndex = 0, mergedIndex = startIndex;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex++] = leftArray[leftIndex++];
            } else {
                array[mergedIndex++] = rightArray[rightIndex++];
            }
        }

        // Copy remaining elements of leftArray[] if any
        while (leftIndex < leftSize) {
            array[mergedIndex++] = leftArray[leftIndex++];
        }

        // Copy remaining elements of rightArray[] if any
        while (rightIndex < rightSize) {
            array[mergedIndex++] = rightArray[rightIndex++];
        }
    }
```

## Utilize an AI Tool for Explanation: 

```
Claude 3.5 Sonnet is utitlized for the refactoring of the inital merge sort code into a more readable and efficient format.
Inital code was created by Cursor Small Language Model in the Cursor IDE. (link to cursor IDE)
```

## Prompt the AI to explain the code and the merge function in detail. 

```
#Prompt: 

```

## Ask the AI to elaborate on the time and space complexity of merge sort.

```
#Regarding the time and space complexity:

## Time Complexity: O(n log n)
- The algorithm divides the array into two halves in each recursive step, which takes O(log n) time.
- The merging process takes O(n) time for each level of recursion.
- Therefore, the overall time complexity is O(n log n) for all cases (best, average, and worst).

## Space Complexity: O(n)
- The algorithm uses temporary arrays in the merge step, which at most will be the size of the original array.
- The recursive call stack will use O(log n) space.
- The dominant factor is the temporary array space, so the overall space complexity is O(n).

This implementation provides a good balance between efficiency and readability, making it suitable for educational purposes and practical use in sorting moderate-sized arrays.
```

## Iterate and Seek Clarifications: Claude 3.5 Sonnet's feedback on inital merge sort implimentation seen here. 
# Inital Code created by Cursor Small In Line 

```java
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
```
## Iteration and clarification from 




## Review the AI's responses carefully.
If you have any doubts or need further elaboration, pose additional questions to the AI.
Compile Your Submission:

Capture screenshots of your prompts and the AI's answers.
Write a brief paragraph expressing your thoughts on the AI's explanations.
Submission:

Submit your screenshots and a pdf with the brief paragraph (state the AI tool you used). Name the files appropriately CIS232_firstname_lastname




