import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestConversion {
    /*
     * Test class for 2-3 Trees to LLRB Conversions
     *
     * We've provided 2-3 tree and LLRB representations in this file as comments to help you debug.
     * Here's a quick guide to reading them:
     *
     * 2-3 tree nodes are represented with () using commas ',' to seperate elements. Children are
     * listed in the order left, middle, right.
     *
     * For LLRB Trees, Black Nodes are represented with () and red nodes are represented with ()*
     * Left children are listed before right children.
     *
     * Here's what the example from the
     * spec(https://cs61bl.org/su23/labs/lab12/#2-3-trees--llrb-trees) would be represented as:

     2-3 Tree representation:
            (3,5)
            ├── (1,2)
            ├── (4)
            └── (6,7)

     LLRB Tree representation:
            (5)
            ├── (3)*
            │   ├── (2)
            │   │   └── (1)*
            │   └── (4)
            └── (7)
                └── (6)*
     */

    @Test
    public void testEmptyTwoThreeTreeConversion() {
        TwoThreeTree<String> twoThreeTree = new TwoThreeTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>(twoThreeTree);

        /*
        2-3 Tree representation:

        LLRB Tree representation:

         */
        assertThat(rbTree.root).isNull();
    }

    @Test
    public void testSimpleTwoThreeTreeConversion() {

        TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>();
        twoThreeTree.root = new TwoThreeTree.TwoThreeNode<>(2);
        RedBlackTree<Integer> rbTree = new RedBlackTree<>(twoThreeTree);

        /*

        2-3 Tree representation:
            (2)

        LLRB Tree representation:
            (2)

         */

        assertThat(rbTree.root).isNotNull();
        assertThat(rbTree.root.isBlack).isTrue();
        assertThat(rbTree.root.item).isEqualTo(2);
        assertThat(rbTree.root.left).isNull();
        assertThat(rbTree.root.right).isNull();

        twoThreeTree.root = new TwoThreeTree.TwoThreeNode<>(3, 4);
        rbTree = new RedBlackTree<>(twoThreeTree);

        /*

        2-3 Tree representation:
            (3, 4)

        LLRB Tree representation:
            (4)
            └── (3)*

         */

        assertThat(rbTree.root).isNotNull();
        assertThat(rbTree.root.isBlack).isTrue();
        assertThat(rbTree.root.item).isEqualTo(4);

        assertThat(rbTree.root.left).isNotNull();
        assertThat(rbTree.root.left.isBlack).isFalse();
        assertThat(rbTree.root.left.item).isEqualTo(3);
        assertThat(rbTree.root.left.left).isNull();
        assertThat(rbTree.root.left.right).isNull();

        assertThat(rbTree.root.right).isNull();
    }

    @Test
    public void testTwoThreeTreeConversion() {

        TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>();
        twoThreeTree.root = new TwoThreeTree.TwoThreeNode<>(2);
        twoThreeTree.root.setChildAt(0, new TwoThreeTree.TwoThreeNode<>(1));
        twoThreeTree.root.setChildAt(1, new TwoThreeTree.TwoThreeNode<>(3, 4));
        RedBlackTree<Integer> rbTree = new RedBlackTree<>(twoThreeTree);

        /*

        2-3 Tree representation:
            (2)
            ├── (1)
            └── (3,4)

        LLRB Tree representation:
            (2)
            ├── (1)
            └── (4)
                └── (3)*

         */


        // root
        assertThat(rbTree.root).isNotNull();
        assertThat(rbTree.root.isBlack).isTrue();
        assertThat(rbTree.root.item).isEqualTo(2);

        // left
        assertThat(rbTree.root.left).isNotNull();
        assertThat(rbTree.root.left.isBlack).isTrue();
        assertThat(rbTree.root.left.item).isEqualTo(1);

        // left left
        assertThat(rbTree.root.left.left).isNull();

        // left right
        assertThat(rbTree.root.left.right).isNull();

        // right
        assertThat(rbTree.root.right).isNotNull();
        assertThat(rbTree.root.right.isBlack).isTrue();
        assertThat(rbTree.root.right.item).isEqualTo(4);

        // right left
        assertThat(rbTree.root.right.left).isNotNull();
        assertThat(rbTree.root.right.left.isBlack).isFalse();
        assertThat(rbTree.root.right.left.item).isEqualTo(3);


        // right right
        assertThat(rbTree.root.right.right).isNull();


    }

}
