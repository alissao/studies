package leetcode.complexityAnalysis;

import java.util.Scanner;

public class pow {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número em double e a potência que deseja elevá-lo: ");
        String scanNumRows = scan.nextLine();
        String[] arrOfStr = scanNumRows.split(" ", 0);

        System.out.print(myPow(Double.parseDouble(arrOfStr[0]), Integer.parseInt(arrOfStr[1])));
    }


    public static double myPow(double x, int n) {
        double temp;
        if( n == 0)
            return 1;
        temp = myPow(x, n/2);

        if (n%2 == 0)
            return temp*temp;
        else
        {
            if(n > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

}
