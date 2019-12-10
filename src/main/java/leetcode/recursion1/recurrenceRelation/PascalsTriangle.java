package leetcode.recursion1.recurrenceRelation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite quantas linhas (inteiro) terá o triângulo: ");
        String scanNumRows = scan.nextLine();
        int num = Integer.parseInt(scanNumRows);

        System.out.print(generate(num));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }

        ArrayList<Integer> pre = new ArrayList<Integer>();

        pre.add(1);
        result.add(pre);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            result.add(cur);
            pre = cur;
        }
        return result;
    }

}
