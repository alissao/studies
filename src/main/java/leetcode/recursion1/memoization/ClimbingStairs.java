package leetcode.recursion1.memoization;

import java.util.HashMap;
import java.util.Scanner;

public class ClimbingStairs {

    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos degraus tem sua escada? ");
        String scanNumRows = scan.nextLine();
        int num = Integer.parseInt(scanNumRows);
        ClimbingStairs climb = new ClimbingStairs();

        System.out.print("Você pode subi-la de " + climb.climbStairs(num) + " maneiras!");
    }

    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return climbStairs(0, n, memo);
    }

    public int climbStairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs(i+1, n, memo) + climbStairs(i+2, n, memo);
        return memo[i];
    }
}
