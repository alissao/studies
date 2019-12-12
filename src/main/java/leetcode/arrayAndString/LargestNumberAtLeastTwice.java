package leetcode.arrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumberAtLeastTwice {

    public static void main(String[] args) {

        System.out.println("Digite seu array: ");
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        while (scan.hasNextInt()) {
            numbers.add(scan.nextInt());
        }
        int[] nums = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            nums[i] = numbers.get(i);
        }

        System.out.println(dominantIndex(nums));

    }

    public static int dominantIndex(int[] nums) {
        int biggestIndex = findBiggest(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != biggestIndex) {
                if (nums[i] > (nums[biggestIndex] / 2)) {
                    return -1;
                }
            }
        }
        return biggestIndex;
    }

    private static int findBiggest(int[] nums) {
        int largerIndex = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > nums[largerIndex]) {
                largerIndex = j;
            }
        }
        return largerIndex;
    }

}
