import org.junit.Test;

import static org.junit.Assert.fail;
import static com.google.common.truth.Truth.assertWithMessage;

/** A suite of tests for SLList. */

public class SLListTest {

    /**
     * Example test that verifies correctness of the SLListFactory's of method.
     * The main point of this is to convince you that assertEquals knows how to
     * handle SLList just fine because we implemented SLList.equals.
     */
    @Test
    public void testOf() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> test = factory.of(1, 2, 3, 4, 5);
        assertWithMessage("Created list is null").that(test).isNotNull();
        assertWithMessage("First item in the list was not 1").that(test.item).isEqualTo(1);
        assertWithMessage("Second item in the list was not 2").that(test.next.item).isEqualTo(2);
        assertWithMessage("Third item in the list was not 3").that(test.next.next.item).isEqualTo(3);
        assertWithMessage("Fourth item in the list was not 4").that(test.next.next.next.item).isEqualTo(4);
        assertWithMessage("Fifth item in the list was not 5").that(test.next.next.next.next.item).isEqualTo(5);
        assertWithMessage("Null expected, but instead found another node").that(test.next.next.next.next.next).isNull();


        SLList<Integer> empty = factory.of();
        assertWithMessage("Empty list should be null!").that(empty).isNull();

        SLList<Integer> single = factory.of(1);
        assertWithMessage("Single list should not be null!").that(single).isNotNull();
        assertWithMessage("Single list should start with 7").that(single.item).isEqualTo(1);
        assertWithMessage("Single list should only have a single node!").that(single.next).isNull();
    }

    @Test
    public void testGet() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> test = factory.of(1, 2, 3, 4, 5);
        assertWithMessage("first item should be 1").that(test.get(0)).isEqualTo(1);
        assertWithMessage("second item should be 2").that(test.get(1)).isEqualTo(2);
        assertWithMessage("third item should be 3").that(test.get(2)).isEqualTo(3);
        assertWithMessage("fourth item should be 4").that(test.get(3)).isEqualTo(4);
        assertWithMessage("fifth item should be 5").that(test.get(4)).isEqualTo(5);
        try {
            test.get(5);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            fail("Should throw IllegalArgumentException");
        }

        try {
            test.get(-1);
            fail("Should throw IllegalArgumentException for negative indices");
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            fail("Should throw IllegalArgumentException for negative indices");
        }

        SLList<Integer> single = factory.of(5);
        assertWithMessage("Index 0 should have 5").that(single.get(0)).isEqualTo(5);
        try {
            single.get(1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            fail("Should throw IllegalArgumentException");
        }
    }

    @Test
    public void testToString() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> test = factory.of(1, 2, 3, 4, 5);
        assertWithMessage("toString does not work on test").that(test.toString()).isEqualTo("1 2 3 4 5");
        assertWithMessage("toString does not work on smaller list").that(factory.of(2, 3, 4).toString()).isEqualTo("2 3 4");
        assertWithMessage("toString does not work on singleton").that(factory.of(1).toString()).isEqualTo("1");
    }

    @Test
    public void testEquals() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> a = factory.of(1, 2, 3, 4, 5);
        SLList<Integer> b = factory.of(1, 2, 3, 4, 5);

        assertWithMessage("List should equal itself").that(a.equals(a)).isTrue();
        assertWithMessage("List should equal itself").that(b.equals(b)).isTrue();
        assertWithMessage("A should equal B").that(a.equals(b)).isTrue();
        assertWithMessage("B should equal A").that(b.equals(a)).isTrue();

        assertWithMessage("A should not equal a generic Object").that(a.equals(new Object())).isFalse();
        assertWithMessage("B should not equal a primitive").that(b.equals(242)).isFalse();

        assertWithMessage("A should not equal this smaller list").that(a.equals(factory.of(1, 2, 3, 4))).isFalse();
        assertWithMessage("A should not equal this equal-length but different list").that(a.equals(factory.of(1, 2, 3, 4, 6))).isFalse();
    }

    @Test
    public void testAdd() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> a = factory.of(1, 2, 3);
        assertWithMessage("a does not equal (1, 2, 3)").that(a.equals(factory.of(1, 2, 3))).isTrue();
        a.add(4);
        assertWithMessage("a does not equal (1, 2, 3, 4)").that(a.equals(factory.of(1, 2, 3, 4))).isTrue();
        a.add(5);
        assertWithMessage("a does not equal (1, 2, 3, 4, 5)").that(a.equals(factory.of(1, 2, 3, 4, 5))).isTrue();

        SLList<Integer> single = factory.of(1);
        assertWithMessage("single does not equal (1)").that(single.equals(factory.of(1))).isTrue();
        single.add(2);
        assertWithMessage("single does not equal (1, 2)").that(single.equals(factory.of(1, 2))).isTrue();
    }


    public class SquareFunctionContainer implements FunctionContainer<Integer> {
        public Integer func(Integer num) {
            return num * num;
        }
    }

    @Test
    public void testDFuncList() {
        SquareFunctionContainer funcContainer = new SquareFunctionContainer();
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> L = factory.of(1, 2, 3);
        assertWithMessage("L is not equal to (1, 2, 3)").that(L.equals(factory.of(1, 2, 3))).isTrue();

        factory.dFuncList(L, funcContainer);
        assertWithMessage("L is not equal to (1, 4, 9)").that(L.equals(factory.of(1, 4, 9))).isTrue();
    }

    @Test
    public void testFuncListIterative() {
        SquareFunctionContainer funcContainer = new SquareFunctionContainer();
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> L = factory.of(1, 2, 3);
        assertWithMessage("L is not equal to (1, 2, 3)").that(L.equals(factory.of(1, 2, 3))).isTrue();

        SLList<Integer> newL = factory.funcListIterative(L, funcContainer);
        assertWithMessage("L is not equal to (1, 4, 9)").that(newL.equals(factory.of(1, 4, 9))).isTrue();
        assertWithMessage("L was modified").that(L.equals(factory.of(1, 2, 3))).isTrue();
    }

    @Test
    public void testFuncListRecursive() {
        SquareFunctionContainer funcContainer = new SquareFunctionContainer();
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> L = factory.of(1, 2, 3);
        assertWithMessage("L is not equal to (1, 2, 3)").that(L.equals(factory.of(1, 2, 3))).isTrue();

        SLList<Integer> newL = factory.funcListRecursive(L, funcContainer);
        assertWithMessage("L is not equal to (1, 4, 9)").that(newL.equals(factory.of(1, 4, 9))).isTrue();
        assertWithMessage("L was modified").that(L.equals(factory.of(1, 2, 3))).isTrue();
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy SLList.of method.
     *
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty of, which
     * can be instantiated, for example, with
     * SLList<Integer> factory = new SLList<Integer>();
     * SLList<Integer> empty = factory.of().
     *
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */
    @Test
    public void testCatenate() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> A = factory.of(1, 2, 3);
        SLList<Integer> B = factory.of(4, 5, 6);

        SLList<Integer> exp = factory.of(1, 2, 3, 4, 5, 6);
        SLList<Integer> res = factory.catenate(A, B);
        // Check that correctly catenates
        assertWithMessage("catenated list does not equal expected result").that(res.equals(exp)).isTrue();

        // Cannot modify A or B
        assertWithMessage("A has been modified").that(A.equals(factory.of(1, 2, 3))).isTrue();
        assertWithMessage("B has been modified").that(B.equals(factory.of(4, 5, 6))).isTrue();
    }

    @Test
    public void testDCatenate() {
        SLListFactory<Integer> factory = new SLListFactory<>();
        SLList<Integer> A = factory.of(1, 2, 3);
        SLList<Integer> B = factory.of(4, 5, 6);

        SLList<Integer> exp = factory.of(1, 2, 3, 4, 5, 6);
        SLList<Integer> res = factory.dcatenate(A, B);
        // Check that correctly catenates
        assertWithMessage("Result of catenation does not match expected").that(res.equals(exp)).isTrue();

        // Check that A has been modified
        assertWithMessage("A does not equal the expected result").that(A.equals(factory.of(1, 2, 3, 4, 5, 6))).isTrue();
        A.item = 7;
        assertWithMessage("A modification in A is not reflected in the result").that(A.item.equals(res.item)).isTrue();
    }
}