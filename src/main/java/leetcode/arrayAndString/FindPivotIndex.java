package leetcode.arrayAndString;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 || i != nums.length-1) {
                int leftSum = sumLeft(nums, i);
                int rightSum = sumRight(nums, i);
                if (leftSum == rightSum) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int sumRight(int[] nums, int pivot) {
        int sumL = 0;
        for (int j = pivot; j >= 0; j--){
            sumL += nums[j];
        }
        return sumL;
    }

    private int sumLeft(int[] nums, int pivot) {
        int sumR = 0;
        for (int k = pivot; k < nums.length; k++){
            sumR += nums[k];
        }
        return sumR;
    }

}
