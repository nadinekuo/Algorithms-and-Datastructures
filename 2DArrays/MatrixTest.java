import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void shiftGridTest() {
        int[] row1 = new int[]{1, 2, 3};
        int[] row2 = new int[]{4, 5, 6};
        int[] row3 = new int[]{7, 8, 9};
        int[][] grid = new int[3][3];
        grid[0] = row1;
        grid[1] = row2;
        grid[2] = row3;
        System.out.println(ShiftGrid.shiftGrid(grid, 2));
    }

}