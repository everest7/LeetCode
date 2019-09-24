package String;

import java.util.Stack;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String st = "A man, a plan, a canal: Panama";
        String st2 = "race a car";
        ValidPalindrome125 vp = new ValidPalindrome125();
        System.out.println(vp.isPalindrome(st));
    }

//    public boolean isPalindrome(String s) {
//        String t = s.toLowerCase();
//        char[] ts = t.toCharArray();
//        int i = 0, j = ts.length - 1;
//        while (i < j) {
//            if (!Character.isLetterOrDigit(ts[i])) i++;
//            if (!Character.isLetterOrDigit(ts[j])) j--;
//            if (ts[i] != ts[j]) return false;
//            i++;
//            j--;
//        }
//        return true;
//    }


    // Using Two Pointer
    public boolean isPalindrome(String s){
        if (s.length() == 1) return true;
        String st = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int low = 0;
        int high = st.length() - 1;
        while (low < high){
            if (st.charAt(low) == st.charAt(high)){
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    // Using Stack
//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase();
//        Stack<Character> stack = new Stack<>();
//        for (char ch: s.toCharArray()){
//            if (Character.isAlphabetic(ch)){
//                stack.push(ch);
//            }
//        }
//        for (int i = 0; i < s.length(); i++){
//            if (Character.isLetterOrDigit(s.charAt(i))){
//                if (stack.pop() != s.charAt(i)){
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
}
