package game2048;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/**
 * Tests the non-empty constructor of Model.
 *
 * @author Zoe Plaxco
 */
public class TestArgsConstructor {

    /**
     * Note that this isn't a possible board state.
     */
    @Test
    public void testCompletelyEmpty() {
        int[][] rawVals = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                assertThat(m.tile(x, y)).isNull();
            }
        }
    }

    /**
     * Tests a board that is completely full except for the top row.
     */
    @Test
    public void testEmptyTopRow() {
        int[][] rawVals = new int[][]{
                {0, 0, 0, 0},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
        };

        Model m = new Model(rawVals, 0, 0, false);

        for (int x = 0; x < 4; x++) {
            assertThat(m.tile(x, 3)).isNull();
        }
        for (int x = 1; x < 4; x++) {
            for (int y = 0; y < 3; y++) {
                assertThat(m.tile(x, y)).isNotNull();
            }
        }
    }

    /**
     * Tests a board that is completely full except for the bottom row.
     */
    @Test
    public void testEmptyBottomRow() {
        int[][] rawVals = new int[][]{
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {0, 0, 0, 0},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int x = 0; x < 4; x++) {
            assertThat(m.tile(x, 0)).isNull();
        }
        for (int x = 0; x < 4; x++) {
            for (int y = 1; y < 4; y++) {
                assertThat(m.tile(x, y)).isNotNull();
            }
        }
    }


    /**
     * Tests a board that is completely full except for the left column.
     */
    @Test
    public void testEmptyLeftCol() {
        int[][] rawVals = new int[][]{
                {0, 4, 2, 4},
                {0, 2, 4, 2},
                {0, 4, 2, 4},
                {0, 2, 4, 2},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int y = 0; y < 4; y++) {
            assertThat(m.tile(0, y)).isNull();        }
        for (int x = 1; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                assertThat(m.tile(x, y)).isNotNull();            }
        }
    }

    /**
     * Tests a board that is completely full except for the right column.
     */
    @Test
    public void testEmptyRightCol() {
        int[][] rawVals = new int[][]{
                {2, 4, 2, 0},
                {4, 2, 4, 0},
                {2, 4, 2, 0},
                {4, 2, 4, 0},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int i = 0; i < 4; i++) {
            assertThat(m.tile(3, i)).isNull();        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                assertThat(m.tile(x, y)).isNotNull();            }
        }
    }

    /**
     * Tests a completely full board except one piece.
     */
    @Test
    public void testAlmostFullBoard() {
        int[][] rawVals = new int[][]{
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 0, 2, 4},
                {4, 2, 4, 2},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int x = 1; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (x == 1 && y == 1) {
                    assertThat(m.tile(x, y)).isNull();                } else {
                    assertThat(m.tile(x, y)).isNotNull();                }
            }
        }
    }

    /**
     * Tests a completely full board.
     * The game isn't over since you can merge, but the emptySpaceExists method
     * should only look for empty space (and not adjacent values).
     */
    @Test
    public void testFullBoard() {
        int[][] rawVals = new int[][]{
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                assertThat(m.tile(x, y)).isNotNull();            }
        }
    }

    /**
     * Tests a completely full board.
     */
    @Test
    public void testFullBoardNoMerge() {
        int[][] rawVals = new int[][]{
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        Model m = new Model(rawVals, 0, 0, false);
        for (int x = 1; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                assertThat(m.tile(x, y)).isNotNull();            }
        }
    }

    /**
     * Tests that score parameters are accounted for.
     */
    @Test
    public void testScores() {
        int[][] rawVals = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        int score = 7;
        int maxScore = 2048;

        Model m = new Model(rawVals, score, maxScore, false);
        assertWithMessage("Model has score passed to constructor").that(m.score()).isEqualTo(score);
        assertWithMessage("Model has maxScore passed to constructor").that(m.maxScore()).isEqualTo(maxScore);

        score = 25;
        maxScore = 1024;

        m = new Model(rawVals, score, maxScore, false);
        assertWithMessage("Model has score passed to constructor").that(m.score()).isEqualTo(score);
        assertWithMessage("Model has maxScore passed to constructor").that(m.maxScore()).isEqualTo(maxScore);
    }
}
