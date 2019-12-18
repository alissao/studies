package leetcode.arrayAndString;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int index = digits.length;
        return plusOne(digits, index);
    }

    public int[] plusOne(int[] digits, int index) {
        if (index != 0) {
            if (digits[index-1] == 9) {
                digits[index-1] = 0;
                return digits = plusOne(digits, index-1);
            }else {
                digits[index-1]++;
                return digits;
            }
        }else {
            if (digits[index-1] == 9){
                int[] newDigit = new int[digits.length+1];
                newDigit[0] = 1;
                for (int i = 0; i < digits.length; i++){
                    if (digits[i] == 9){
                        digits[i] = 0;
                    }
                    newDigit[i+1] = digits[i];
                }
                return newDigit;
            }else {
                digits[index-1]++;
                return digits;
            }
        }
    }

}
