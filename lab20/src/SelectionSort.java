public class SelectionSort {


    /**
     * @param arr
     *
     * Sort the array arr in place using selection sort.
     * The selection sort algorithm is as follows:
     * 1. Find the minimum element in the array.
     * 2. Swap the minimum element with the first element in the array.
     * 3. Repeat steps 1 and 2, but ignoring the first element in the array.
     *
     * This should be an in-place sort, so you shouldn't create any additional arrays.
     */
    public static void sort(int[] arr) {
        // TODO: Implement selection sort
    }


    /**
     * @param arr
     * @param start
     * @return the index of the minimum element in the array arr, starting from index start.
     *
     * A suggested helper method that will make it easier for you to implement selection sort.
     */
    public static int min(int[] arr, int start) {
        // TODO: Implement this helper method
        return -1;
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

