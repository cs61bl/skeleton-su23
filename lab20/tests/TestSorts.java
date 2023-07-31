import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;



public class TestSorts {

    // TODO: Write more comprehensive tests that will help you debug your code.

    @Test
    public void testHeapSort() {

        int[] arr = {6, 3, 5, 7, 2, 1, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        HeapSort.sort(arr);
        assertThat(arr).isEqualTo(expected);


    }

    @Test
    public void testInsertionSort() {

        int[] arr = {6, 3, 5, 7, 2, 1, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        InsertionSort.sort(arr);
        assertThat(arr).isEqualTo(expected);


    }

    @Test
    public void testSelectionSort() {

        int[] arr = {6, 3, 5, 7, 2, 1, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        SelectionSort.sort(arr);
        assertThat(arr).isEqualTo(expected);


    }
}