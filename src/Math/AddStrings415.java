package Math;

public class AddStrings415 {
    public static void main(String[] args) {
        AddStrings415 as = new AddStrings415();
        System.out.println(as.addStrings("23","12"));
    }
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() -1, j = num2.length() -1; i >= 0 || j>=0; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0'; //Convert char to an int
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y +carry) / 10;
        }
        return sb.reverse().toString();

    }
}
