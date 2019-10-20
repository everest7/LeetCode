package String;

/**
 * @author Vincent
 * @Date 2019-06-09
 */
public class RemoveDuplicateLetters316 {
    public static void main(String[] args) {
        RemoveDuplicateLetters316 rd = new RemoveDuplicateLetters316();
        System.out.println(rd.removeDuplicateLetters("bcabc"));
    }
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        int[] visited = new int[26];
        String res = "0";
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            map[ch - 'a']--;
            if (visited[ch - 'a'] != 0) continue;
            while (ch < res.charAt(res.length() - 1) && map[res.charAt(res.length() - 1) - 'a'] > 0) {
                visited[res.charAt(res.length() - 1) - 'a'] = 0;
                res = res.substring(0, res.length() - 1);
            }
            res += ch;
            visited[ch - 'a'] = 1;
        }
        return res.substring(1);

    }
}
