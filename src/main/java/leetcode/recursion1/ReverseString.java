package leetcode.recursion1;

import java.util.*;

public class ReverseString {

    public static void main(String[] args) {

    }

    public class Solution {
        public void ReverseString (char[] s) {
            int pointerA = 0;
            int pointerB = s.length-1;

            while (pointerA <= pointerB) {
                char temp = s[pointerA];
                s[pointerA] = s[pointerB];
                s[pointerB] = temp;

                pointerA += 1;
                pointerB += 1;
            }
        }
    }

    public String reverseVowels(String s) {
        int pointerA = 0;
        int pointerB = s.length()-1;

        while (pointerA <= pointerB) {
            if (s.charAt(pointerA) == 'a' || s.charAt(pointerA) =='A' || s.charAt(pointerA) =='e' ||
                    s.charAt(pointerA) =='E' || s.charAt(pointerA) =='i' || s.charAt(pointerA) =='I' ||
                    s.charAt(pointerA) =='o' || s.charAt(pointerA) =='O' || s.charAt(pointerA) =='u' ||
                    s.charAt(pointerA) =='U') {
                        while (pointerB >= pointerA) {
                            if (s.charAt(pointerB ) == 'a' || s.charAt(pointerB ) =='A' ||
                                    s.charAt(pointerB ) =='e' || s.charAt(pointerB ) =='E' ||
                                    s.charAt(pointerB ) =='i' || s.charAt(pointerB ) =='I' ||
                                    s.charAt(pointerB ) =='o' || s.charAt(pointerB ) =='O' ||
                                    s.charAt(pointerB ) =='u' || s.charAt(pointerB ) =='U') {
                                StringBuilder string = new StringBuilder(s);
                                char temp = s.charAt(pointerA);
                                string.setCharAt(pointerA, s.charAt(pointerB));
                                string.setCharAt(pointerB, temp);
                                s = string.toString();
                                pointerB -= 1;
                                break;
                            }
                            pointerB -= 1;
                        }
            }
            pointerA += 1;
        }
        return s;
    }
}