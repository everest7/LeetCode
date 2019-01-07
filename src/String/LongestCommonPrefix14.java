package String;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix14 lc = new LongestCommonPrefix14();
        System.out.println(lc.longestCommonPrefix(strs));
    }

    // Divide and Conquer
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        return lcp(strs, 0, strs.length - 1);
    }

    public String lcp(String[] strs, int left, int right){
        if (left == right){
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String leftlcp = lcp(strs, left, mid);
            String rightlcp = lcp(strs, mid + 1, right);
            return commomPrefix(leftlcp, rightlcp);
        }
    }

    public String commomPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++){
            if (left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    // Time Complexity: O(n * m), where n is the length of strs, m is the length
    // of the longest string
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) return "";
//        String res = strs[0];
//        for (int i = 1; i < strs.length; i++){
//            while (strs[i].indexOf(res) != 0){
//                res = res.substring(0, res.length() - 1);
//            }
//        }
//        return res;
//    }
}
