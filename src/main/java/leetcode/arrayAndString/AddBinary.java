package leetcode.arrayAndString;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sB = new StringBuilder();
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int carry = 0;

        while (aLen >= 0 || bLen >= 0) {
            int sum = carry;
            if (aLen >= 0) sum += a.charAt(aLen) - '0';
            if (bLen >= 0) sum += b.charAt(bLen) - '0';
            sB.append(sum % 2);
            carry = (sum / 2);

            aLen--;
            bLen--;
        }

        if (carry != 0) sB.append(carry);
        return sB.reverse().toString();

    }



}
