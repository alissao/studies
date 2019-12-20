package leetcode.arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int row = 0;
        int col = 0;
        int numsInMatrix = matrix.length*matrix[0].length;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] passedBy = new boolean[matrix.length][matrix[0].length];
        Movement mov = new Movement();

        if (matrix.length == 0) {
            return result;
        }

        for (int k = 0; k < numsInMatrix; k++){
            result.add(matrix[row][col]);

            /* this condition below is for checking the limits and also
             * if the spiral passed by the next number from the matrix.
             */
            if (((0 <= row && row < rows) && (0 <= col && col < cols)) &&
                ((mov.movingSpiral == 1 && !passedBy[row][col+1])
                || (mov.movingSpiral == 2 && !passedBy[row+1][col])
                || (mov.movingSpiral == 3 && !passedBy[row][col-1])
                || (mov.movingSpiral == 4 && !passedBy[row-1][col]))) {
                passedBy[row][col] = true;
            }else {
                passedBy[row][col] = true;
                mov.changeMovement();
            }
            switch (mov.movingSpiral) {
                case 1:
                    col += 1;
                case 2:
                    row += 1;
                case 3:
                    col -= 1;
                case 4:
                    row -= 1;
            }
        }
        return result;
    }

    public class Movement {
        protected int movingSpiral = 1;
        private void changeMovement() {
            if (this.movingSpiral == 4) {
                this.movingSpiral = 1;
            } else {
                this.movingSpiral += 1;
            }
        }
        public Movement(){}
    }
}
