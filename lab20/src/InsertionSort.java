
public class InsertionSort {

    /**
     * @param arr
     *
     * Sort the array arr in place using insertion sort.
     * The insertion sort algorithm is as follows:
     * 1. Loop through each element in the array.
     * 2. While the element is smaller than the previous element in the array,
     *   swap the element with the previous element.
     *
     * This should be an in-place sort, so you shouldn't create any additional arrays.
     */
    public static void sort(int[] arr) {
        // TODO: Implement insertion sort
    }

    /**
     * @param arr
     * @param i
     * @param j
     *
     * Swap the elements at indices i and j in the array arr.
     * A helper method you can use in your implementation of sort.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = temp;

    }
}

