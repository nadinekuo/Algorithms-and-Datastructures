import java.util.*;

public class ShiftGrid {

    /**
     * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
     *
     * In one shift operation:
     *
     * Element at grid[i][j] moves to grid[i][j + 1].
     * Element at grid[i][n - 1] moves to grid[i + 1][0].
     * Element at grid[m - 1][n - 1] moves to grid[0][0].
     *
     * @param grid the matrix
     * @param k    - amount of shifts
     * @return the resulting list (2D list)
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {


        int rows = grid.length;
        int columns = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int last = grid[rows-1][columns-1];
            for (int j = rows-1; j >= 0; j--) {
                for (int m = columns-1; m >= 0; m--) {
                    if (j == 0 && m == 0) grid[j][m] = last; // top left corner becomes right bottom corner
                    else if (m == 0) grid[j][m] = grid[j-1][columns-1];         // first of row becomes last of previous row
                    else {
                        grid[j][m] = grid[j][m-1];
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                newRow.add(grid[i][j]);
            }
            result.add(newRow);
        }

        return result;

    }
}
