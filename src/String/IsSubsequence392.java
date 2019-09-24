package String;

public class IsSubsequence392 {
    public static void main(String[] args) {
        IsSubsequence392 is = new IsSubsequence392();
        String s = "abc";
        String t = "nambxa";
        System.out.println(is.isSubsequence(s, t));
    }

    // Using two pointer
//    public boolean isSubsequence(String s, String t) {
//        int i = 0, j = 0;
//        while (i < s.length() && j < t.length()){
//            if (s.charAt(i) == t.charAt(j)){
//                i++;
//                j++;
//            } else {
//                j++;
//            }
//        }
//        if (i == s.length()){
//            return true;
//        } else{
//
//            return false;
//        }
//    }

    public boolean isSubsequence(String s, String t){
        int prev = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            prev = t.indexOf(ch, prev);
            if (prev == -1) return false;
            prev++;
        }
        return true;
    }
}
