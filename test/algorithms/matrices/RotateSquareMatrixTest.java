package algorithms.matrices;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 13.12.14.
 */
public class RotateSquareMatrixTest {
    @Test
    public void test3x3RotationIsPerformedCorrectly() throws Exception {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] expectedResult = new int[][] {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        RotateSquareMatrix.rotateMatrix(matrix);

        assertMatricesEqual(expectedResult, matrix);
    }

    private static void assertMatricesEqual(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected.length; j++) {
                Assert.assertEquals(
                        "Expected and and actual matrices should match on position (" + i + ", " + j + ")",
                        expected[i][j],
                        actual[i][j]);
            }
        }
    }
}
