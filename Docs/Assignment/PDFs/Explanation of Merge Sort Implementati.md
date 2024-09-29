# Merge Sort Functionality and Key Components

## General Overview of Merge Sort

- Merge Sort is a *divide-and-conquer* algorithm used for sorting arrays or lists. 
- It works by recursively dividing the array into smaller subarrays 
- This continues until each subarray contains a single element.
- Then, it merges these subarrays to produce a newly sorted subarrays until the entire array is sorted.
- Merge Sort is renowned for its efficiency and predictable performance, making it a popular choice for various applications because it ensures that the sorting process is both *stable* and *consistent*. 


## Code of Classic Merge Sort

```java
public static void mergeSort(int[] array) {
    if (array == null || array.length <= 1) {
        return;
    }
    int[] tempArray = new int[array.length];
    mergeSortHelper(array, tempArray, 0, array.length - 1);
}

private static void mergeSortHelper(int[] array, int[] tempArray, int left, int right) {
    if (left < right) {
        int middle = left + (right - left) / 2;
        mergeSortHelper(array, tempArray, left, middle);
        mergeSortHelper(array, tempArray, middle + 1, right);
        merge(array, tempArray, left, middle, right);
    }
}

private static void merge(int[] array, int[] tempArray, int left, int middle, int right) {
    for (int i = left; i <= right; i++) {
        tempArray[i] = array[i];
    }
    int i = left;
    int j = middle + 1;
    int k = left;
    while (i <= middle && j <= right) {
        if (tempArray[i] <= tempArray[j]) {
            array[k++] = tempArray[i++];
        } else {
            array[k++] = tempArray[j++];
        }
    }
    while (i <= middle) {
        array[k++] = tempArray[i++];  
    }
}
```

### Key Characteristics
- **Stable**: Maintains the relative order of equal elements.
- **Consistent Performance**: O(n log n) time complexity for all cases.
- **External Sorting**: Efficient for large datasets that do not fit into memory.

- The stability of Merge Sort means that equal elements retain their original order, which is crucial for maintaining the relative order of equal elements in the sorted array.
- The consistency of Merge Sort ensures that its performance is predictable and reliable, making it a valuable tool for sorting tasks in various applications. This is highlighted by its consistent time complexity of O(n log n), which is efficient and reliable for sorting large datasets.

## Key Components of the Merge Sort Algorithm with provided analysis and alterations 

### 1. `performMergeSort` Method

