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
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++){
                    matriz[i][j] = scan.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("Houve algo de errado com os números que você digitou.");
        }
        SpiralMatrix spiral = new SpiralMatrix();
        numMatriz = spiral.spiralOrder(matriz);
        System.out.println("Sua matriz em espiral é: ");
        System.out.println(numMatriz);
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

            //checks the limits and changes the movement
            mov.isOnTheLimit(row,col,rows,cols,passedBy);

            switch (mov.getMovingSpiral()) {
                case 1:
                    col += 1;
                    break;
                case 2:
                    row += 1;
                    break;
                case 3:
                    col -= 1;
                    break;
                case 4:
                    row -= 1;
                    break;
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

        private void isOnTheLimit (int row,int col, int rows, int cols, boolean[][] passedBy){
            switch (this.movingSpiral){
                case 1:
                    if (col == cols-1){
                        changeMovement();
                        break;
                    }else{
                        if (passedBy[row][col+1]){
                            changeMovement();
                        }
                        break;
                    }
                case 2:
                    if (row == rows-1){
                        changeMovement();
                        break;
                    }else{
                        if (passedBy[row+1][col]){
                            changeMovement();
                        }
                        break;
                    }
                case 3:
                    if (col == 0){
                        changeMovement();
                        break;
                    }else{
                        if (passedBy[row][col-1]){
                            changeMovement();
                        }
                        break;
                    }
                case 4:
                    if (row == 0){
                        changeMovement();
                        break;
                    }else{
                        if (passedBy[row-1][col]){
                            changeMovement();
                        }
                        break;
                    }
            }
            passedBy[row][col] = true;
        }

        public Movement(){}
    }
}
