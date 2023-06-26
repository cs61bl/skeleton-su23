package src;

import org.junit.Test;
import static com.google.common.truth.Truth.assertWithMessage;

public class AListTest {

    @Test
    public void testFor() {
        AList<Integer> a = new AList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        int count = 0;
        for (Integer i : a) {
            count += i;
        }

        assertWithMessage("Total sum of elements should be 6").that(count).isEqualTo(6);
    }
}