The `performMergeSort` method is the core of the Merge Sort algorithm. It recursively divides the array into smaller segments, sorts them, and then merges the sorted segments.

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
        int middleIndex = startIndex + (endIndex - startIndex) / 2; // Find the middle point (avoids integer overflow)

        // Recursively sort the first half
        performMergeSort(array, startIndex, middleIndex); // Left half

        // Recursively sort the second half
        performMergeSort(array, middleIndex + 1, endIndex); // Right half

        // Merge the sorted halves
        mergeSortedHalves(array, startIndex, middleIndex, endIndex);
    }
}
```
**Explanation:**

- **Base Case:** The method first checks if the current segment of the array has more than one element (`startIndex < endIndex`). If not, the segment is already sorted.
  
- **Finding the Middle:** It calculates the `middleIndex` to divide the array into two halves. Using `startIndex + (endIndex - startIndex) / 2` prevents potential integer overflow.
  
- **Recursive Sorting:** The method recursively calls itself to sort the left half (`startIndex` to `middleIndex`) and the right half (`middleIndex + 1` to `endIndex`).
  
- **Merging:** After sorting both halves, it calls the `mergeSortedHalves` method to merge the two sorted subarrays into a single sorted segment.


### 2. `mergeSortedHalves` Method

The `mergeSortedHalves` method is responsible for merging two sorted subarrays into a single sorted segment. It ensures that the combined array maintains the sorted order.

### `mergeSortedHalves` Method

```java
/**
 * Merges two sorted subarrays of the specified array.
 *
 * @param array       The array containing the subarrays.
 * @param startIndex  The starting index of the left subarray.
 * @param middleIndex The ending index of the left subarray and the middle point.
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
**Explanation:**

- **Determining Sizes:** The method calculates the sizes of the left and right subarrays (`leftSize` and `rightSize`) based on the provided indices.
  
- **Creating Temporary Arrays:** It creates temporary arrays `leftArray` and `rightArray` by copying the relevant segments from the original array using `Arrays.copyOfRange`.
  
- **Merging Process:**
  - Initializes three pointers: `leftIndex`, `rightIndex`, and `mergedIndex` to track positions in the left array, right array, and the main array, respectively.
  - Iterates through both temporary arrays, comparing elements and placing the smaller one into the main array.
  
- **Copying Remaining Elements:** After the main loop, if there are any remaining elements in either `leftArray` or `rightArray`, they are copied into the main array to complete the merge.

## Time and Space Complexity of Merge Sort

### Time Complexity: **O(n log n)**

- **Divide Phase:** 
  - The array is recursively divided into two halves until each subarray has only one element.
  - The depth of the recursion tree is `log n`, where `n` is the number of elements in the array.

- **Conquer Phase (Merging):**
  - At each level of recursion, the merging process takes linear time `O(n)` since each element is compared and merged.
  
- **Overall Complexity:**
  - Combining both phases, the total time complexity becomes `O(n log n)` for all cases (best, average, and worst).

### Space Complexity: **O(n)**

- **Auxiliary Space for Temporary Arrays:**
  - The algorithm uses temporary arrays (`leftArray` and `rightArray`) to store the divided segments during the merge process.
  - At any point, the total size of these temporary arrays is proportional to the size of the input array, resulting in `O(n)` space.
  
- **Recursive Call Stack:**
  - The depth of the recursion stack is `log n`, and each recursive call consumes constant space.
  - Therefore, the space used by the call stack is `O(log n)`.
  
- **Dominant Factor:**
  - The auxiliary space for temporary arrays (`O(n)`) dominates the space used by the call stack (`O(log n)`), making the overall space complexity `O(n)`.

**Conclusion:**

The Merge Sort algorithm offers a consistent and efficient sorting mechanism with a time complexity of `O(n log n)` and a space complexity of `O(n)`. Its divide-and-conquer approach makes it highly effective for large datasets, and the algorithm's stability ensures that equal elements retain their original order post-sorting.


### `performMergeSort` Method

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
        int middleIndex = startIndex + (endIndex - startIndex) / 2; // Find the middle point (avoids integer overflow)

        // Recursively sort the first half
        performMergeSort(array, startIndex, middleIndex); // Left half

        // Recursively sort the second half
        performMergeSort(array, middleIndex + 1, endIndex); // Right half

        // Merge the sorted halves
        mergeSortedHalves(array, startIndex, middleIndex, endIndex);
    }
}
```

**Explanation:**

- **Base Case:** The method first checks if the current segment of the array has more than one element (`startIndex < endIndex`). If not, the segment is already sorted.
  
- **Finding the Middle:** It calculates the `middleIndex` to divide the array into two halves. Using `startIndex + (endIndex - startIndex) / 2` prevents potential integer overflow.
  
- **Recursive Sorting:** The method recursively calls itself to sort the left half (`startIndex` to `middleIndex`) and the right half (`middleIndex + 1` to `endIndex`).
  
- **Merging:** After sorting both halves, it calls the `mergeSortedHalves` method to merge the two sorted subarrays into a single sorted segment.

### `mergeSortedHalves` Method

```java:app/src/main/java/mergesortgradlev1/MergeSortClaudeAlterV1.java
/**
 * Merges two sorted subarrays of the specified array.
 *
 * @param array       The array containing the subarrays.
 * @param startIndex  The starting index of the left subarray.
 * @param middleIndex The ending index of the left subarray and the middle point.
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

**Explanation:**

- **Determining Sizes:** The method calculates the sizes of the left and right subarrays (`leftSize` and `rightSize`) based on the provided indices.
  
- **Creating Temporary Arrays:** It creates temporary arrays `leftArray` and `rightArray` by copying the relevant segments from the original array using `Arrays.copyOfRange`.
  
- **Merging Process:**
  - Initializes three pointers: `leftIndex`, `rightIndex`, and `mergedIndex` to track positions in the left array, right array, and the main array, respectively.
  - Iterates through both temporary arrays, comparing elements and placing the smaller one into the main array.
  
- **Copying Remaining Elements:** After the main loop, if there are any remaining elements in either `leftArray` or `rightArray`, they are copied into the main array to complete the merge.

## Time and Space Complexity of Merge Sort

### Time Complexity: **O(n log n)**

- **Divide Phase:** 
  - The array is recursively divided into two halves until each subarray has only one element.
  - The depth of the recursion tree is `log n`, where `n` is the number of elements in the array.

- **Conquer Phase (Merging):**
  - At each level of recursion, the merging process takes linear time `O(n)` since each element is compared and merged.
  
- **Overall Complexity:**
  - Combining both phases, the total time complexity becomes `O(n log n)` for all cases (best, average, and worst).

### Space Complexity: **O(n)**

- **Auxiliary Space for Temporary Arrays:**
  - The algorithm uses temporary arrays (`leftArray` and `rightArray`) to store the divided segments during the merge process.
  - At any point, the total size of these temporary arrays is proportional to the size of the input array, resulting in `O(n)` space.
  
- **Recursive Call Stack:**
  - The depth of the recursion stack is `log n`, and each recursive call consumes constant space.
  - Therefore, the space used by the call stack is `O(log n)`.
  
- **Dominant Factor:**
  - The auxiliary space for temporary arrays (`O(n)`) dominates the space used by the call stack (`O(log n)`), making the overall space complexity `O(n)`.

