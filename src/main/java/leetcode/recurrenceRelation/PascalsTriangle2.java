package leetcode.recurrenceRelation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite qual linha quer saber: ");
        String scanNumRows = scan.nextLine();
        int num = Integer.parseInt(scanNumRows);

        System.out.print(getRow(num));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = new ArrayList<Integer>();

        pre.add(1);
        triangle.add(pre);
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            triangle.add(cur);
            pre = cur;
        }
        return pre;
    }

}
