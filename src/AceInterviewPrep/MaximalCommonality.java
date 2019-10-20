package AceInterviewPrep;


public class MaximalCommonality {
    public static void main(String[] args) {
        System.out.println(curString("abcdedeara"));
    }

    public static int curString(String s) {
        int[] total = new int[26];
        for (char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }
        int[] left = new int[26];
        int result = 0;
        for (char ch : s.toCharArray()) {
            left[ch - 'a']++;
            total[ch - 'a']--;
            result = Math.max(result, commonality(left, total));
        }
        return result;
    }

    public static int commonality(int[] left, int[] total) {
        int common = 0;
        for (int i = 0; i < 26; i++) {
            common += Math.min(left[i], total[i]);
        }
        return common;
    }
}
