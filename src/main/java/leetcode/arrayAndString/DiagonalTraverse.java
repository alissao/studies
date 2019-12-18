package leetcode.arrayAndString;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int row = 0, col = 0;
        int i = matrix.length;
        int j = matrix[0].length;
        int [] result = new int[matrix.length * matrix[0].length];
        for (int k = 0; k < result.length; k++){
            result[k] = matrix[row][col];

            if ((row + col) % 2 == 0) {
                if (col == j - 1){
                    row++;
                }else if (row == 0) {
                    col++;
                }else {
                    row--;
                    col++;
                }
            }else {
                if (row == i - 1) {
                    col++;
                }else if (col == 0) {
                    row++;
                }else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }

}
