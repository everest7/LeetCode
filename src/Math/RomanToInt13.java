package Math;

public class RomanToInt13 {
    public static void main(String[] args) {
        RomanToInt13 ri = new RomanToInt13();
        String s = "XXVV";
        String s2 = "MCMXCIV";
        char[] ca = s.toCharArray();
        System.out.println(ri.romanToInt(s));
        System.out.println(ri.romanToInt(s2));
    }
    public int romanToInt(String s) {
        int res = 0;
        char[] charArray = s.toCharArray();
        int[] digit = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            switch (charArray[i]){
                case 'I': digit[i] = 1; break;
                case 'V': digit[i] = 5; break;
                case 'X': digit[i] = 10; break;
                case 'L': digit[i] = 50; break;
                case 'C': digit[i] = 100; break;
                case 'D': digit[i] = 500; break;
                case 'M': digit[i] = 1000; break;
            }
        }
        for (int j = 0; j < digit.length; j++){
            if (j < s.length() - 1){
                if (digit[j] >= digit[j+1]){
                    res += digit[j];
                } else{
                    res = res + (digit[j+1] - digit[j]);
                    j++;
                }
            } else {
                res += digit[j];
            }
        }
        return res;
    }

}
