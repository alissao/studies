package leetcode.recursion1.complexityAnalysis;

import leetcode.TreeNode;

import java.util.Scanner;

public class maxDepthBinTree {

    public static void main (String[] args) {
        //TODO Fazer essa classe main funcionar. A lógica foi já aceita no leetcode.
        //make this main class work, cuz the logic is already working.
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o nível do seu número Fibonacci? ");
        String scanNumRows = scan.nextLine();
        int num = Integer.parseInt(scanNumRows);
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = 1 + maxDepth(root.left);
            int right = 1 + maxDepth(root.right);

            return left > right ? left : right;
        }
    }

}
