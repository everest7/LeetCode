package Math;

import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) {
        PlusOne66 po = new PlusOne66();
        int[] digits = {4,3,2,9};
        int[] digits2 = {9,8,7,6,5,4,3,2,1,0};
        int[] digits3 = {8,9,9,9};
        System.out.println(Arrays.toString(po.plusOne(digits)));
        System.out.println(Arrays.toString(po.plusOne(digits3)));
    }
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
//    public int[] plusOne(int[] digits) {
//        int sum = 0;
//        for (int i = 0; i < digits.length; i++){
//            sum += digits[i] * Math.pow(10,digits.length - i - 1); //Calculate the interger
//        }
//        sum += 1; // Plus one
//        String s = Integer.toString(sum);
//        int[] res = new int[s.length()];
//        for (int j = 0; j < s.length(); j++){
//            res[j] = s.charAt(j) -'0';
//        }
//        return res;
//
//
//    }
}
