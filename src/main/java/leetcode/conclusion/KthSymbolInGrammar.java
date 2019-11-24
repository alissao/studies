package leetcode.conclusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthSymbolInGrammar {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite na mesma linha o nível e a posição do número que deseja saber: ");
        String scanNumRows = scan.nextLine();
        String[] arrOfStr = scanNumRows.split(" ", 0);
        int num1 = Integer.parseInt(arrOfStr[0]);
        int num2 = Integer.parseInt(arrOfStr[1]);

        System.out.println(kthGrammar(num1, num2));
    }

    //my solution here works, but exceeds leetcode memory limit.
    //down there you'll find a code that works for leet code with recursive thinking.
    public static int kthGrammar(int N, int K) {

        List<List<Integer>> nGrammar = generate(N);
        int kth = nGrammar.get(N-1).get(K-1);
        return kth;

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nu = new ArrayList<Integer>();
        nu.add(0);
        result.add(nu);
        if (numRows == 1) {
            return result;
        }

        for (int i = 1; i <= numRows; i++){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            int j = 0;

            nu = result.get(i-1);
            while (j <= nu.size()-1){
                if (nu.get(j) == 0) {
                    cur.add(0);
                    cur.add(1);
                }else {
                    cur.add(1);
                    cur.add(0);
                }
            }
            result.add(cur);
        }
        return result;
    }

    /* this code works on leetcode
    public static int kthGrammar(int N, int K) {
        if (N == 1) return 0;

        int r1 = (K + 1) / 2;
        int r2 = (K + 1) % 2;
        int prev = kthGrammar(N - 1, r1);
        return prev == 0 ? (r2 == 0 ? 0 : 1) : (r2 == 0 ? 1 : 0);
    }
     */

}
