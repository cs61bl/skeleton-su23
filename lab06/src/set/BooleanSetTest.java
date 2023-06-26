package set;

import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class BooleanSetTest {

    @Test
    public void testBasics() {
        BooleanSet aSet = new BooleanSet(100);
        assertWithMessage("Size is not zero upon instantiation").that(aSet.size()).isEqualTo(0);
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertWithMessage("aSet should contain " + i).that(aSet.contains(i));
        }

        assertWithMessage("Size is not 50 after 50 calls to add").that(aSet.size()).isEqualTo(50);
        for (int i = 0; i < 100; i += 2) {
            aSet.remove(i);
            assertWithMessage("aSet should not contain " + i).that(!aSet.contains(i));;
        }

        assertWithMessage("aSet is not empty after removing all elements").that(aSet.isEmpty());
        assertWithMessage("Size is not zero after removing all elements").that(aSet.size()).isEqualTo(0);
    }
}
