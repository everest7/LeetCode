package String;

public class IntegertoRoman12 {
    public static void main(String[] args) {
        IntegertoRoman12 ir = new IntegertoRoman12();
        System.out.println(ir.intToRoman(58));
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int i = 0; i < nums.length; i++) {
            while(num >= nums[i]) {
                num -= nums[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}
