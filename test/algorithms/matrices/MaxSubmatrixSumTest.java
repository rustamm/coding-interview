package algorithms.matrices;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 17.01.15.
 */
public class MaxSubmatrixSumTest {
    @Test
    public void testGetMaxSumSubmatrix() throws Exception {
        Assert.assertArrayEquals(new int[] {0, 0, 2, 2, 45}, MaxSubmatrixSum.getMaxSumSubmatrix(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));

        Assert.assertArrayEquals(new int[] {1, 0, 2, 1, 24}, MaxSubmatrixSum.getMaxSumSubmatrix(new int[][] {
                {-1, -2, -3},
                {4, 5, -6},
                {7, 8, -9}
        }));

        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 24}, MaxSubmatrixSum.getMaxSumSubmatrix(new int[][] {
                {4, 5, -6},
                {7, 8, -9}
        }));

        Assert.assertArrayEquals(new int[] {1, 0, 2, 1, 24}, MaxSubmatrixSum.getMaxSumSubmatrix(new int[][] {
                {-1, -2},
                {4, 5},
                {7, 8}
        }));
    }

    @Test
    public void testGetMaxSumInterval() throws Exception {
        Assert.assertArrayEquals(new int[] {5, 7, 101}, MaxSubmatrixSum.getMaxSumInterval(new int[]{1, 2, -10, 6, -11, 100, -99, 100}));
        Assert.assertArrayEquals(new int[] {1, 1, -1}, MaxSubmatrixSum.getMaxSumInterval(new int[]{-10, -1, -5}));
    }
}
