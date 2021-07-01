
public class FlipMatrix {


    /**
     * Flip it vertical axis.
     * You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its vertical axis.
     * Example:
     * Input image :
     *               1 0
     *               1 0
     * Modified to :
     *               0 1
     *               0 1
     * @param matrix the matrix
     *               TIME: O(n)
     *               SPACE: O(1) <-- in-place
     */
    public static void flipItVerticalAxis(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns/2; j++) {
                swap(matrix[i], j, columns-j-1);
            }
        }

    }


    /**
     * Flip horizontal axis.
     *You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its horizontal axis.
     * Example:
     * Input image :
     *               1 1
     *               0 0
     * Modified to :
     *               0 0
     *               1 1
     * @param matrix the matrix
     *               TIME: O(n)
     *               SPACE: O(1)
     */
    public static void flipHorizontalAxis(int[][] matrix) {

        int rows = matrix.length;

        for (int i = 0; i < rows/2; i++) {
            swapRows(matrix, i, rows-i-1);
        }

    }


    public static void swapRows(int[][] matrix, int i, int j) {
        int[] tempRow = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tempRow;
    }

    public static void swap(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }

}
