import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

	@Test
	public void testMergeSortWithUnsortedArray() {
		int[] array = {38, 27, 43, 3, 9, 82, 10};
		int[] expected = {3, 9, 10, 27, 38, 43, 82};
		MergeSort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void testMergeSortWithSortedArray() {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		int[] expected = {1, 2, 3, 4, 5, 6, 7};
		MergeSort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void testMergeSortWithReverseSortedArray() {
		int[] array = {7, 6, 5, 4, 3, 2, 1};
		int[] expected = {1, 2, 3, 4, 5, 6, 7};
		MergeSort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void testMergeSortWithDuplicates() {
		int[] array = {5, 3, 8, 3, 9, 1, 5};
		int[] expected = {1, 3, 3, 5, 5, 8, 9};
		MergeSort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void testMergeSortWithSingleElement() {
		int[] array = {1};
		int[] expected = {1};
		MergeSort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void testMergeSortWithEmptyArray() {
		int[] array = {};
		int[] expected = {};
		MergeSort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}
}