package String;

public class ValidPalindromeII680 {

    public static void main(String[] args) {
        ValidPalindromeII680 vp = new ValidPalindromeII680();
        String s = "abca";
//        String s = "bececabbacecb";
        System.out.println(vp.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (extend(s, i - 1, i + 1) || extend(s, i, i + 2) || extend(s, i - 2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return (i == -1 && j == s.length());
    }

    /*
    Greedy approach
     */
//    public boolean validPalindrome(String s) {
//        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
//            if (s.charAt(i) != s.charAt(j)){
//                return isPalindrome(s.substring(i + 1, j + 1)) || isPalindrome(s.substring(i, j));
//            }
//        }
//        return true;
//    }


    /*
    Brute force. TLE
     */
//    public boolean validPalindrome(String s) {
//        if (isPalindrome(s)){
//            return true;
//        }
//        if (isPalindrome(s.substring(1)) || isPalindrome(s.substring(0, s.length() - 1))){
//            return true;
//        }
//        for (int i = 1; i < s.length() - 1; i++){
//            String st = s.substring(0, i) + s.substring(i + 1);
//            if (isPalindrome(st)){
//                return true;
//            }
//
//        }
//        return false;
//    }
//
//    public boolean isPalindrome(String sub){
//        int i = 0, j = sub.length() - 1;
//        while (i < j){
//            if (sub.charAt(i++) != sub.charAt(j--)){
//                return false;
//            }
//        }
//        return true;
//    }
//    public boolean validPalindrome(String s) {
//        boolean found = false;
//        for (int i = 0, j = s.length() - 1; i < j;) {
//            if (s.charAt(i) == s.charAt(j)) {
//                i++;
//                j--;
//            } else {
//                if (found) return false;
//                found = true;
//                if (s.charAt(i + 1) == s.charAt(j)) {
//                    i++;
//                } else if (s.charAt(i) == s.charAt(j - 1)) {
//                    j--;
//                }
//            }
//
//        }
//        return true;
//    }
}
