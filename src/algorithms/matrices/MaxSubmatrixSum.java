package algorithms.matrices;

/**
 * Created by Rustam Miftakhutdinov on 17.01.15.
 */
public class MaxSubmatrixSum {
    /**
     * Takes any rectangular matrix and finds it's continious submatrix with the maximum sum of elements
     * @param matrix the matrix
     * @return 5 element array in form of [i, j, k, m, sum], where (i, j) and (j, k) are the points in the matrix that define the submatrix.
     */
    public static int[] getMaxSumSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rowSums = new int[rows][];

        for (int i = 0; i < rows; i++) {
            rowSums[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    rowSums[i][j] = matrix[i][j];
                } else {
                    rowSums[i][j] = rowSums[i - 1][j] + matrix[i][j];
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int minRow = -1;
        int minCol = -1;
        int maxRow = -1;
        int maxCol = -1;

        int[] rowMToNSums = new int[cols];
        for (int m = 0; m < rows; m++) {
            for (int n = m; n < rows; n++) {
                for (int j = 0; j < cols; j++) {
                    rowMToNSums[j] = rowSums[n][j] - (m == 0 ? 0 : rowSums[m - 1][j]);
                }

                int[] sumInterval = getMaxSumInterval(rowMToNSums);
                if (sumInterval[2] > maxSum) {
                    maxSum = sumInterval[2];
                    minCol = sumInterval[0];
                    maxCol = sumInterval[1];
                    minRow = m;
                    maxRow = n;
                }

            }
        }

        return new int[] { minRow, minCol, maxRow, maxCol, maxSum };
    }

    /**
     * Finds the maximum subarray of an input array
     * @param input the input array
     * @return 3-element array in the form of [i, j, sum]
     */
    public static int[] getMaxSumInterval(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("input can not be null");
        }

        if (input.length == 0) {
            throw new IllegalArgumentException("input can not be empty");
        }

        int maxSum = Integer.MIN_VALUE;
        int maxStart = -1;
        int maxEnd = -1;

        int currentSum = 0;
        int start = 0;

        for (int i = 0; i < input.length; i++) {
            if (currentSum < 0) {
                if (input[i] > currentSum) {
                    currentSum = input[i];
                    start = i;
                }
            } else {
                currentSum += input[i];
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
                maxStart = start;
                maxEnd = i;
            }
        }

        return new int[] { maxStart, maxEnd, maxSum };
    }

}
