package Math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt13 {
    public static void main(String[] args) {
        RomanToInt13 ri = new RomanToInt13();
        String s = "XXVV";
        String s2 = "MCMXCIV";
        char[] ca = s.toCharArray();
        System.out.println(ri.romanToInt(s));
        System.out.println(ri.romanToInt(s2));
    }
//    public int romanToInt(String s) {
//        int res = 0;
//        char[] charArray = s.toCharArray();
//        int[] digit = new int[s.length()];
//        for (int i = 0; i < s.length(); i++){
//            switch (charArray[i]){
//                case 'I': digit[i] = 1; break;
//                case 'V': digit[i] = 5; break;
//                case 'X': digit[i] = 10; break;
//                case 'L': digit[i] = 50; break;
//                case 'C': digit[i] = 100; break;
//                case 'D': digit[i] = 500; break;
//                case 'M': digit[i] = 1000; break;
//            }
//        }
//        for (int j = 0; j < digit.length; j++){
//            if (j < s.length() - 1){
//                if (digit[j] >= digit[j+1]){
//                    res += digit[j];
//                } else{
//                    res = res + (digit[j+1] - digit[j]);
//                    j++;
//                }
//            } else {
//                res += digit[j];
//            }
//        }
//        return res;
//    }
    // Using Map for storing number
    public int romanToInt(String s){
        int res = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (i < s.length() - 1){
                if (map.get(charArray[i]) >= map.get(charArray[i+1])){
                    res += map.get(charArray[i]);
                } else {
                    res = res + (map.get(charArray[i+1]) - map.get(charArray[i]));
                    i++;
                }
            } else {
                res += map.get(charArray[i]);
            }

        }
        return res;
    }
    static final Map<Character,Integer> map = new HashMap<Character, Integer>();
    static{
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }


}
