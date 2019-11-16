package leetcode.memoization;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciHashMap {

    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o nível do seu número Fibonacci? ");
        String scanNumRows = scan.nextLine();
        int num = Integer.parseInt(scanNumRows);
        FibonacciHashMap fibo = new FibonacciHashMap();

        System.out.print("Seu número Fibonacci é " + fibo.fib(num) );
    }

    private int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N-1) + fib(N-2);
        }
        // keep the result in cache.
        cache.put(N, result);
        return result;
    }
}
