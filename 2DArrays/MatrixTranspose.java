public class MatrixTranspose {


    /** You are given a square 2D image matrix where each integer represents a pixel.
     * Write a method transposeMatrix to transform the matrix into its Transpose - in-place.
     Example:Input image :
     1 0
     1 0
     Modified to :
     1 1
     0 0
     * @param matrix
     */
    public static void transposeMatrix(int[][] matrix) {

        int rows = matrix.length;
//        int columns = rows;
        int n = rows-1;

        // go over all rows
        for (int i = 0; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];   // REFLECTED in main diagonal!
                matrix[j][i] = temp;
            }
        }

    }

}
