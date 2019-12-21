package leetcode.arrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println("Sua matriz vai ser de x por x. Insira esses dois números: ");
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int matriz[][] = new int[r][c];
        System.out.println("Insira os números da sua matriz na mesma linha: ");
        List<Integer> numMatriz = new ArrayList<Integer>();
        try {
            for (int i = 0; i < (r*c); i++) {
                numMatriz.add(scan.nextInt());
            }
        }catch (Exception e){
            System.out.println("Houve algo de errado com os números que você digitou.");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return result;
        }

        int row = 0;
        int col = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int numbsInMatrix = rows*cols;
        boolean[][] passedBy = new boolean[rows][cols];
        Movement mov = new Movement();

        for (int k = 0; k < numbsInMatrix; k++){
            result.add(matrix[row][col]);

            /* this condition below is for checking the limits and also
             * if the spiral passed by the next number from the matrix.
             */
            if (((0 <= row && row < rows) && (0 <= col && col < cols)) &&
                ((mov.getMovingSpiral() == 1 && !passedBy[row][col+1])
                || (mov.getMovingSpiral() == 2 && !passedBy[row+1][col])
                || (mov.getMovingSpiral() == 3 && !passedBy[row][col-1])
                || (mov.getMovingSpiral() == 4 && !passedBy[row-1][col]))) {
                    passedBy[row][col] = true;
            }else {
                passedBy[row][col] = true;
                mov.changeMovement();
            }
            switch (mov.getMovingSpiral()) {
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

    public static class Movement {
        private int movingSpiral = 1;

        public int getMovingSpiral() {
            return movingSpiral;
        }

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
