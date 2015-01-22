package algorithms.matrices;

/**
 * Created by Rustam Miftakhutdinov on 13.12.14.
 */
public class RotateSquareMatrix {
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 2 * i - 1; j++) {
                int valueToSet = matrix[n - j - 1][i];
                int nextI = i;
                int nextJ = j;

                for (int k = 0; k < 4; k++) {
                    int nextValue = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = valueToSet;

                    int nextITmp = nextI;
                    nextI = nextJ;
                    nextJ = n - nextITmp - 1;
                    valueToSet = nextValue;
                }
            }
        }
    }
}
