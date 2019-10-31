package leetcode.recursion1;

public class PrincipleOfRecursion {

    public static void main (String[] args) {
        char[] string = new char[7];
        string [0] = 'A';
        string [1] = 'l';
        string [2] = 'i';
        string [3] = 's';
        string [4] = 's';
        string [5] = 'o';
        string [6] = 'n';

        printReverse(string);
    }

    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }
}
